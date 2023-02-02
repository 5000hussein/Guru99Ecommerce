import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;




public class VerifyTitles {

    WebDriver driver;

    @BeforeClass
    public void ChromeBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    void VerifyMainPageTitle()
    {
        String main =driver.getTitle();
        String ExpectedMain ="Home page";
        assertEquals(main,ExpectedMain);
    }

    @Test(priority = 1)
    void VerifyMobileTitle()
    {
        WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
        Mobile.click();
        String MobileTitle= driver.getTitle();
        String ExpectedMobileTitle ="Mobile";
        assertEquals(MobileTitle,ExpectedMobileTitle);
    }
    @AfterClass
    void exit()
    {
        driver.quit();
    }



}
