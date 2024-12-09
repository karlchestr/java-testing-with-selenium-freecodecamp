package part3.com.demoqa.tests.part3.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

public class WebTableTest extends BaseTest {

    @Test
    public void testWebTables() {

        String testEmail = "cierra@example.com";

        var webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickEdit(testEmail);
        webTablePage.setAge("99");
        webTablePage.clickSubmitButton();

        // Verify if the changes made are correct
        String actualAge = webTablePage.getTableAge(testEmail);
        String expectedAge = "99";
        Assert.assertEquals(actualAge, expectedAge, "Actual and Expected Ages do not match.");

    }
}
