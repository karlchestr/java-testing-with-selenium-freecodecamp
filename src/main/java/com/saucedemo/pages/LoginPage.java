package com.saucedemo.pages;

import com.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // with encapsulation the fields are private only to this login page
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("#login_button_container h3");

    // four types of methods we can use on page object model
    // getter - returns the value of an attribute
    // setter - receives the param and assign the value
    // transition - important when an application changes to a different page
    // convenience - when combining more than one method in a single method

    public void setUsername(String username) {
        set(usernameField, username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public ProductsPage clickLoginButton() {
        // after logging in you will be directed to a diff page
        // this will be a transition method so you dont need to use void type
        // create a page for the page that you will get directed to
        click(loginButton);
        return new ProductsPage();
    }

    public ProductsPage logIntoApplication(String username, String password) {
        // transition method since you will be clicking login button
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }
}
