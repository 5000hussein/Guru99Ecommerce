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
import java.util.Date;

import static org.testng.Assert.assertEquals;




public class VerifyMobileWebPage {

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
    void VerifyMobileTitle()
    {
        WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
        Mobile.click();
        String MobileTitle= driver.getTitle();
        String ExpectedMobileTitle ="Mobile";
        assertEquals(MobileTitle,ExpectedMobileTitle);
    }

    @Test(priority = 1)
    void VerifySortingByName() throws IOException {

        Select SortMenu =new Select ( driver.findElement(By.xpath("//body/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]")));
        SortMenu.selectByIndex(1);
        TakesScreenshot ValidLogin = ((TakesScreenshot) driver);
        File SrcFile = ValidLogin.getScreenshotAs(OutputType.FILE);
        Date currentDate = new Date();
        String date = currentDate.toString().replace(" ","-").replace(":","-");
        FileUtils.copyFile(SrcFile, new File(".//screenshot/"+date+"ValidLogin.png"));

    }

    @Test(priority = 2)
    void verifyXperiaPrice()
    {
        String MobilePrice = driver.findElement(By.xpath("//*[@id=\"product-price-1\"]/span")).getText();

        WebElement SonyDetailed = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/h2/a"));
        SonyDetailed.click();

        String DetailedPrice =driver.findElement(By.xpath("//*[@id=\"product-price-1\"]/span")).getText();

        assertEquals(MobilePrice,DetailedPrice);



    }




    @AfterClass
    void exit()
    {
        driver.quit();
    }



}
