package part2.com.saucedemo.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginErrorMessage() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("1secret_sauce1");
        var productsPage = loginPage.clickLoginButton();    // keep the var if you want to perform subsequent tests
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface: Username and password do not match any user in this service"));
    }

}
