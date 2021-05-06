package com.contentstack.sdk;

/**
 * Configuration Support for contentstack
 */
public class Config {

    protected String URLSCHEMA = "https://";
    protected String URL = "cdn.contentstack.io";
    protected String VERSION = "v3";
    protected String environment = null;
    protected ContentstackRegion region = ContentstackRegion.US;
    protected String branch;

    /**
     * Config constructor
     *
     * <br><br><b>Example :</b><br>
     * <pre class="prettyprint">
     * Config config = new Config();
     * </pre>
     */
    public Config() {
    }

    /**
     * Gets branch.
     *
     * @return the branch
     */
    public String getBranch() {
        return this.branch;
    }

    /**
     * Sets branch.
     *
     * @param branch the branch
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public ContentstackRegion getRegion() {
        return this.region;
    }

    /**
     * Sets region allow you to set your region for the Contentstack server.
     *
     * @param region type {@link ContentstackRegion}
     * @return ContentstackRegion  <p> <b>Note:</b> Default region sets to us <br><br><b>Example :</b><br> <pre class="prettyprint"> config.setRegion(ContentstackRegion.US); </pre>
     */
    public ContentstackRegion setRegion(ContentstackRegion region) {
        this.region = region;
        return this.region;
    }

    /**
     * Gets host.
     *
     * @return URL String <br><br><b>Example :</b><br> <pre class="prettyprint"> String url = config.getHost(); </pre>
     */
    public String getHost() {
        return URL;
    }

    /**
     * Sets host name of the Contentstack server.
     *
     * @param hostName host name.<p><b>Note:</b> Default hostname sets to <a href ="https://cdn.contentstack.io"> cdn.contentstack.io </a>                 and default protocol is HTTPS.                 <br><br><b>Example :</b><br>                 <pre class="prettyprint">                                 config.setHost("cdn.contentstack.io");                                 </pre>
     */
    public void setHost(String hostName) {
        if (hostName != null && !hostName.isEmpty()) {
            URL = hostName;
        }
    }

    /**
     * Get version of the Contentstack server.
     *
     * @return VERSION String <br><br><b>Example :</b><br> <pre class="prettyprint"> String version = config.getVersion(); </pre>
     */
    public String getVersion() {
        return VERSION;
    }

    /**
     * Changes the Contentstack version to be used in the final URL.
     *
     * @param version version string.
     *
     *                <br><br><b>Example :</b><br>
     *                <pre class="prettyprint">
     *                                                                                 config.setVersion("v3");
     *                                                                            </pre>
     */
    private void setVersion(String version) {
        if (version != null && !version.isEmpty()) {
            VERSION = version;
        }
    }

    /**
     * Get environment.
     *
     * @return param environment string <br><br><b>Example :</b><br> <pre class="prettyprint">  String environment = config.getEnvironment(); </pre>
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * set environment.
     *
     * @param environment uid/name                    <br><br><b>Example :</b><br>                    <pre class="prettyprint">                                        config.setEnvironment("stag", false);                                       </pre>
     */
    protected void setEnvironment(String environment) {
        if (environment != null && !environment.isEmpty()) {
            this.environment = environment;
        }

    }

    /**
     * The enum Contentstack region.
     */
    public enum ContentstackRegion {
        /**
         * Us contentstack region.
         */
        US,
        /**
         * Eu contentstack region.
         */
        EU
    }

}

