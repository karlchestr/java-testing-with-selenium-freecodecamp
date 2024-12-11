package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import static utilities.GetUtility.getText;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class DynamicPropertiesPage extends ElementsPage {
    private By visibleAfter5SecButton = By.id("visibleAfter");

    public String getVisibleAfterButtonText() {
        explicitWaitUntilVisible(5, visibleAfter5SecButton);
        String visibleText = getText(visibleAfter5SecButton);
        System.out.println("Button Text: " + visibleText);

        return visibleText;
    }
}
