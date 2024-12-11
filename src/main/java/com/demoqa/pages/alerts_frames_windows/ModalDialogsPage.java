package com.demoqa.pages.alerts_frames_windows;

import org.openqa.selenium.By;

public class ModalDialogsPage extends Alerts_Frames_WindowsPage {

    private By smallModal = By.id("showSmallModal");
    private By smallModalText = By.xpath("//div[contains(text(),'small modal')]");
    private By closeButton = By.id("closeSmallModal");

    public void clickSmallModalButton() {
        click(smallModal);
    }

    public String getSmallModalText() {
        return find(smallModalText).getText();
    }

    public void clickCloseButton() {
        click(closeButton);
    }
}
