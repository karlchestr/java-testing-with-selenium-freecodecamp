package part3.com.demoqa.tests.part4.interactions;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

public class KeyBoardTest extends BaseTest {
    @Test
    public void testApplicationUsingKeyboard() {
        var textBoxPage = homePage.goToElements().clickTextBox();
        textBoxPage.setFullName("Karl Chester R");
        // Press the tab key
        textBoxPage.setEmail("karlchester123@gmail.com");
        textBoxPage.setCurrentAddress("1234 Selenium Avenue");
        textBoxPage.setCurrentAddress("Suite 6600");
        textBoxPage.setCurrentAddress("Dallas, Texas");
        textBoxPage.clickSubmitButton();

        String actualAddress = textBoxPage.getCurrentAddress();
        Assert.assertTrue(actualAddress.contains("Suite 6600"),
                "Actual address does not contain 'Suite 6600'\n");
    }
}
