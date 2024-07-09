package Scripts;

import Exceptions.SiteNotFoundException;
import Helpers.GeneralHelper;
import Learning.defaultExample;

public abstract class defaultScriptSetup extends defaultExample {

    /**
     * You can directly use the key for the site,
     * to use the site URLs from {@code GenericHelper }
     * */
    protected String SiteUrlKey;

    public defaultScriptSetup() {
        this.SiteUrlKey = "CHARUSAT_RESULT";
    }

    /**
     * This method will give you the current site url.
     *
     * @return String format of current site URL
     * */
    public String getSiteUrl() {
        try {
            return GeneralHelper.getSiteUrl(this.SiteUrlKey);
        } catch (SiteNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will directly set the site URL string
     * allowing you the little more flexibility to set
     * site URLs.
     * */
    public void setSiteUrl(String URL) {
        this.SiteUrl = URL;
    }

    /**
     * This method will give you the current key
     * that you may have configured by yourself.
     *
     * @return string format of site URLs key!
     * */
    public String getSiteUrlKey() {
        return this.SiteUrlKey;
    }

    /**
     * This method will set the site URL key and also,
     * it will make sure to update site URL.
     * */
    public void setSiteUrlKey(String key) {
        this.SiteUrlKey = key;
        this.SiteUrl = getSiteUrl();
    }

}
