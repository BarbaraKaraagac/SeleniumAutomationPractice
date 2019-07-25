package tests.Security;

import DDT.ExcelSheetReader;
import DDT.SheetDataReader;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import page.objects.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import tests.TestBase;

import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static navigation.ApplicationURLs.APPLICATION_URL;


public class DDTTests extends TestBase{

    private String pswd;
    private String expectedResult;

    public DDTTests(String pswd, String expectedResult) {
        this.pswd = pswd;
        this.expectedResult = expectedResult;
    }

    @Factory
    public static Object[] queriesTestData() {
        int queryColumn = 0;
        int expectedResultColumn = 1;

        ExcelSheetReader excelSheetReader = new ExcelSheetReader();

        try {
            String excelFileLocation = System.getProperty("user.dir") + "/src/main/resources/" + "DDT_FILE.xlsx";
            excelSheetReader.setExcelFileSheet(excelFileLocation, "FalseLogin");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SheetDataReader sheetDataReader = new SheetDataReader(excelSheetReader.getExcelSheet());

        List<String> searchQueryList = sheetDataReader.getDataForColumn(queryColumn);
        List<String> expectedResultList = sheetDataReader.getDataForColumn(expectedResultColumn);

        Object[] arrayOfTestCaseToExecute = new Object[expectedResultList.size()];

        for (int testCase = 0; testCase < expectedResultList.size(); testCase++) {
            arrayOfTestCaseToExecute[testCase] =
                    new DDTTests(searchQueryList.get(testCase), expectedResultList.get(testCase));
        }
        return arrayOfTestCaseToExecute;
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("This test mocks malicious login attempts, taking data from the Excel file\" +\n")

    public void dataDrivenTest() {

        DriverUtils.navigateToPage(APPLICATION_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.TryToLogIN();

        WebElement passField = DriverManager.getWebDriver().findElement(By.xpath("//*[@id=\"passwd\"]"));

        passField.sendKeys(pswd);
        passField.sendKeys(Keys.ENTER);
        String MessageTxt = loginPage.getHeading();

        assertEquals(MessageTxt, "There is 1 error");

    }

}
