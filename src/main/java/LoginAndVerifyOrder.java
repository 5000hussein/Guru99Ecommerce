import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import static org.testng.Assert.assertEquals;


public class LoginAndVerifyOrder {

    WebDriver driver ;

    @BeforeClass
    public void ChromeBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php/");
        driver.manage().window().maximize();
    }

    @Test
    void LoginOrderVerify()
    {
        //go to account
        driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.xpath("/html/body/div/div/header/div/div[5]/div/ul/li[1]/a")).click();
        //Login Email
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[1]/ul/li[1]/div/input")).sendKeys("JohnWick@asd.com");
        //Login Password
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[1]/ul/li[2]/div/input")).sendKeys("1234567890");
        //click on Login
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[2]/button")).click();
        //click on my orders
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a")).click();
        //get text of the order number and the status
        String actual = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[5]/em")).getText();
        //test pending status for the order
        String Expected = "Pending";
        assertEquals(actual,Expected);
        //click on view order
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[6]/span/a[1]")).click();
        //click on print order
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]")).click();
        //to click on the new tab
        List<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        String Parent =Tabs.get(0);
        String Child = Tabs.get(1);
        driver.switchTo().window(Child);
        //to close the popup
        driver.switchTo().alert().accept();
        //to click on close window
        driver.findElement(By.xpath("/html/body/div/div[4]/button")).click();
        }
    }



