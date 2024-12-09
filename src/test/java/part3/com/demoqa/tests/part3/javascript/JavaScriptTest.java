package part3.com.demoqa.tests.part3.javascript;

import org.testng.annotations.Test;
import part3.com.demoqa.base.BaseTest;

public class JavaScriptTest extends BaseTest {

    @Test
    public void testScrollToElement() {
        homePage.goToForms();
    }
}
