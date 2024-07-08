package Learning;

import org.openqa.selenium.By;

public class a_ExploringId extends defaultExample {

    public a_ExploringId() {
        // loading the site...
        driver.get(SiteUrl);
        // finding element by id and sending some data in field...
        driver.findElement(By.id("txtEnrNo")).sendKeys("20CE054");
        // finding element by id and clicking on it...
        driver.findElement(By.id("btnSearch")).click();

        closeDriver();
    }

    public static void main(String[] args) {
        new a_ExploringId();
    }

}
