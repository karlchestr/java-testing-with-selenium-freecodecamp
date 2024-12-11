package com.demoqa.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static utilities.ActionsUtility.dragAndDropBy;
import static utilities.GetUtility.getAttribute;

public class SliderPage extends WidgetsPage {
    private By slider = By.xpath("//div[@id='sliderContainer']//input[@type='range']");
    private By sliderValue = By.id("sliderValue");

    public void moveSlider(int x, int y) {
        // This function below can be place in a utility class so we can reuse it
        // Actions act = new Actions(driver);
        // act.dragAndDropBy(find(slider), x, y).perform();
        // act.perform(); // convenience method for performing all actions without calling build

        dragAndDropBy(find(slider), x, y);
    }

    public String getSliderValue() {
        return getAttribute(sliderValue, "value");
    }
}