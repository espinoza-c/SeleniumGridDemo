package test.java.rahulshettyacademy.tests;

import main.java.rahulsherryacademy.pageobjects.ProductCatalogue;
import org.testng.annotations.Test;
import test.java.rahulshettyacademy.TestComponents.BaseTest;
import java.io.IOException;
import static org.testng.Assert.*;

public class ErrorValidations extends BaseTest {

    @Test
    public void invalidEmail() throws InterruptedException, IOException {
        ProductCatalogue productCatalogue = landingPage.loginApplication("anshika_gmail.com", "Iamkin00");
        assertEquals(landingPage.getErrorMessage(), "*Enter Valid Email");
    }

}
