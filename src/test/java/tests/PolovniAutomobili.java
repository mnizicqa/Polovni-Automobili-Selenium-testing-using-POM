package tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class PolovniAutomobili extends BaseTest{

    HomePage homePage;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) throws Exception {
        init(browser);
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit){
        if(quit.equalsIgnoreCase("Yes")){
            quit();
        }
    }

    @Epic("Pretraga")
    @Feature("Pretraga automobila")
    @Story("Pretraga automobila marke BMW")
    @Test(description = "Testiranje pretrage na sajtu")
    @Description("Testiranje pretrage automobila na sajtu")
    @Step("Korištenje pretrage")
    @Link("https://www.polovniautomobili.com/")
    @Issue("BD-275")
    @TmsLink("DEMO-1")
    @Severity(SeverityLevel.CRITICAL)
    @Parameters({"env"})
    public void searchVehicle() throws Exception {
        openApp("PROD");
        HomePage homePage = new HomePage(driver);
        homePage.searchCar("BMW","335", "30000", "2015 god.", "Beograd", "Samo polovna vozila");
        reportScreenshot("Provjera uspjeha pretrage automobila marke BMW", "uspješna pretraga");
    }
}