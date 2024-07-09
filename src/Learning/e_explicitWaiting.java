package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class extends default example, and it will show
 * you the demonstration of using explicit waiting in
 * selenium script.
 *
 * Explicit waiting means that you need to wait for certain condition is met
 * like loading of some element!
 * */
public class e_explicitWaiting extends defaultExample {

    public e_explicitWaiting() {
        // loading the site...
        driver.get(SiteUrl);

        // creating anonymous object and selecting by visible text...
        new Select(this.driver.findElement(By.cssSelector("#ddlInst"))).selectByVisibleText("CSPIT");
        new Select(this.driver.findElement(By.cssSelector("#ddlDegree"))).selectByVisibleText("BTECH(CE)");
        new Select(this.driver.findElement(By.cssSelector("#ddlSem"))).selectByVisibleText("8");
        new Select(this.driver.findElement(By.cssSelector("#ddlScheduleExam"))).selectByVisibleText("APRIL 2024");
        // finding element by id and sending some data in field...
        driver.findElement(By.id("txtEnrNo")).sendKeys("20CE054");
        // finding element by id and clicking on it...
        driver.findElement(By.id("btnSearch")).click();


        // explicit waiting for the element to be loaded and getting information out of it...
        WebDriverWait explicitWait = new WebDriverWait(this.driver, Duration.ofSeconds(20)); // setting timeout of 20 seconds...
        WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uclGrd1_lblCGPA")));
        if (element.isDisplayed()) {
            System.out.println("Element has been located and displayed : CGPA="+element.getText());
        } else {
            System.out.println("Something went wrong!");
        }

        this.waitAndCloseDriver();
    }

    public static void main(String[] args) {
        new e_explicitWaiting();
    }

}
