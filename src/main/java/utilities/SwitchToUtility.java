package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToUtility extends Utility {

    // private because it will be used in this class only
    private static WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    // this method is what we will use in other class
    public static String getAlertText() {
        // getText is different from WebElement, getText from Alert Interface
        return switchTo().alert().getText();
    }

    public static void acceptAlert() {
        // .accept() automatically clicks the ok button
        switchTo().alert().accept();
    }

    public static void dismissAlert() {
        switchTo().alert().dismiss();
    }

    public static void setAlertText(String text) {
        switchTo().alert().sendKeys(text);
    }

    public static void switchToFrameString(String iframe) {
        switchTo().frame(iframe);
    }

    public static void switchToDefaultContent() {
        // driver.switchTo().defaultContent();
        // most of the time defaultContent, is used because it always goes back to the main page
        switchTo().defaultContent();
    }

    public static void switchToFrameIndex(int index) {
        switchTo().frame(index);
    }

    public static void switchToFrameElement(WebElement element) {
        switchTo().frame(element);
    }

    public static void switchToWindow(String handle) {
        switchTo().window(handle);
    }
}
