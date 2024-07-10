package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * This class will demonstrate the way we can collect result data of one student
 * for all the semester. Basically, we'll print CGPA of all 8 semester for the
 * student whose ID no. is provided!
 * */
public class a_PrintingResultDataOfOneStudent extends defaultScriptSetup {

    protected String Institute = "CSPIT";
    protected String Degree = "BTECH(CE)";

    protected String StudentId = "20CE054";
    protected String CssSelectorIdForCGPA = "uclGrd1_lblCGPA";
    FileWriter outputFile;
    protected Map<String, String> examDetails;

    public a_PrintingResultDataOfOneStudent(String StudentId) {
        this.StudentId = StudentId;
        this.examDetails = new HashMap<>();
        examDetails.put("1","MARCH 2021");
        examDetails.put("2","JULY 2021");
        examDetails.put("3","NOVEMBER 2021");
        examDetails.put("4","MAY 2022");
        examDetails.put("5","NOVEMBER 2022");
        examDetails.put("6","APRIL 2023");
        examDetails.put("7","NOVEMBER 2023");
        examDetails.put("8","APRIL 2024");

        try {
            this.outputFile = new FileWriter("data.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method contains the core function/script for this example
     * which can be reused in later classes or scripts.
     *
     * @see b_PrintingResultDataOfMultipleStudents
     * @param read would you like to read data for one student ?
     * */
    public void doRun(boolean read) {
        // loading the site...
        this.driver.get(this.SiteUrl);
        try {
            for (String semester : examDetails.keySet()) {

                // creating anonymous object and selecting by visible text...
                new Select(this.driver.findElement(By.cssSelector("#ddlInst"))).selectByVisibleText(this.Institute);
                new Select(this.driver.findElement(By.cssSelector("#ddlDegree"))).selectByVisibleText(this.Degree);
                new Select(this.driver.findElement(By.cssSelector("#ddlSem"))).selectByVisibleText(semester);
                new Select(this.driver.findElement(By.cssSelector("#ddlScheduleExam"))).selectByVisibleText(examDetails.get(semester));
                // finding element by id and sending some data in field...
                driver.findElement(By.id("txtEnrNo")).sendKeys(this.StudentId);
                // finding element by id and clicking on it...
                driver.findElement(By.id("btnSearch")).click();

                // explicit waiting for the element to be loaded and getting information out of it...
                WebDriverWait explicitWait = new WebDriverWait(this.driver, Duration.ofSeconds(20)); // setting timeout of 20 seconds...
                WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.CssSelectorIdForCGPA)));
                if (element.isDisplayed()) {
                    System.out.println("Element has been located and displayed, data read for semester : "+ semester +"  --> CGPA="+element.getText());
                    if (read) {
                        this.outputFile.append(semester).append(",").append(element.getText()).append("\n");
                    }
                } else {
                    System.out.println("Something went wrong!");
                }

                this.driver.get(this.SiteUrl);

            }
            this.outputFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doRun() {
        this.doRun(false);
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public String getStudentId() {
        return this.StudentId;
    }

    public void closeDriver() {
        this.driver.close();
        this.driver.quit();
    }

    public a_PrintingResultDataOfOneStudent() {
        this("20CE054");
    }

    public static void main(String[] args) {
        a_PrintingResultDataOfOneStudent script =  new a_PrintingResultDataOfOneStudent();
        script.doRun(true);
        script.waitAndCloseDriver();
    }

}
