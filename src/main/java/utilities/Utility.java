package utilities;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;

public class Utility {

    public static WebDriver driver;

    public static void setUtilityDriver() {
        driver = BasePage.driver;
    }

    // Utility class is used to assist different class that has the same function

    // Ex
    // Generate a Random Number
    // Return Strings to UpperCase
}
