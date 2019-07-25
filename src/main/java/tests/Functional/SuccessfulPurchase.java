package tests.Functional;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.CartPage;
import page.objects.LoginPage;
import page.objects.ShoppingPage;
import io.qameta.allure.*;
import tests.TestBase;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.AssertJUnit.assertEquals;

public class SuccessfulPurchase extends TestBase {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description ("The goal of this test is to log in using proper username and password\n" +
            "       add a product to cart and finalize the order")

            public void successfulPurchase ()
    {
        DriverUtils.navigateToPage(APPLICATION_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .LogIN();

        ShoppingPage shoppingPage = new ShoppingPage();

        shoppingPage
                .findAdress();
        shoppingPage
                .goToCart();

            CartPage cartPage = new CartPage();


            String finalAlertText=cartPage.Purchase();

            assertEquals(finalAlertText, "Your order on My Store is complete.");
    }

}
