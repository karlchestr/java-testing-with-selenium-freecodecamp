package part3.com.demoqa.tests.part4.dynamic_wait;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

@Test
public class DynamicWaitTest extends BaseTest {

    public void testVisibleAfterButtonText() {
        var dynamicPage = homePage.goToElements().clickDynamicProperties();
        String actualText = dynamicPage.getVisibleAfterButtonText();
        String expectedText = "Visible After 5 Seconds";

        Assert.assertEquals(actualText, expectedText,
                "Actual and expected text do not match.");
    }

    public void testProgressBar() {
        var progressBarPage = homePage.goToWidgets().clickProgressBar();

        progressBarPage.clickStartButton();
        String actualProgressValue = progressBarPage.getProgressValue();
        String expectedValue = "100%";

        Assert.assertEquals(actualProgressValue, expectedValue,
                "Actual and expected progress value do not match");
    }
}
