package part3.com.demoqa.tests.part4.modals;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

public class ModalTests extends BaseTest {

    @Test
    public void testModalDialogs() {
        var afwPage = homePage.goToAlertsFramesWindows();
        // another way to switch page
        var modalDialogsPage = afwPage.clickModalDialogs();

        modalDialogsPage.clickSmallModalButton();
        String actualText = modalDialogsPage.getSmallModalText();

        // Verify using assertion
        Assert.assertTrue(actualText.contains("small modal"),
                "The message does not contains 'small modal'");

        modalDialogsPage.clickCloseButton();
    }
}
