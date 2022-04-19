package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;//declare webdrive as global variable
    public void openBrowser(String baseUrl){
        //setup chrome driver
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(baseUrl);//get url
        driver.manage().window().maximize();//maximize  browser size
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//implicite wait

    }
    //closing browser
    public void closeBrowser(){
        driver.quit();
    }
}

