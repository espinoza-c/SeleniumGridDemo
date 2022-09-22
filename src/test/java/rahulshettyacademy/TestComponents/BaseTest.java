package rahulshettyacademy.TestComponents;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import rahulsherryacademy.pageobjects.LandingPage;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public DesiredCapabilities dc;
    public LandingPage landingPage;


    public WebDriver initializeDriver(String browser) throws IOException {

        if(browser.equalsIgnoreCase("chrome")){
            dc = new DesiredCapabilities();
            dc.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
        }
        else if(browser.equalsIgnoreCase("firefox")){
            dc = new DesiredCapabilities();
            dc.setBrowserName("firefox");
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
        }
        else if(browser.equalsIgnoreCase("MicrosoftEdge")){
            dc = new DesiredCapabilities();
            dc.setBrowserName("MicrosoftEdge");
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;

    }
    @BeforeMethod
    @Parameters("browser")
    public LandingPage launchApplication(String browser) throws IOException {
        driver = initializeDriver(browser);
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
