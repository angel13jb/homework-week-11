package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    //login with valid credentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find username element
        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        //find password element
        WebElement passWord= driver.findElement(By.name("txtPassword"));
        passWord.sendKeys("admin123");
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();
        //this is requirement
        String expectedText="Welcome";
        WebElement actualTextElement=driver.findElement(By.xpath("//a[@id='welcome']"));
        String actualText= actualTextElement.getText().substring(0,7);
        // System.out.println(actualText);
        //verify expected and actual result match
        Assert.assertEquals("Text not match",expectedText,actualText);

    }
    @After
    public void tearDown(){
        closeBrowser();//closing browser
    }

}
