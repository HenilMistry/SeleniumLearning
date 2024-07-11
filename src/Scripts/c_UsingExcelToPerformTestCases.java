package Scripts;

import Helpers.ExcelHelper;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;

public class c_UsingExcelToPerformTestCases extends defaultScriptSetup {

    public c_UsingExcelToPerformTestCases() {

        this.driver.get(this.SiteUrl);
        ExcelHelper helper = new ExcelHelper("/Users/henil/Downloads/Test_CharusatResultRandomData.xlsx");
        helper.readExcelFile();

        int totalRows = helper.getRowCount(0);
        for(int i=0; i<totalRows; i++) {
            try {

                // creating anonymous object and selecting by visible text...
                new Select(this.driver.findElement(By.cssSelector("#ddlInst"))).selectByVisibleText(helper.getInfoAt(0,i,0));
                new Select(this.driver.findElement(By.cssSelector("#ddlDegree"))).selectByVisibleText(helper.getInfoAt(0,i,1));
                new Select(this.driver.findElement(By.cssSelector("#ddlSem"))).selectByVisibleText(helper.getInfoAt(0,i,2));
                new Select(this.driver.findElement(By.cssSelector("#ddlScheduleExam"))).selectByVisibleText(helper.getInfoAt(0,i,3));
                // finding element by id and sending some data in field...
                driver.findElement(By.id("txtEnrNo")).sendKeys(helper.getInfoAt(0,i,4));
                // finding element by id and clicking on it...
                driver.findElement(By.id("btnSearch")).click();

                WebElement elem = driver.findElement(By.id("lblMsg"));
                System.out.println("Wrong Input, Error : " + elem.getText());
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("Reached to result! All Inputs are correct!");
            } finally {
                this.driver.get(this.SiteUrl);
            }

        }
        this.waitAndCloseDriver();

    }

    public static void main(String[] args) {

        new c_UsingExcelToPerformTestCases();

    }

}