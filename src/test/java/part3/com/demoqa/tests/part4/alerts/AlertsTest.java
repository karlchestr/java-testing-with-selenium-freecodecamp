package part3.com.demoqa.tests.part4.alerts;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

import static utilities.SwitchToUtility.*;

@Test
public class AlertsTest extends BaseTest {

    public void testInformationAlerts() {
        String expectedAlertText = "You clicked a button";
        var alertsPage = homePage.goToAlertsFramesWindows().clickAlerts();
        alertsPage.clickInformationAlertButton();

        Assert.assertEquals(getAlertText(), expectedAlertText,
                "Actual and expected alert text messages do not match");

        // Click the OK button on the alert
        // Accept the alert if you want to perform another action
        acceptAlert();
    }

    public void testConfirmationAlert() {
        var alertsPage = homePage.goToAlertsFramesWindows().clickAlerts();
        alertsPage.clickConfirmationAlertButton();

        dismissAlert();
        String actualConfirmationResult = alertsPage.getConfirmationAlertResult();
        String expectedConfirmationResult = "You selected Cancel";

        Assert.assertEquals(actualConfirmationResult, expectedConfirmationResult,
                "Actual and expected result does not match");
    }

    public void testPromptAlert() {
        String alertText = "Getsuga Tensho!!";
        var alertsPage = homePage.goToAlertsFramesWindows().clickAlerts();
        alertsPage.clickPromptAlertButton();

        // Use sendKeys method from the alert class
        setAlertText(alertText);
        // Click ok button
        acceptAlert();

        // Get the result
        String actualResult = alertsPage.getPromptResult();
        String expectedResult = "You entered " + alertText;

        Assert.assertEquals(actualResult, expectedResult,
                "Actual and Expected Result do not match");
    }
}
