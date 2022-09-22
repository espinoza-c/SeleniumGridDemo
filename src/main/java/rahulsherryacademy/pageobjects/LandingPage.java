package main.java.rahulsherryacademy.pageobjects;

import main.java.rahulsherryacademy.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    public WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement passwordElement;

    @FindBy(id="login")
    WebElement submit;

    @FindBy(css="div[class='invalid-feedback'] div")
    WebElement errorMessage;
    //other error that dissapears: [class*='flyInOut']
    //other error incorrect mail text: div[class='invalid-feedback'] div

    @FindBy(css="[class*='flyInOut']")
    WebElement errorPopUp;

    public ProductCatalogue loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        passwordElement.sendKeys(password);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }
    public String getErrorMessage(){
       waitForElementToAppear(errorMessage);
       return errorMessage.getText();
    }

    public String getErrorIncorrectPassword(){
        waitForElementToAppear(errorPopUp);
        return errorPopUp.getText();
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");
    }

}
