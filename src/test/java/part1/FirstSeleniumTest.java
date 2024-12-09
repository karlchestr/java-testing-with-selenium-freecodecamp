package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class FirstSeleniumTest {

    // Purpose is to control the browser
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();  // close every window and the driver, standard method to use
        // driver.close(); // closes the current window
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException {
        Thread.sleep(2000); // not recommended on actual test but for demo only
        // Find the web element and perform an action
        // Web Element is an interface that represent html elements
        WebElement username = driver.findElement(By.name("username"));
        // Perform an action
        username.sendKeys("Admin");

        var password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // Click the login
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);
        // Verify if the test passed using assertion
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult);
    }
}
