package com.contentstack.sdk;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * The type Config test.
 */
public class ConfigTest {

    private final static String DEFAULT_BRANCH = "master";
    private static Config configInstance;

    /**
     * Before all.
     */
    @BeforeClass
    public static void beforeAll() {
        configInstance = new Config();
        assertNull(configInstance.getBranch());
        configInstance.setBranch(DEFAULT_BRANCH);
    }


    /**
     * Test branch getter.
     */
    @Test
    public void testBranchGetter() {
        assertEquals(DEFAULT_BRANCH, configInstance.getBranch());
    }

    /**
     * Test branch setter.
     */
    @Test
    public void testBranchSetter() {
        String updatedBranch = configInstance.getBranch();
        assertEquals(DEFAULT_BRANCH, updatedBranch);
    }

    /**
     * Test branch variable.
     */
    @Test
    public void testBranchVariable() {
        String branchVariable = configInstance.branch;
        assertEquals(DEFAULT_BRANCH, branchVariable);
    }

    /**
     * Test branch in config.
     *
     * @throws Exception the exception
     */
    @Test
    public void testBranchInConfig() throws Exception {
        Stack stack = Contentstack.stack("demoStackApiKey",
                "demoDeliveryToken",
                "environment", configInstance);

        String branch = stack.config.branch;
        assertEquals(DEFAULT_BRANCH, branch);
    }

    @Test
    public void testAPIBranchInConfig() throws Exception {

        Dotenv dotenv = Dotenv.load();
        String BRANCH_API_KEY = dotenv.get("BRANCH_API_KEY");
        String BRANCH_DELIVERY_TOKEN = dotenv.get("BRANCH_DELIVERY_TOKEN");
        String BRANCH_ENV = dotenv.get("BRANCH_ENVIRONMENT");
        String BRANCH_HOST = dotenv.get("BRANCH_HOST");

        configInstance.setHost(BRANCH_HOST);
        assert BRANCH_API_KEY != null;
        Stack stack = Contentstack.stack(BRANCH_API_KEY,
                BRANCH_DELIVERY_TOKEN, BRANCH_ENV, configInstance);

        Query queryInstance = stack.contentType("branchtestcase").query();
        queryInstance.find(new QueryResultsCallBack() {
            @Override
            public void onCompletion(ResponseType responseType, QueryResult queryresult, Error error) {
                if (error == null) {
                    JSONArray arrayEntry = queryresult.receiveJson.getJSONArray("entries");
                    for (Object entry : arrayEntry) {
                        JSONObject map = (JSONObject) entry;
                        boolean isBranchAvail = map.has("_branches");
                        JSONArray _branches = map.optJSONArray("_branches");
                        assertTrue(isBranchAvail);
                        assertEquals(DEFAULT_BRANCH, _branches.get(0));
                    }
                }
            }
        });
    }

}