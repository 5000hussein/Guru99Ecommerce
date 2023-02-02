import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;


public class VerifyMainWebPage {


    WebDriver driver ;

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



    @AfterClass
    void exit()
    {
        driver.quit();
    }

}
