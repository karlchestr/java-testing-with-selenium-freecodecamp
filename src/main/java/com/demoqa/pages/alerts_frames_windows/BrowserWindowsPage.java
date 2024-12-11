package com.demoqa.pages.alerts_frames_windows;

import org.openqa.selenium.By;

import java.util.Set;

import static utilities.SwitchToUtility.switchToWindow;

public class BrowserWindowsPage extends Alerts_Frames_WindowsPage {
    private By newWindowButton = By.id("windowButton");

    public void clickNewWindowButton() {
        click(newWindowButton);
    }

    public void switchToNewWindow() {
        // Step 1: Get the current main window handle
        String currentWindowHandle = driver.getWindowHandle(); // this returns an unique alphanumeric string // You can put this method in a utility class
        System.out.println("Main Window Id: " + currentWindowHandle + "\n");

        // Step 2: Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles(); // You can put this method in a utility class
        System.out.println("Number of opened windows: " + allWindowHandles.size());

        for (String handle : allWindowHandles) {
            if (currentWindowHandle.equals(handle)) {
                System.out.println("1st window id: " + handle);
            } else {
                switchToWindow(handle);
                System.out.println("2nd window id: " + handle);
            }
        }

        // Step 3: Switch to the New Window using The Window Handle

    }
}
