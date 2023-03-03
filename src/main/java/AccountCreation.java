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

public class AccountCreation {

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
    void Create ()
    {
        String firstname="John";
        String lastname="Wick";

        driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.xpath("/html/body/div/div/header/div/div[5]/div/ul/li[1]/a")).click();
        //Click on Create
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[1]/div[2]/a")).click();
        //First Name
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[1]/div/div[1]/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[1]/div/div[1]/div/input")).sendKeys(firstname);
        //Last Name
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[1]/div/div[3]/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[1]/div/div[3]/div/input")).sendKeys(lastname);
        //Password
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[3]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[3]/div[1]/div/input")).sendKeys("1234567890");
        //Confirm Password
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[3]/div[2]/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[3]/div[2]/div/input")).sendKeys("1234567890");
        //Email
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[2]/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[2]/div/input")).sendKeys("JohnWick@asd.com");
        //Click on register
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[2]/button")).click();

        String act =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")).getText();
        String Expected = "Thank you for registering with Main Website Store.\n";

        assertEquals(act,Expected);

    }
    @AfterClass
    void exit()
    {
        driver.quit();
    }


}
