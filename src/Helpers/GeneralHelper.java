package Helpers;

import Exceptions.SiteNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is helper class that you can use
 * to set up driver path and manage site URLs,
 * you can declare various driver paths and
 * various site URLs, and later you can use this
 * directly into your project or example.
 * */
public class GeneralHelper {

    /**
     * You can put various driver paths here!
     * */
    private static final String DRIVER_PATH = "/Users/henil/Downloads/chromedriver-mac-arm64/chromedriver";

    /**
     * You can put various site URLs here!
     * */
    private static final Map<String, String> EXAMPLE_SITES;
    static {
        EXAMPLE_SITES = new HashMap<>();
        EXAMPLE_SITES.put("CHARUSAT_RESULT","https://charusat.edu.in:912/Uniexamresult/");
        EXAMPLE_SITES.put("WHATS_APP","https://web.whatsapp.com/");
        EXAMPLE_SITES.put("YOUTUBE", "https://www.youtube.com/");
    }

    /**
     * This method will check that whether
     * the passed URL's Key is there in default
     * settings or not!
     *
     * @param key : The key of URL that you want to make sure that exists in example sites.
     * @return boolean indicating true if passed key exists, false otherwise.
     * */
    public static boolean siteExists(String key) {
        boolean exists = false;

        for (String mapKey : EXAMPLE_SITES.keySet()) {
            if (mapKey.compareToIgnoreCase(key) == 0) {
                exists = true;
                break;
            }
        }

        return exists;
    }

    /**
     * This method will give you the site URL for the passed key,
     * it will throw SiteNotFoundException if passed key doesn't
     * found!
     *
     * @param key : The key for the site's URL.
     * @return The string URL for the passed key.
     * @throws SiteNotFoundException in case of key doesn't exist in Examples Site.
     * */
    public static String getSiteUrl(String key) throws SiteNotFoundException {
        if (!siteExists(key)) {
            throw new SiteNotFoundException();
        } else {
            return EXAMPLE_SITES.get(key);
        }
    }

    /**
     * This method will give you driver path!
     *
     * @return String value of current driver path!
     * */
    public static String getDriverPath() {
        return DRIVER_PATH;
    }

}
