package part2.com.saucedemo.tests.products;

import com.saucedemo.pages.ProductsPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;

public class ProductsTest extends BaseTest {

    @Test
    public void testProductsHeaderIsDisplayed() {
        // Create a transition method that will check the products page header after a login
        ProductsPage productsPage = loginPage
                .logIntoApplication("standard_user", "secret_sauce");

        // Assert.assertTrue(productsPage.isProductsHeaderDisplayed());
        // You can import assert as static with * to remove the Assert keyword in first part
        // import static org.testng.Assert.*;
        assertTrue(productsPage.isProductsHeaderDisplayed(), "Products header is not displayed. \n");
    }
}
