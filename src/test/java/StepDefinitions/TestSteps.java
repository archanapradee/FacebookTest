
package StepDefinitions;

import io.cucumber.java.en.*;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;



public class TestSteps {

     WebDriver driver=null;

   private static final String URL = "https://www.newegg.com/NVIDIA/BrandStore/ID-1441";

    @Given("user is navigate to NVIDIA home page and check values")
    public void user_is_navigate_to_nvidia_home_page_and_check_values() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
       // driver.findElement(By.xpath("//div[contains(text(),'North America')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'North America')]")).click();
        driver.findElement(By.xpath("/html/body/div[10]/div/div/div/div[2]/div[1]/div[2]/div/div/div/ul/li[3]/div")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(text(),'Stay at United States')]")).click();
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("tb_id109")).click();
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        for(int i=1;i<5;i++){
            try
            {

                String productName =driver.findElement(By.xpath("//*[@id=\"tbc_id109\"]/div[1]/div["+i+"]/div/div[1]")).getText();

                System.out.println("Product Name in the first row: " + productName);

                String price =driver.findElement(By.xpath("//*[@id=\"tbc_id109\"]/div[1]/div["+i+"]/div/div[2]")).getText();
                System.out.println("Unit price of the items in the first row" + price);

            }

            catch(Exception e)
            {
                break;
            }

        }
            }







    }




