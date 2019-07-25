package tests.Functional;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.ShoppingPage;
import tests.TestBase;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.AssertJUnit.assertEquals;

public class AddToCart extends TestBase {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("The goal of this test is to log in using proper username and password and\n" +
            "       add a product to the cart.")
    public void addToCart() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .LogIN();

        ShoppingPage shoppingPage = new ShoppingPage();

        String Label1 = shoppingPage.findAdress();

        String Label2 = shoppingPage.goToCart();

        assertEquals(Label1, Label2);
    }


}