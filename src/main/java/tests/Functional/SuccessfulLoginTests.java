package tests.Functional;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import tests.TestBase;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.AssertJUnit.assertEquals;

//This test checks an user's login with correct credentials defined in a LoginPage class

public class SuccessfulLoginTests extends TestBase {

   @Test
   @Severity(SeverityLevel.CRITICAL)
   @Description ("The goal of this test is to log in using proper username and password\" +\n" +
           "            \" and check if MY ACCOUNT is displayed after")

    public void asUserTryToLogInWithAcorrectLoginAndPassword() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .LogIN();

        String MessageTxt = loginPage.getMessage();
        assertEquals(MessageTxt, "MY ACCOUNT");
    }

}