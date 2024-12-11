package com.demoqa.pages.widgets;

import org.openqa.selenium.By;

import static utilities.GetUtility.getText;
import static utilities.WaitUtility.fluentWaitUntilVisible;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ProgressBarPage extends WidgetsPage {
    private By startButton = By.id("startStopButton");
    private By progressValue = By.xpath("//div[@id='progressBar']/div[@aria-valuenow=100]");

    public void clickStartButton() {
        scrollToElementJS(startButton);
        click(startButton);
    }

    public String getProgressValue() {
        fluentWaitUntilVisible(30, progressValue);
        return getText(progressValue);
    }
}
