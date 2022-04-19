package testsuite;

import browserfactory.BaseTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl="https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        //find element computer
        WebElement computerTab= driver.findElement(By.linkText("Computers"));
        computerTab.click();
        //this is requirment
        String expectedText="Computers";
        WebElement actualTextElement= driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
       String actualText= actualTextElement.getText();
       //verify expected and actual result match
        Assert.assertEquals("Text not Displayed",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        //find element electronics
        WebElement electronicsTab= driver.findElement(By.linkText("Electronics"));
        electronicsTab.click();
        //this is requirment
        String expectedText="Electronics";
        WebElement actualTextElement= driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        String actualText= actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not Displayed",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        //find element apparel
        WebElement apparelTab= driver.findElement(By.linkText("Apparel"));
        apparelTab.click();
        //this is requirment
        String expectedText="Apparel";
        WebElement actualTextElement= driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        String actualText= actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not Displayed",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        //find element digital downloads
        WebElement ddownloadTab= driver.findElement(By.linkText("Digital downloads"));
        ddownloadTab.click();
        //this is requirment
        String expectedText="Digital downloads";
        WebElement actualTextElement= driver.findElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
        String actualText= actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not Displayed",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        //find element books
        WebElement booksTab= driver.findElement(By.linkText("Books"));
        booksTab.click();
        //this is requirment
        String expectedText="Books";
        WebElement actualTextElement= driver.findElement(By.xpath("//h1[contains(text(),'Books')]"));
        String actualText= actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not Displayed",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //fine element jewelry
        WebElement jewelryTab= driver.findElement(By.linkText("Jewelry"));
        jewelryTab.click();
        //this is requirment
        String expectedText="Jewelry";
        WebElement actualTextElement= driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actualText= actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not Displayed",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //find element gifcards
        WebElement giftCardsTab= driver.findElement(By.linkText("Gift Cards"));
        giftCardsTab.click();
        //this is requirment
        String expectedText="Gift Cards";
        WebElement actualTextElement= driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        String actualText= actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not Displayed",expectedText,actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
