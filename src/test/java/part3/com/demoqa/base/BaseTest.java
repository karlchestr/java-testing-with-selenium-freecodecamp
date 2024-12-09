package part3.com.demoqa.base;

import com.demoqa.pages.HomePage;
import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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

    @AfterClass
    public void tearDown() throws InterruptedException {
        delay(3000);
        driver.quit();
    }

}
