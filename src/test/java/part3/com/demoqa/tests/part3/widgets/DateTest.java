package part3.com.demoqa.tests.part3.widgets;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

public class DateTest extends BaseTest {

    @Test
    public void testSelectingDate() {
        String month = "December";
        String monthNumber = "12";
        String day = "31";
        String year = "2024";

        var datePickerPage = homePage.goToWidgets().clickDatePickerMenu();
        datePickerPage.clickSelectDate();
        datePickerPage.selectMonth(month);
        datePickerPage.selectYear(year);
        datePickerPage.clickDay(day);

        String actualDate = datePickerPage.getDate();
        String expectedDate = monthNumber + "/" + day +"/" + year;
        Assert.assertEquals(actualDate, expectedDate, "Actual and expected does not match."
            + "\n Actual date:   " + actualDate
            + "\n Expected date: " +expectedDate);
    }
}
