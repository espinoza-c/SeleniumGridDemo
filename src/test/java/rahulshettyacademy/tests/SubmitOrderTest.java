package rahulshettyacademy.tests;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import rahulsherryacademy.pageobjects.CartPage;
import rahulsherryacademy.pageobjects.CheckoutPage;
import rahulsherryacademy.pageobjects.ConfirmationPage;
import rahulsherryacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class SubmitOrderTest extends BaseTest {

    @Test
    public void submitOrder() throws InterruptedException, IOException {
        String productName = "SOIL";
        ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");

        List<WebElement> products = productCatalogue.getPoductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();

        boolean match = cartPage.verifyProductDisplay(productName);
        assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage=checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConffirmationMEssage();
        assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }
}
