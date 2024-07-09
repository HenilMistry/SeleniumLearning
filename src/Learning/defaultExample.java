package Learning;

import Exceptions.SiteNotFoundException;
import Helpers.GeneralHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public abstract class defaultExample {
    protected final String DriverPath = GeneralHelper.getDriverPath();
    public String SiteUrl;
    protected WebDriver driver;

    /**
     * This method will set up the web driver
     * Since, it is default example, you can
     * mention primary settings to be set over here.
     * */
    public defaultExample()  {
        try {
            SiteUrl = GeneralHelper.getSiteUrl("CHARUSAT_RESULT");
            System.setProperty("webdriver.chrome.driver", DriverPath);
            this.driver = new ChromeDriver();
            // to maximize the window...
            driver.manage().window().maximize();
            // waiting time (40 sec.) for page to be fully loaded...
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            // waiting time before throwing an error for finding an element...
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (SiteNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will wait for user's input before
     * closing and quiting the web driver. You can
     * put and post script, post-processing stuff here
     * in this method.
     * */
    public void waitAndCloseDriver() {
        // waiting for user input before closing...
        char c = new Scanner(System.in).next().charAt(0);
        driver.close();
        driver.quit();
    }
}
