package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;



public class CartPage {

    private Logger logger = LogManager.getLogger(CartPage.class);

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    private WebElement ProceedToCheckout1;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    private WebElement ProceedToCheckout2;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    private WebElement ProceedToCheckout3;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    private WebElement ProceedToCheckout4;

    @FindBy(xpath = "//*[@id=\"addressesAreEquals\"]")
    private WebElement addressesCheckbox;

    @FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
    private WebElement CommentsField;

    @FindBy(xpath = "//*[@id=\"cgv\"]")
    private WebElement termsAndConditionsCheckbox;

    //payment methods

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    private WebElement bankWire;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    private WebElement Check;

    //final alert (in case of a successful order "Your order on My Store is complete.")
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[1]")
    private WebElement finalAlert;

    public CartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String Purchase(){

        // Create an instance of JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();;
        // Scroll the window down by 800 pixels
        js.executeScript("window.scrollBy(0,800);");
        WaitForElement.waitUntilElementIsVisible(ProceedToCheckout1);
        ProceedToCheckout1.click();

        js.executeScript("window.scrollBy(0,1000);");
        ProceedToCheckout2.click();

        js.executeScript("window.scrollBy(0,1000);");
        termsAndConditionsCheckbox.click();
        ProceedToCheckout3.click();
        Check.click();
        ProceedToCheckout4.click();

        String finalAlertText = finalAlert.getText();

        return finalAlertText;
    }

}
