package part3.com.demoqa.tests.part3.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

public class RadioButtonTest extends BaseTest {

    @Test
    public void testRadioButton() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickFemaleRadioButton();
        // sometimes, clicking radio button doesn't work, thats why use a javascript executor to select a value
        boolean isFemaleRadioButtonSelected = formsPage.isFemaleSelected();
        Assert.assertTrue(isFemaleRadioButtonSelected,
                "Female radio button is not selected.");
    }
}
