package com.amazon.tests;

import com.amazon.data.DataProvidersForTest;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SearchPage;
import com.pnt.base.ConnectDB;
import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class SearchTests extends TestBase {

    private static Logger LOGGER = Logger.getLogger(SearchTests.class);
    private HomePage homePage;
    private SearchPage searchPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUpPOM(){

        homePage = PageFactory.initElements(driver, HomePage.class);
        searchPage=PageFactory.initElements(driver, SearchPage.class);
        cartPage=PageFactory.initElements(driver,CartPage.class);

    }

    @Test(enabled = true, dataProviderClass = DataProvidersForTest.class,dataProvider = "getDataForSignIN")
    public void validateUserCanSignInOnAmazonWebsite(String email, String password){
        homePage.clickOnTheSignInButton();
        ExtentTestManager.log("The Sign In Button has been clicked", LOGGER);
        homePage.writeAnEmailAddressInTheFieldToSignIN(email);
        ExtentTestManager.log("An email address has been typed in the email address field", LOGGER);
        homePage.writeAPasswordInTheFieldToSignIN(password);
        ExtentTestManager.log("A password has been provided in the password field", LOGGER);
        homePage.clickOnTheSubmitButtonToSignIN();
        ExtentTestManager.log("The submit button has been clicked", LOGGER);
        homePage.getUsernameForTheSignInConfirmation();

    }

    @Test(enabled = true, dataProviderClass = DataProvidersForTest.class,dataProvider = "getDataForSearchTest")
    public void validateUserCanBrowseProductsAndAddItToTheCart(String itemName){
        cartPage.typeAProductNameInSearchBox(itemName);
        ExtentTestManager.log("A product name has been typed in the search box", LOGGER);
        cartPage.clickTheSubmitButtonForSearch();
        ExtentTestManager.log("The submit button has been clicked", LOGGER);
        cartPage.selectTheFirstItemFromTheSearchList();
        ExtentTestManager.log("The first item has been selected from the search list", LOGGER);
        cartPage.addTheSelectedItemInTheCart();
        ExtentTestManager.log("One item has been added into the cart", LOGGER);

    }

    @Test(enabled = true, dataProviderClass = DataProvidersForTest.class,dataProvider = "getDataForSearchTest")
    public void validateUserCanSearchAndVerifyItems(String searchItem){
        searchPage.typeAProductNameInTheSearchBox(searchItem);
        ExtentTestManager.log("typed pen in the search bar", LOGGER);
        searchPage.ClickOnTheSubmitButtonForSearchTheItem();
        ExtentTestManager.log("Pen is in your search list", LOGGER);

    }

    @Test(enabled = true, dataProviderClass = DataProvidersForTest.class, dataProvider = "getDataForAutoSuggestionTest")
    public void validateUserCanVerifyAutoSuggestion(String searchItemName){
        searchPage.typeAProductNameInTheSearchBox(searchItemName);
        ExtentTestManager.log("typed your item name in the search box", LOGGER);
        searchPage.validateUserCanPerformAutoSuggestionFromTheSearchList();
        ExtentTestManager.log("One item has been selected from the autosuggestion list", LOGGER);

    }

    @Test(enabled = true, dataProviderClass = DataProvidersForTest.class,dataProvider = "getDataForSearchTest")
    public void validateUserCanNavigateProduct(String itemName){
        searchPage.typeAProductNameInTheSearchBox(itemName);
        ExtentTestManager.log("One item has been typed in the search box", LOGGER);
        searchPage.ClickOnTheSubmitButtonForSearchTheItem();
        ExtentTestManager.log("The submit button has been clicked", LOGGER);
        searchPage.navigateToTheProducts();
    }

    @Test(enabled = true, dataProviderClass = DataProvidersForTest.class, dataProvider = "getDataForSignIN")
    public void validateUserCanSignOutFromAmazonWebsite(String email, String pass){
        validateUserCanSignInOnAmazonWebsite(email,pass);
        homePage.userCanSignOutFromAmazonWebsite();
        ExtentTestManager.log("You are signed out now", LOGGER);
    }

    @Test(enabled = true)
    public void validateUserBeingAbleToSearchForAnItemFromDatabase() throws SQLException {
        String query = "select * from testdata;";
        ArrayList<String> datas = ConnectDB.connectToDbAndGetData(query, "bookName");
        searchPage.typeAProductNameInTheSearchBox(datas.get(0));
        ExtentTestManager.log("Java Books typed in the search bar", LOGGER);
        searchPage.verifyItemsFromTheSearchBox();
    }


}
