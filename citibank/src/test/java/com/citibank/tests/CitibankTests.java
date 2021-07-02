package com.citibank.tests;

import com.citibank.data.DataProvidersForTest;
import com.citibank.pages.HomePage;
import com.pnt.base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CitibankTests extends TestBase {

    private HomePage homePage;


    @BeforeMethod
    public void setUpPOM() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test(enabled = true, dataProviderClass = DataProvidersForTest.class, dataProvider = "getDataForLogInTest")
    public void validateUserCannotSignInWithOutValidCredentials(String username, String password){
        homePage.signIn(username, password);
    }

    @Test(enabled = true)
    public void validateUserCanSelectCreditCardMenuFromTheNavigationBar(){
        homePage.creditCards();
    }

    @Test(enabled = true)
    public void validateUserCanSelectBankingMenuFromTheNavigationBar(){
        homePage.BankingNavigationMenu();
    }

    @Test(enabled = true)
    public void validateUserCanSearchAnItemThroughTheWebsite(){
        homePage.searchItems();
    }

    @Test(enabled = true)
    public void validateUserCanReadCitiBankFeaturesOfferingForTheirCustomer(){
        homePage.investingMenu();
    }

    @Test(enabled = true)
    public void validateUserCanVerifyAllOffersAndLinks(){
        homePage.validateLinks();
    }
}
