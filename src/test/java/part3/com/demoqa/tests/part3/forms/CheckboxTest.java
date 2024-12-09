package part3.com.demoqa.tests.part3.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

import static com.base.BasePage.delay;

public class CheckboxTest  extends BaseTest {

    @Test
    public void testCheckbox() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickSportsHobbyCheckbox();
        formsPage.clickReadingHobbyCheckbox();
        formsPage.clickMusicHobbyCheckbox();
        formsPage.unclickReadingHobbyCheckbox();

        boolean isReadingCheckboxSelected = formsPage.isReadingSelected();
        Assert.assertFalse(isReadingCheckboxSelected, "Reading checkbox is selected.");
    }
}
