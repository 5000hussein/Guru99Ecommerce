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
public class VerifyComparesion {


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
    public void Compare() throws InterruptedException {

        WebElement Mobile = driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a"));
        Mobile.click();
        WebElement Xperia = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a"));
        Xperia.click();
        String MainX = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/h2/a")).getText();
        WebElement Galaxy = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a"));
        Galaxy.click();
        String MainG = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/h2/a")).getText();
        Thread.sleep(2000);
        WebElement Compare =  driver.findElement(By.xpath("//button[@title='Compare']"));
        Compare.click();


        //swtich to new window
        List <String> WindowIDs = new ArrayList<String>(driver.getWindowHandles());
        String Parent = WindowIDs.get(0);
        String PopUp = WindowIDs.get(1);
        driver.switchTo().window(PopUp);

        String PopX = driver.findElement(By.xpath("/html/body/div/table/tbody[1]/tr[1]/td[1]/h2/a")).getText();
        String PopG =driver.findElement(By.xpath("/html/body/div/table/tbody[1]/tr[1]/td[2]/h2/a")).getText();

        assertEquals(MainG,PopG);
        assertEquals(MainX,PopX);
        Thread.sleep(2000);


    }

    @AfterClass
    void exit()
    {
        driver.quit();
    }

}
