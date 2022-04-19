package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //Find log in link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //This is from requirement
        String expectedMessage = "Welcome, Please Sign In!";
        //Find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMessageElement.getText();
        //verify actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        //sending email to email field element
        emailField.sendKeys("tomsmith@gmail.com");
        //find the password field element
        WebElement passwordField = driver.findElement(By.name("Password"));
        //sending password to password field element
        passwordField.sendKeys("tomsmith1");
        WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
        loginbutton.click();
        String expectedText = "Log out";
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not displayed", expectedText, actualText);

    }

    @Test
    public void verifyErrorMessagewithInvalidCredentials() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        //sending email to email field element
        emailField.sendKeys("prime123@gmail.com");
        //find the password field element
        WebElement passwordField = driver.findElement(By.name("Password"));
        //sending password to password field element
        passwordField.sendKeys("Prime123");
        WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
        loginbutton.click();
        //this is requirement
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        //verify expected and actual result match
        Assert.assertEquals("Error message not displayed", expectedMessage, actualErrorMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}