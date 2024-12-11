package part3.com.demoqa.tests.part4.interactions;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

public class SliderTest extends BaseTest {
    @Test
    public void testSlider() {
        int x = 225;
        int y = 0;
        var sliderPage = homePage.goToWidgets().clickSlider();
        sliderPage.moveSlider(x, y);

        String actualValue = sliderPage.getSliderValue();
        String expectedValue = "85";

        Assert.assertEquals(actualValue, expectedValue,
                "Actual and expected value do not match");
    }
}
