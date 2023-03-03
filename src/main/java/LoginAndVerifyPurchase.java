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



public class LoginAndVerifyPurchase {

    WebDriver driver;

    @BeforeClass
    public void ChromeBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php/");
        driver.manage().window().maximize();
    }


    @Test
    void LoginPurchase()
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
        //click on MyWishlist tab
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")).click();
        //click on add to cart
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/table/tbody/tr/td[5]/div/button")).click();
        //click on proceed to checkout
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[1]/ul/li/button")).click();
        //click continue
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button")).click();
        //click continue flat rate
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
        //click on radio Button check
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/form/div/dl/dt[2]/input")).click();
        // click continue
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button")).click();

}
}
