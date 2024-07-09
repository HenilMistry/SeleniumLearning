package Learning;

import org.openqa.selenium.By;

/**
 * This class extends default example, and it
 * will show you that how you can find web elements by
 * id, also note that it is very basic demonstration.
 * */
public class a_ExploringId extends defaultExample {

    public a_ExploringId() {
        // loading the site...
        driver.get(SiteUrl);
        // finding element by id and sending some data in field...
        driver.findElement(By.id("txtEnrNo")).sendKeys("20CE054");
        // finding element by id and clicking on it...
        driver.findElement(By.id("btnSearch")).click();

        waitAndCloseDriver();
    }

    public static void main(String[] args) {
        new a_ExploringId();
    }

}
