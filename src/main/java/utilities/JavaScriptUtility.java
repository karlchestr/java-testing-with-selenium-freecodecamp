package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility extends Utility {

    public static void scrollToElementJS (By locator) {
        // find the web element
        WebElement element = driver.findElement(locator);

        // set the driver to execute a javascript to scroll to a element
        String jsScript = "arguments[0].scrollIntoView()";
        ((JavascriptExecutor)driver).executeScript(jsScript, element);
    }

    public static void clickJS(By locator) {
        WebElement element = driver.findElement(locator);
        // Another way to use javascript executor
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

    }
}
