package com.amazon.pages;

import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class HomePage {

    private static Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(linkText = "Sign in")
    private WebElement signIn;

    @FindBy(id = "ap_email")
    private WebElement emailAddress;

    @FindBy(id = "continue")
    private WebElement clickOnContinue;

    @FindBy(id = "ap_password")
    private WebElement password;

    @FindBy(id = "signInSubmit")
    private WebElement clickOnSubmitButton;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement typeInSearchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement clickOnSubmitButtonForSearch;

    @FindBy(xpath = "//*[@id='search']//h2/a")
    private WebElement clickOntheFirstItemFromTheBrowsingList;

    @FindBy(id = "add-to-cart-button")
    private WebElement addTheItemInCart;

    @FindBy(id = "attach-close_sideSheet-link")
    private WebElement clickOnCloseTheSideBar;

    @FindBy(id = "nav-cart-count")
    private WebElement clickOnTheCart;

    @FindBy(id = "nav-item-signout")
    private WebElement clickOnSignOutButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement clickOnAccountDropDown;


    public void userCanSignIn(){
        signIn.click();
        emailAddress.sendKeys("mnfattah_j@yahoo.com");
        clickOnContinue.click();
        password.sendKeys("abcd1234");
        clickOnSubmitButton.click();

    }

    public void browseProductsAndAddItCart(){
        typeInSearchBox.sendKeys("pen");
        clickOnSubmitButtonForSearch.click();
        clickOntheFirstItemFromTheBrowsingList.click();
        addTheItemInCart.click();
       String text = TestBase.driver.findElement(By.id("huc-v2-order-row-confirm-text")).getText();
        Assert.assertTrue(text.contains("Added"), "Cart does not contain any product");
        ExtentTestManager.log(text + " confirms the item has been added in your cart", LOGGER);
    }

    public void searchAndVerifyItem(){
        typeInSearchBox.sendKeys("pen");
        clickOnSubmitButtonForSearch.click();

    }

    public void verifyAutoSuggession(){
        typeInSearchBox.sendKeys("pencil");
        WebDriverWait wait = new WebDriverWait(TestBase.driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-keyword='pencil case']")));
        element.click();
        String text = TestBase.driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");
        Assert.assertTrue(text.contains("case"), "pencil case was not selected in the search box");
        ExtentTestManager.log(text + " has been selected in the search box", LOGGER);

    }

    public void navigateToTheProducts(){
        typeInSearchBox.sendKeys("pen");
        clickOnSubmitButtonForSearch.click();
        clickOntheFirstItemFromTheBrowsingList.click();

    }

    public void typeOnSearchBar(String text) {
        typeInSearchBox.sendKeys(text);
    }

    public void clickOnSearchButton() {
            clickOnSubmitButtonForSearch.click();
        }


    public void signOut(){
        signIn.click();
        emailAddress.sendKeys("mnfattah_j@yahoo.com");
        clickOnContinue.click();
        password.sendKeys("abcd1234");
        clickOnSubmitButton.click();
        Actions action = new Actions(TestBase.driver);
        action.moveToElement(clickOnAccountDropDown).moveToElement(TestBase.driver.findElement(By.id("nav-item-signout"))).click().build().perform();
        String text = TestBase.driver.findElement(By.xpath("//*[@id='authportal-main-section']//h1")).getText();
        Assert.assertTrue(text.contains("Sign-In"), "Sign in page is not displayed");


    }


}
