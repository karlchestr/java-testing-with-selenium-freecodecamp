package com.demoqa.pages.widgets;

import org.openqa.selenium.By;

import static utilities.DropdownUtility.selectByVisibleText;

public class DatePickerMenuPage extends WidgetsPage {

    private By selectDateField = By.id("datePickerMonthYearInput");
    // . is for cssSelect while # is for id
    private By monthDropdown = By.className("react-datepicker__month-select");
    private By yearDropdown = By.cssSelector(".react-datepicker__year-select");

    public void clickSelectDate() {
        click(selectDateField);
    }

    public String getDate() {
        // return the value from the date picker attribute
        return find(selectDateField).getAttribute("value");
    }

    public void selectMonth(String month) {
        selectByVisibleText(monthDropdown, month);
    }

    public void selectYear(String year) {
        selectByVisibleText(yearDropdown, year);
    }

    // private method because we did not need  to return the by locator other than this method
    private  By dayValue(String day) {
        return By.xpath("//div[contains(@class, 'react-datepicker__day react-datepicker__day--')][text()='" + day +"']");
    }

    public void clickDay(String day) {
        click(dayValue(day));
    }

    // Demo method to check the number of days in a month
    public boolean isDayInMonth(String day) {
        return find(dayValue(day)).isDisplayed();
    }
}
