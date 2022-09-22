package rahulsherryacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulsherryacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css=".totalRow button")
    WebElement checkoutEle;

    @FindBy(css=".cartSection h3")
    private List<WebElement> cartProducts;

    @FindBy(id="login")
    WebElement submit;

    public boolean verifyProductDisplay(String productName) {
        return cartProducts.stream().anyMatch(product -> product.getText()
                .equalsIgnoreCase(productName));
    }
    public CheckoutPage goToCheckout(){
        checkoutEle.click();
        return new CheckoutPage(driver);
    }

}
