package com.amazon.pages;

import com.pnt.base.ConnectDB;
import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.ArrayList;

public class SearchPage {

    private static Logger LOGGER = Logger.getLogger(SearchPage.class);

    @FindBy(id = "twotabsearchtextbox")
    private WebElement typeInSearchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement clickOnSubmitButtonForSearch;

    @FindBy(xpath = "//*[@id='search']//h2/a")
    private WebElement clickOntheFirstItemFromTheBrowsingList;

    @FindBy(xpath = "//*[@id='search']//h1/div/div[1]/div/div")
    private WebElement getTextFromTheSearchPageHeader;

    @FindBy(xpath = "//div[@data-keyword='pencil case']")
    private WebElement autoSuggestion;

    @FindBy(id = "acrCustomerReviewText")
    private WebElement getTextFromCustomerReviews;

    @FindBy(id = "priceblock_ourprice")
    private WebElement getPrice;

    @FindBy(xpath = "(//*[@id='search']//div/span[3])[1]")
    private WebElement verifyItems;

    public void typeAProductNameInTheSearchBox(String searchItemName){
        typeInSearchBox.sendKeys(searchItemName);
        Assert.assertTrue(typeInSearchBox.isDisplayed());
    }

    public void ClickOnTheSubmitButtonForSearchTheItem(){
        clickOnSubmitButtonForSearch.click();
        String log = getTextFromTheSearchPageHeader.getText();
        Assert.assertTrue(log.contains("pen"), "log didn't contain the item you are searching");
    }

    public void validateUserCanPerformAutoSuggestionFromTheSearchList(){
        WebDriverWait wait = new WebDriverWait(TestBase.driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-keyword='pencil case']")));
        element.click();
        String text=typeInSearchBox.getAttribute("value");
        Assert.assertTrue(text.contains("case"), "pencil case was not selected in the search box");
    }
    public void navigateToTheProducts(){
        clickOntheFirstItemFromTheBrowsingList.click();
        String log = getTextFromCustomerReviews.getText();
        Assert.assertTrue(log.contains("ratings"), "log didn't contain customer ratings");
        String log1 = getPrice.getText();
        Assert.assertTrue(log1.contains("$"), "log didn't contain the price");
        ExtentTestManager.log("This item has "+log+" & the price of the item is "+log1, LOGGER);
    }

    public void verifyItemsFromTheSearchBox(){
        clickOnSubmitButtonForSearch.click();
        String log=verifyItems.getText();
        Assert.assertTrue(log.contains("art"), "log didn't contain customer name");
        ExtentTestManager.log(log + " items have been displayed", LOGGER);
    }
}
