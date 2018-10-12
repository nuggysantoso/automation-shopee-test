package common;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nuggy Santoso on 10/12/2018
 */
public class DriverBuilder {
    private static WebDriver webDriver = null;
    private static int[] screenDimension;

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver() {
        switch (System.getProperty("os.name").toLowerCase()) {
            case "mac":
                System.setProperty(Constants.DEFAULT_CHROME_PROPERTY, Constants.DEFAULT_PATH_CHROME_DRIVER_MAC);
                break;
            case "windows":
                System.setProperty(Constants.DEFAULT_CHROME_PROPERTY, Constants.DEFAULT_PATH_CHROME_DRIVER_WINDOWS);
                break;
        }
        webDriver = new ChromeDriver();
        webDriver.manage().window().setPosition(new Point(0,0));
        webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(getScreenDimension()[0], getScreenDimension()[1]));
        webDriver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public static int[] getScreenDimension(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        screenDimension = new int[]{width, height};
        return screenDimension;
    }
}
