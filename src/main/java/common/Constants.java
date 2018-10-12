package common;

/**
 * Created by Nuggy Santoso on 10/12/2018
 */
public class Constants {
    public static final String DEFAULT_WEBDRIVER_NAME = "Chrome";
    public static final String DEFAULT_CHROME_PROPERTY = "webdriver.chrome.driver";
    public static final String DEFAULT_PATH_CHROME_DRIVER_MAC = System.getProperty("user.dir") + "/src/test/resources/mac/chromedriver";
    public static final String DEFAULT_PATH_CHROME_DRIVER_WINDOWS = System.getProperty("user.dir") + "/src/test/resources/windows/chromedriver";
    public static final String DEFAULT_WEB_URL_GIST = "https://gist.github.com/discover";
    public static final int DEFAULT_TIMEOUT = 10;
}
