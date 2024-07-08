package Helpers;

import Exceptions.SiteNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class GeneralHelper {

    private static final String DRIVER_PATH = "/Users/henil/Downloads/chromedriver-mac-arm64/chromedriver";
    private static final Map<String, String> EXAMPLE_SITES;
    static {
        EXAMPLE_SITES = new HashMap<>();
        EXAMPLE_SITES.put("CHARUSAT_RESULT","https://charusat.edu.in:912/Uniexamresult/");
        EXAMPLE_SITES.put("WHATS_APP","https://web.whatsapp.com/");
        EXAMPLE_SITES.put("YOUTUBE", "https://www.youtube.com/");
    }

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

    public static String getSiteUrl(String key) throws SiteNotFoundException {
        if (!siteExists(key)) {
            throw new SiteNotFoundException();
        } else {
            return EXAMPLE_SITES.get(key);
        }
    }

    public static String getDriverPath() {
        return DRIVER_PATH;
    }

}
