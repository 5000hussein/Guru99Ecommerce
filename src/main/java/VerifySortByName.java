import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class VerifySortByName {


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
    void VerifySortingByName() throws IOException {
        WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
        Mobile.click();
        Select SortMenu =new Select ( driver.findElement(By.xpath("//body/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]")));
        SortMenu.selectByIndex(1);
        TakesScreenshot ValidLogin = ((TakesScreenshot) driver);
        File SrcFile = ValidLogin.getScreenshotAs(OutputType.FILE);
        Date currentDate = new Date();
        String date = currentDate.toString().replace(" ","-").replace(":","-");
        FileUtils.copyFile(SrcFile, new File(".//screenshot/"+date+"ValidLogin.png"));

}

    @AfterClass
    void exit()
    {
        driver.quit();
    }

}
