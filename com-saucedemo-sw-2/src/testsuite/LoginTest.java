package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    @Before
    //opening browser
    public void setUp(){
        openBrowser("https://www.saucedemo.com/");
    }
    @Test
    public void useShouldLoginSuccessfullyWithValidCredentials(){
        //find element username
        WebElement userName=driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        //find elemnet password
        WebElement passWord= driver.findElement(By.name("password"));
        passWord.sendKeys("secret_sauce");
        //find element log in button
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        //this is requirement
        String expectedText="PRODUCTS";
        WebElement actualTextElement=driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
       String actualText= actualTextElement.getText();
      //  System.out.println(actualText);
        //compare expected and actual result match
        Assert.assertEquals("Text not match",expectedText,actualText);

    }
    @Test
    public void verifyThatSixProductAreDisplayedOnPage(){
        //find element username
        WebElement userName=driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        //find elemnt password
        WebElement passWord= driver.findElement(By.name("password"));
        passWord.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
       //verify that six products are displaed in page
        //using list interface to get list element
        List<WebElement> productList = driver.findElements(By.className("inventory_item"));
        int size = productList.size();
        System.out.println(size);

    }

}
