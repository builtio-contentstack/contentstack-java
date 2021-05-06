package com.contentstack.sdk;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

/**
 * The type Config test.
 */
public class ConfigTest {

    private static Config configInstance;

    /**
     * Before all.
     */
    @BeforeClass
    public static void beforeAll() {
        configInstance = new Config();
        assertNull(configInstance.getBranch());
        configInstance.setBranch("developer");
    }


    /**
     * Test branch getter.
     */
    @Test
    public void testBranchGetter() {
        assertEquals("developer", configInstance.getBranch());
    }

    /**
     * Test branch setter.
     */
    @Test
    public void testBranchSetter() {
        String updatedBranch = configInstance.getBranch();
        assertEquals("developer", updatedBranch);
    }

    /**
     * Test branch variable.
     */
    @Test
    public void testBranchVariable() {
        String branchVariable = configInstance.branch;
        assertEquals("developer", branchVariable);
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
        assertEquals("developer", branch);
    }

}