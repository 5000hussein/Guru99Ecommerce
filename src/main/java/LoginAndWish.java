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

public class LoginAndWish {

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
    void ShareWish ()
    {
        driver.get("http://live.techpanda.org/index.php/");
        //Click on TV
        driver.findElement(By.linkText("TV")).click();
        //Add to wishlist
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
        //Login Email
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[1]/ul/li[1]/div/input")).sendKeys("JohnWick@asd.com");
        //Login Password
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[1]/ul/li[2]/div/input")).sendKeys("1234567890");
        //click on Login
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[2]/button")).click();
       //click on share wishlist
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/div/button[1]")).click();
       //Enter email to send to
       driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div[1]/ul/li[1]/div/textarea")).sendKeys("husseinthespider@gmail.com");
       //Enter Message
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div[1]/ul/li[2]/div/textarea")).sendKeys("123");
        //Click on share
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div[2]/button")).click();
        //Actual Message
        String ACT =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
        //Expected Message
        String EXP ="Your Wishlist has been shared.";
        //Test the confirmation message

        assertEquals(ACT,EXP);

    }
    @AfterClass
    void exit()
    {
        driver.quit();
    }

}


