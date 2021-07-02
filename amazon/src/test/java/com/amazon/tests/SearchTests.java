package com.amazon.tests;

import com.amazon.pages.HomePage;
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


    @BeforeMethod
    public void setUpPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test(enabled = true)
    public void validateUserCanSignIn(){
        homePage.userCanSignIn();
        WebElement result = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        String log = result.getText();
        Assert.assertTrue(log.contains("testUser"), "log didn't contain customer name");
        ExtentTestManager.log(log + " has been signed in", LOGGER);

    }

    @Test(enabled = true)
    public void validateUserCanBrowseProductsAndAddItToTheCart(){
        homePage.browseProductsAndAddItCart();


    }

    @Test(enabled = true)
    public void validateUserCanSearchAndVerifyItems(){
        homePage.searchAndVerifyItem();
        ExtentTestManager.log("typed pen in the search bar", LOGGER);
        WebElement result = driver.findElement(By.xpath("//*[@id='search']//h1/div/div[1]/div/div"));
        String log = result.getText();
        Assert.assertTrue(log.contains("pen"), "log didn't contain pen");
        ExtentTestManager.log(log + " : has been displayed", LOGGER);
    }

    @Test(enabled = true)
    public void validateUserCanVerifyAutoSuggestion(){

        homePage.verifyAutoSuggession();
    }

    @Test(enabled = true)
    public void validateUserCanNavigateProduct(){
        homePage.navigateToTheProducts();

        WebElement result = driver.findElement(By.id("acrCustomerReviewText"));
        String log = result.getText();
        Assert.assertTrue(log.contains("ratings"), "log didn't contain customer ratings");
        ExtentTestManager.log(log + " : has been displayed", LOGGER);


        WebElement result1 = driver.findElement(By.id("priceblock_ourprice"));
        String log1 = result1.getText();
        Assert.assertTrue(log1.contains("$"), "log didn't contain the price");
        ExtentTestManager.log("The price "+log1 + " : has been displayed", LOGGER);

    }

    @Test(enabled = true)
    public void validateUserCanSignOut(){
        homePage.signOut();
        ExtentTestManager.log("Clicked on the Sign Out button", LOGGER);
    }

    @Test(enabled = true)
    public void validateUserBeingAbleToSearchForAnItemFromDatabase() throws SQLException {
        String query = "select * from testdata;";
        ArrayList<String> datas = ConnectDB.connectToDbAndGetData(query, "bookName");

        homePage.typeOnSearchBar(datas.get(0));
        ExtentTestManager.log("Java Books typed in the search bar", LOGGER);

        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button", LOGGER);

        WebElement result = driver.findElement(By.xpath("(//*[@id='search']//div/span[3])[1]"));
        String log = result.getText();
        Assert.assertTrue(log.contains("art"), "log didn't contain customer name");
        ExtentTestManager.log(log + " items have been displayed", LOGGER);
    }


}
