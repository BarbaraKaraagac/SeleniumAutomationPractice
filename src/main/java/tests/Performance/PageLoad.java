package tests.Performance;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import tests.TestBase;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.AssertJUnit.assertTrue;


public class PageLoad extends TestBase {

    private Logger logger = LogManager.getLogger(LoginPage.class);
    StopWatch loadTime = new StopWatch();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("The goal of this test is to validate the login time \n" +
            "(as per the condition - below 8 seconds).")

    public void asUserTryToLogInWithAcorrectLoginAndPassword() {

        loadTime.start();
        DriverUtils.navigateToPage(APPLICATION_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .LogIN();

        double seconds = (double) loadTime.getTime() / 1000.0;
        logger.info("The Load time is: " +seconds+".");
        assertTrue(seconds < 8.0);
    }

}