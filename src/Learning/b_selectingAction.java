package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class b_selectingAction extends defaultExample {

    public b_selectingAction() {
        // loading the site...
        driver.get(SiteUrl);
        // defining selector object and selecting by visible text
        Select DropDownInstitute = new Select(this.driver.findElement(By.id("ddlInst")));
        DropDownInstitute.selectByVisibleText("CSPIT");

        // creating anonymous object and selecting by visible text
        new Select(this.driver.findElement(By.id("ddlDegree"))).selectByVisibleText("BTECH(CE)");

        // creating anonymous object and selecting by value
        new Select(this.driver.findElement(By.id("ddlSem"))).selectByValue("8");

        // creating anonymous object and selecting by visible text
        new Select(this.driver.findElement(By.id("ddlScheduleExam"))).selectByVisibleText("APRIL 2024");

        // finding element by id and sending some data in field...
        driver.findElement(By.id("txtEnrNo")).sendKeys("20CE054");

        // finding element by id and clicking on it...
        driver.findElement(By.id("btnSearch")).click();

        this.closeDriver();
    }

    public static void main(String[] args) {
        new b_selectingAction();
    }
}
