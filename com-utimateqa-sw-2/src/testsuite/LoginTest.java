package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com";

    @Before
    //opening browser
    public void setUp() {
    openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //find element sign in text
        WebElement signInLink= driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //this is requirment
        String expectedMessage="Welcome Back!";
        WebElement actualMessageElement=driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage=actualMessageElement.getText();
       // System.out.println(actualMessage);
        //compare as expected and actual result same
        Assert.assertEquals("Not Navigate to sign in page",expectedMessage,actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        WebElement signInLink= driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //find element email
        WebElement userName=driver.findElement(By.id("user[email]"));
        userName.sendKeys("prime@gmail.com");
        //find element password
        WebElement password= driver.findElement(By.name("user[password]"));
        password.sendKeys("prime1");
        WebElement signInButton=driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        signInButton.click();
        //this is requirment
        String expectedErrorMessage="Invalid email or password.";
        WebElement actualErrorMessage=driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        actualErrorMessage.getText();
        // System.out.println(actualMessage);
        //compare expected and actual result
        Assert.assertEquals("Error message not displayed",expectedErrorMessage,actualErrorMessage);

    }
    @After
    public void tearDown(){
        closeBrowser();//closing browser
    }
}
