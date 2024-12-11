package part3.com.demoqa.base;

import com.demoqa.pages.HomePage;
import com.base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {

    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String DemoQa_URL = "https://demoqa.com";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Implicit Wait, usually uses 5 sec as default value
        // Applied for everytime we uses the driver
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Do not mix implicit waits and explicit waits, it can cause unpredictable wait times - Selenium Docu

        // Page Load Timeout, allows us to enter a time for a page to load
        // if a page does not load, it will cause a timeout exception
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        // Script Timeout, allows us to enter a time for a async javascript scripts to complete
        // driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(DemoQa_URL);

        // Create an instance of the basepage
        basePage = new BasePage();
        basePage.setDriver(driver);

        // Set up the utility after setting the basepage driver
        setUtilityDriver();

        // Set the page on homepage
        homePage = new HomePage();
    }

    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult) {
        // Interface to use Failure Result and get status method
        // Get the status of method
        if (ITestResult.FAILURE == testResult.getStatus()) {
            // Since TakesScreenshot is an interface, we need to typecast the function
            // and create an object reference
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Performs the screenshot and store it as file
            File source = screenshot.getScreenshotAs(OutputType.FILE);

            // Define a formatter for a valid file name
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

            // Format the current date and time
            String formattedDateTime = LocalDateTime.now().format(formatter);

            // Include the date before the file name, method name, and file type
            File destination = new File(System.getProperty("user.dir")
                + "/resources/screenshots/("
                + formattedDateTime + ")"
                + testResult.getName()
                + ".png");

            try {
            FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot located at: " + destination);
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        delay(3000);
        driver.quit();
    }

}
