package com.demoqa.pages.widgets;

import org.openqa.selenium.By;

import java.util.List;

import static utilities.DropdownUtility.*;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class SelectMenuPage extends WidgetsPage {

    private final By standardMultiSelect = By.id("cars");

    public void selectStandardMulti(String text) {

        scrollToElementJS(standardMultiSelect);
         /*
         Select is a class in Selenium that will allow you to handle select dropdowns
         Create a 'select' reference
         You can also create a utility class for this function
         Select select = new Select(find(standardMultiSelect));

         select. offers a wide array of functions
         select.selectByVisibleText(text);
         */

        // With utility class, you can easily call the function
        selectByVisibleText(standardMultiSelect, text);
    }

    // Method overloading
    public void selectStandardMulti(int index) {
        scrollToElementJS(standardMultiSelect);
        selectByIndex(standardMultiSelect, index);
    }

    public void deselectStandardMulti(String value) {
        scrollToElementJS(standardMultiSelect);
        deselectByValue(standardMultiSelect, value);
    }

    public List<String> getAllSelectedStandardMultiOptions() {
        return getAllSelectedOptions(standardMultiSelect);
    }
}
