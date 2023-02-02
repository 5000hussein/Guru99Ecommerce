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





public class VerifyShoppingCart {

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
    void ShoppingCart() throws IOException {
        WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
        Mobile.click();


        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button/span/span"));
        addToCart.click();

        WebElement QTYBox =driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input"));
        QTYBox.sendKeys("000");
        WebElement Update =driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button/span/span"));
        Update.click();

        String ErrorMessage =driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[2]/p")).getText();

        String expectedError = "* The maximum quantity allowed for purchase is 500.";
        assertEquals(ErrorMessage,expectedError);


    }

    @Test(priority = 1)
    void VerifyEmptyCart() throws IOException {
        WebElement EmptyCart = driver.findElement(By.xpath("//*[@id=\"empty_cart_button\"]/span/span"));
        EmptyCart.click();

        TakesScreenshot ValidLogin = ((TakesScreenshot) driver);
        File SrcFile = ValidLogin.getScreenshotAs(OutputType.FILE);
        Date currentDate = new Date();
        String date = currentDate.toString().replace(" ","-").replace(":","-");
        FileUtils.copyFile(SrcFile, new File(".//screenshot/"+date+"EmptyCart.png"));

        String ActualEmptyMessage =driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[2]/p[1]")).getText();
        String ExpectedEmptyMessage ="You have no items in your shopping cart.";

        assertEquals(ActualEmptyMessage,ExpectedEmptyMessage);
    }

    @AfterClass
    void exit()
    {
        driver.quit();
    }



}
