package com.amazon.pages;

import com.pnt.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement typeInSearchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement clickOnSubmitButtonForSearch;

    @FindBy(xpath = "//*[@id='search']//h2/a")
    private WebElement clickOntheFirstItemFromTheBrowsingList;

    @FindBy(id = "add-to-cart-button")
    private WebElement addTheItemInCart;

    @FindBy(id = "huc-v2-order-row-confirm-text")
    private WebElement confirmationMessageForAddingItem;

    public void typeAProductNameInSearchBox(String itemName){
        typeInSearchBox.sendKeys(itemName);
        Assert.assertTrue(typeInSearchBox.isDisplayed());
    }

    public void clickTheSubmitButtonForSearch(){
        clickOnSubmitButtonForSearch.click();
        Assert.assertTrue(clickOnSubmitButtonForSearch.isDisplayed());
    }

    public void selectTheFirstItemFromTheSearchList(){
        clickOntheFirstItemFromTheBrowsingList.click();

    }

    public void addTheSelectedItemInTheCart(){
        addTheItemInCart.click();
        String text = confirmationMessageForAddingItem.getText();
        Assert.assertTrue(text.contains("Added"), "Cart does not contain any product");

    }
}
