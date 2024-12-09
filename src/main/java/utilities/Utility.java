package utilities;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;

public class Utility {

    public static WebDriver driver;

    public static void setUtilityDriver() {
        driver = BasePage.driver;
    }

    // Utility class is use to assist different class that has the same function

    // Ex
    // Generate a Randome Number
    // Return Strings to UpperCase
}
