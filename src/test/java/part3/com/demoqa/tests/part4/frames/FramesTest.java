package part3.com.demoqa.tests.part4.frames;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;


public class FramesTest extends BaseTest {

    @Test
    public void testFramesBigBox() {
        var framesPage = homePage.goToAlertsFramesWindows().clickFrames();

        // Get the text
        String actualBigBoxText = framesPage.getTextBigFrame();
        String expectedBigBoxText = "This is a sample page";

        Assert.assertEquals(actualBigBoxText, expectedBigBoxText,
                "Actual and expected big box test do not match.");
        String actualHeaderText = framesPage.getHeaderFramesText();
        String expectedHeaderText = "Frames";

        Assert.assertEquals(actualHeaderText, expectedHeaderText,
                "Actual and expected frames header text do not match.");
    }

    @Test
    public void testFramesSmallBox() {
        var framesPage = homePage.goToAlertsFramesWindows().clickFrames();

        // Get the text

        String actualSmallBoxText = framesPage.getTextSmallFrame();
        String expectedSmallBoxText = "This is a sample page";

        Assert.assertEquals(actualSmallBoxText, expectedSmallBoxText,
                "Actual and expected big box test do not match.");

        String actualHeaderText = framesPage.getHeaderFramesText();
        String expectedHeaderText = "Frames";

        Assert.assertEquals(actualHeaderText, expectedHeaderText,
                "Actual and expected frames header text do not match.");
    }
}
