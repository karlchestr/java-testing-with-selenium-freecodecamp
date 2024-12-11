package com.demoqa.pages.alerts_frames_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.SwitchToUtility.*;

public class FramesPage extends Alerts_Frames_WindowsPage {

    private By textInFrame = By.id("sampleHeading");
    private String iFrameBigBox = "frame1";
    private By headerFramesText = By.xpath("//div[@id='app']//h1[text()='Frames']");
    private String iFrameSmallBoxId = "frame2";
    private By iFrameSmallBoxXpath = By.xpath("//div[@id='frame2Wrapper']//iframe");

    public String getHeaderFramesText() {
        return find(headerFramesText).getText();
    }

    private void switchToBigBox() {
        switchToFrameString(iFrameBigBox);
    }

    public String getTextBigFrame() {
        // Call the switch to iFrame method
        switchToBigBox();

        delay(3000);
        String bigFrameText = find(textInFrame).getText();
        System.out.println("Big frame text: " + bigFrameText);

        // After switching, you should always switch out after you are done
        switchToDefaultContent();
        return bigFrameText;
    }

    private void switchToSmallBox() {
        // switchToFrameIndex(getTheSmallFrameIndex());
        switchToFrameElement(find(iFrameSmallBoxXpath));
    }

    public String getTextSmallFrame() {
        switchToSmallBox();
        delay(3000);
        String smallFrameText = find(textInFrame).getText();
        System.out.println("Small frame text: " + smallFrameText);

        switchToDefaultContent();
        return smallFrameText;
    }

    private int getTheSmallFrameIndex() {
        // Created this method because the index of small iframe changes everytime due to the inconsistent iframes appearing as ads
        // This method will only get the index of iframe just to demonstrate the switchTo().frame() by index

        // Get the list of iFrames
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        int targetIndex = -1; // Default to -1 to indicate not found

        for (int i = 0; i < iframes.size(); i++) {
            WebElement iframe = iframes.get(i);
            String iframeId = iframe.getAttribute("id");

            if (iframeId != null && iframeId.equals(iFrameSmallBoxId)) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            throw new NoSuchElementException("Iframe with ID '" + iFrameSmallBoxId + "' not found.");
        }

        return targetIndex;
    }
}