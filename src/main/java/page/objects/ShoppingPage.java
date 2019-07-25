package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.interactions.Actions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;
import org.openqa.selenium.JavascriptExecutor;


public class ShoppingPage {

    private Logger logger = LogManager.getLogger(ShoppingPage.class);

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    public WebElement Women;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    private WebElement Dresses;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a")
    private WebElement SummerDresses;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[7]/div/div[1]/div/a[1]/img")
    private WebElement ChiffonDressFrame;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[7]/div/div[2]/div[2]/a[1]/span")
    private WebElement ChiffonDressAdd;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[7]/div/div[2]/h5/a")
    private WebElement ChiffonDressLabel1;

    @FindBy(css = ".cart_description>.product-name a[href='http://automationpractice.com/index.php?id_product=7&controller=product#/size-s/color-yellow']")
    private WebElement ChiffonDressLabel2;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    private WebElement ToCheckout;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    private WebElement TShirts;

    public ShoppingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
   }


    public static void scrollDown() {

        // Create an instance of JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();

        // Scroll the window down by 1800 pixels
        js.executeScript("window.scrollBy(0,1800);");
    }


    public String findAdress()
    {
        Women.click();

        scrollDown();

        Actions action = new Actions(DriverManager.getWebDriver());
        action.moveToElement(ChiffonDressFrame).perform();
        WaitForElement.waitUntilElementIsVisible(ChiffonDressLabel1);
        String Label1=ChiffonDressLabel1.getText();
        ChiffonDressAdd.click();
        return Label1;
    }

    public String goToCart()
    {
        scrollDown();
        WaitForElement.waitUntilElementIsVisible(ToCheckout);
        ToCheckout.click();
        WaitForElement.waitUntilElementIsVisible(ChiffonDressLabel2);
        String Label2=ChiffonDressLabel2.getText();

        return Label2;
    }

}