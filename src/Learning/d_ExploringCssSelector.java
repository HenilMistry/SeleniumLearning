package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * This class extends default example, and it will
 * show you that how you can user Css Selector to
 * grab web elements and perform some actions.
 * */
public class d_ExploringCssSelector extends defaultExample {

    public d_ExploringCssSelector() {
        // loading the site...
        driver.get(SiteUrl);
        /*
          if it is id,
          In css selector : use #
          -> selection of unique element

          if it is class,
          In css selector use .
          -> may be selection of multiple elements
          */
        // creating anonymous object and selecting by visible text...
        new Select(this.driver.findElement(By.cssSelector("#ddlInst"))).selectByVisibleText("CSPIT");
        new Select(this.driver.findElement(By.cssSelector("#ddlDegree"))).selectByVisibleText("BTECH(CE)");
        new Select(this.driver.findElement(By.cssSelector("#ddlSem"))).selectByVisibleText("8");
        new Select(this.driver.findElement(By.cssSelector("#ddlScheduleExam"))).selectByVisibleText("APRIL 2024");
        // finding element by id and sending some data in field...
        driver.findElement(By.id("txtEnrNo")).sendKeys("20CE054");
        // finding element by id and clicking on it...
        driver.findElement(By.id("btnSearch")).click();

        this.waitAndCloseDriver();
    }

    public static void main(String[] args) {
        new d_ExploringCssSelector();
    }

}
