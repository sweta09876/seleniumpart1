/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 *
 * @author Sweta
 */
public class ContactusTest {
  private WebDriver driver;
  private String baseUrl; 
    public ContactusTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        
    System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    baseUrl = "http://www.itexps.com/simpleform.html";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDownMethod() throws Exception { driver.close();
    } 
    
    // @Test
    public void hover() throws Exception {
        //   driver = new ChromeDriver();
        driver.manage().window().maximize();
       // implicit wait condition
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // this opens the url
        driver.get("https://www.redfin.com/");
        
        //Mouse hover
        WebElement elem1 = driver.findElement(By.xpath("//a[contains(@title, 'Buy Menu')]"));
        Actions act = new Actions(driver);
    //    Action a1 = act.moveToElement(elem1).build();
//        a1.perform();

        //To wait for element visible
       WebDriverWait wait = new WebDriverWait(driver, 30);

      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home buying guide")));

        WebElement elem2 = driver.findElement(By.linkText("Home buying guide"));
        elem2.click();
 
    }
    @Test
    public void testScroll()throws Exception { 
    
 // public void testContactUs() throws Exception {
    driver.get("baseUrl");
    Thread.sleep(10*100);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(1,250)","");
    Thread.sleep(10*100);
    
    WebDriverWait wait=new WebDriverWait(driver, 20);  //20 sec
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uname"))); 
    driver.findElement(By.id("uname")).click();
    driver.findElement(By.id("uname")).clear();
    driver.findElement(By.id("uname")).sendKeys("sweta");
    
    
    WebDriverWait wait1=new WebDriverWait(driver, 30);  //20 sec
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass"))); 
   // driver.findElement(By.id("pass")).click();
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("123");
    driver.findElement(By.id("uemail")).click();
    driver.findElement(By.id("uemail")).clear();
    driver.findElement(By.id("uemail")).sendKeys("sweta4807@hotmail.com");
    driver.findElement(By.id("age")).clear();
    driver.findElement(By.id("age")).sendKeys("40");
    driver.findElement(By.xpath("//label[2]/input")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[1]/following::label[1]")).click();
    driver.findElement(By.id("city")).click();
    new Select(driver.findElement(By.id("city"))).selectByVisibleText("New York");
    driver.findElement(By.xpath("//textarea")).click();
    driver.findElement(By.xpath("//textarea")).clear();
    driver.findElement(By.xpath("//textarea")).sendKeys("3, boxwood lane");
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
  }
}
