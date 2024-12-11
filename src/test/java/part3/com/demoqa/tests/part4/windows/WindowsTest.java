package part3.com.demoqa.tests.part4.windows;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

import static utilities.GetUtility.getUrl;

public class WindowsTest extends BaseTest {
    @Test
    public void testNewWindowUrl() {
        var windowsPage = homePage.goToAlertsFramesWindows().clickBrowserWindows();
        windowsPage.clickNewWindowButton();
        windowsPage.switchToNewWindow();
        String actualUrl = getUrl();
        String expectedUrl = "https://demoqa.com/sample";

        Assert.assertEquals(actualUrl, expectedUrl,
                "Actual and expected url do not match");
    }
}
