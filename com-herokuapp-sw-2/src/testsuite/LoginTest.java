package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    @Before
    //opening browser
    public void setUp() {
        openBrowser("http://the-internet.herokuapp.com/login");
    }

    @Test
    //login with valid credentials
    public void useShouldLoginSuccessfullyWithValidCredentials() {
        //find username elemnet
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        //find password elemnet
        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton.click();
        //this is requirment
        String expectedText="Secure Area";
        WebElement actualTextElement= driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
        String actualText=actualTextElement.getText();
        //verify expected and actual result
        Assert.assertEquals("Text not Displayed",expectedText,actualText);

    }
    @Test
    //error message displayed when enter invalid username
    public void verifyTheUsernameErrorMessage(){
        //find username element and set invalid username
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");
        //find password element
        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton.click();
        //this is requirment
        String expectedErrorMessage="Your username is invalid!";
        WebElement actualErrorMessageElement= driver.findElement(By.xpath("//div[@id='flash-messages']"));
        String actualErrorMessage=actualErrorMessageElement.getText();
        //verify that expected and actual result match
        Assert.assertEquals("Error message not Displayed",expectedErrorMessage,actualErrorMessage);


    }
    @Test
    //error message displayed when enter invalid password
    public void verifyThePasswordErrorMessage(){
        //find username element
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        //find password element with invalid password
        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("SuperSecretPassword");
        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton.click();
        //this is requirment
        String expectedErrorMessage="Your password is invalid!";
        WebElement actualErrorMessageElement= driver.findElement(By.xpath("/html/body/div[1]/div/div"));
        String actualErrorMessage=actualErrorMessageElement.getText();
        //verify that expected and actual result match
        Assert.assertEquals("Error message not Displayed",expectedErrorMessage,actualErrorMessage);

    }
}