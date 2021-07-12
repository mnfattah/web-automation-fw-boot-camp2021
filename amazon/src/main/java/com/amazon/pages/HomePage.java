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
    private WebElement clickOnThePasswordField;

    @FindBy(id = "signInSubmit")
    private WebElement clickOnSubmitButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement usernameConfirmation;

    @FindBy(id = "nav-item-signout")
    private WebElement clickOnSignOutButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement clickOnAccountDropDown;

    @FindBy(xpath = "//*[@id='authportal-main-section']//h1")
    private WebElement getTextFromThePageHeader;


    public void clickOnTheSignInButton(){
        signIn.click();
    }

    public void writeAnEmailAddressInTheFieldToSignIN(String email){
        emailAddress.sendKeys(email);
        Assert.assertTrue(emailAddress.isDisplayed());
        clickOnContinue.click();
        }

    public void writeAPasswordInTheFieldToSignIN(String password){
        clickOnThePasswordField.sendKeys(password);
        Assert.assertTrue(clickOnThePasswordField.isDisplayed());
    }

    public void clickOnTheSubmitButtonToSignIN(){
        clickOnSubmitButton.click();
        }

    public void getUsernameForTheSignInConfirmation(){
        String text=usernameConfirmation.getText();
        Assert.assertTrue(text.contains("testUser"), "log didn't contain customer name");
        ExtentTestManager.log(text+" has logged in successfully", LOGGER);
    }

    public void userCanSignOutFromAmazonWebsite(){
        Actions action = new Actions(TestBase.driver);
        action.moveToElement(clickOnAccountDropDown).moveToElement(clickOnSignOutButton).click().build().perform();
        String text = getTextFromThePageHeader.getText();
        Assert.assertTrue(text.contains("Sign-In"), "Sign in page is not displayed");
    }

/*
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
*/

}
