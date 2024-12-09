package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    // abstract so the base page can become parent
    // abstract class cannot be instantiated

    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        // protected since we want to use this only on base page
        return driver.findElement(locator);
    }

    protected void set(By locator, String text) {
        // we can easily reuse the find code
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
