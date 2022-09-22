package rahulsherryacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulsherryacademy.AbstractComponents.AbstractComponent;


import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css="..ng-animating")
    WebElement spinner;


    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    public List<WebElement> getPoductList(){
        waitForElementToAppear(productsBy);
        return products;
    }
    public WebElement getProductByName(String productName){
        return getPoductList().stream().filter(product -> product
                .findElement(By.cssSelector("b"))
                .getText()
                .equals(productName))
                .findFirst()
                .orElse(null);
    }
    public void addProductToCart(String productName) throws InterruptedException {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        Thread.sleep(1000);
        waitForElementToDissapear(spinner);


    }
}
