package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;


public class LoginPage {

    private Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "//div[@class='header_user_info']")
    private WebElement LogBut;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement Password;

    @FindBy(name = "SubmitLogin")
    private WebElement Submit;

    @FindBy(xpath="//*[@id=\"center_column\"]/h1")
    private WebElement PageHeading;

    @FindBy(xpath="//*[@id=\"center_column\"]/div[1]/p")
    private WebElement FalseLoginHeading;

    @FindBy(css="a:contains('Einverstanden')")
    private WebElement OKButton1;

    @FindBy (xpath = "//button[@aria-label='Anmelden']")
    private WebElement loginButton;

    @FindBy (xpath = "//*[@id=\"email\"]")
    private WebElement Email;

String username = "kluski@gmail.com";
String passwd = "Kluseczki";

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage TryToLogIN() {
        WaitForElement.waitUntilElementIsVisible(LogBut);
        LogBut.click();
        logger.info("OK button clicked");
        WaitForElement.waitUntilElementIsVisible(Email);
        Email.clear();
        Email.sendKeys(username);
        logger.info("email typed");
        return this;
    }

    //@Step("Type into User Name Field {username}")
    public LoginPage LogIN() {
        WaitForElement.waitUntilElementIsVisible(LogBut);
        LogBut.click();
        logger.info("OK button clicked");
        WaitForElement.waitUntilElementIsVisible(Email);
        Email.clear();
        Email.sendKeys(username);
        logger.info("email typed");
        WaitForElement.waitUntilElementIsVisible(Password);
        Password.clear();
        Password.sendKeys(passwd);
        Submit.click();
        return this;
    }

    public String getMessage() {
        WaitForElement.waitUntilElementIsVisible(PageHeading);
        String MessageTxt = PageHeading.getText();
        logger.info("Returned warning message was: {}", MessageTxt);
        return MessageTxt;
    }

    public String getHeading() {
        WaitForElement.waitUntilElementIsVisible(FalseLoginHeading);
        String FalseLoginTxt = FalseLoginHeading.getText();
        logger.info("Returned warning message was: {}", FalseLoginTxt);
        return FalseLoginTxt;
    }


}