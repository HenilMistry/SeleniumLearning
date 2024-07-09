package Learning;

import org.openqa.selenium.By;

/**
 * This class extends the default example, and it will
 * show you that how you can select the web element by
 * its name attribute selector. Also, note that it is
 * very basic demonstration.
 * */
public class c_ExploringName extends defaultExample {
    public c_ExploringName() {
        // loading the site...
        driver.get(this.SiteUrl);
        // finding the element by its name attribute selector
        driver.findElement(By.name("txtEnrNo")).sendKeys("20CE054");;
        // finding web element by its name attribute selector and performing clicking action...
        driver.findElement(By.name("btnSearch")).click();

        waitAndCloseDriver();
    }

    public static void main(String[] args) {

        new c_ExploringName();

    }
}
