package part3.com.demoqa.tests.part3.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

public class LinksTest extends BaseTest {

    @Test
    public void testLinks() {
        var linksPage = homePage.goToElements().clickLinks();
        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();

        // Verify the response
        Assert.assertTrue(actualResponse.contains("400")
                        && actualResponse.contains("Bad Request"),
                "Actual Response (" + actualResponse + ") + does not contain '400' and 'Bad Request'.");
    }
}
