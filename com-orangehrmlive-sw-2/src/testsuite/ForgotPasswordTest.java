package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);//opening browser
    }

    @Test
    // verify forget password text
    public void userShouldNavigateTOForgotPasswordPageSuccessfully() {
        WebElement forgotPassword = driver.findElement(By.linkText("Forgot your password?"));
        forgotPassword.click();
        //this is requirement
        String expectedText = "Forgot Your Password?";
        WebElement actualTextElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/h1"));
        String actualText = actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not displayed", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();//closing browser
    }


}
