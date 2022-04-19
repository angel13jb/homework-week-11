package testsuite;

import browserfactory.BaseTest;
import javafx.scene.control.Tab;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //find register element
        WebElement registerTab= driver.findElement(By.linkText("Register"));
        registerTab.click();
        //this is requirement
        String expectedText="Register";
        WebElement actualTextElement= driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        String actualText= actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not Displayed",expectedText,actualText);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //find element register
        WebElement registerTab= driver.findElement(By.linkText("Register"));
        registerTab.click();
        //find element genderbutton
        WebElement genderButton= driver.findElement(By.id("gender-female"));
        genderButton.click();
        //find element first name and get value
        WebElement firstName=driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Lily");
        //find element last name and get value
        WebElement lastName= driver.findElement(By.name("LastName"));
        lastName.sendKeys("Smith");
        //select birthday from drop down
        Select birthDayName= new Select(driver.findElement(By.name("DateOfBirthDay")));
        birthDayName.selectByIndex(1);
        //select birthmonth from drop down
        Select birthMonthName= new Select(driver.findElement(By.name("DateOfBirthMonth")));
        birthMonthName.selectByIndex(2);
        //select drop down from year
        Select birthYearName= new Select(driver.findElement(By.name("DateOfBirthYear")));
        birthYearName.selectByIndex(50);
        //find element email and get value
        WebElement emailField=driver.findElement(By.id("Email"));
        emailField.sendKeys("lilysmith@gmail.com");
        //find element password and get value
        WebElement passwordField=driver.findElement(By.name("Password"));
        passwordField.sendKeys("lily123");
        WebElement confirmPasswordField=driver.findElement(By.name("ConfirmPassword"));
        confirmPasswordField.sendKeys("lily123");
        WebElement registerButton= driver.findElement(By.linkText("Register"));
        registerButton.click();
        //this is requirment
        String expectedText="Your registration completed";
        WebElement actualTextElement=driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualText=actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not displayed",expectedText,actualText);

    }







}
