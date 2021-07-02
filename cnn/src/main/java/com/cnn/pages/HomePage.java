package com.cnn.pages;

import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

    private static Logger LOGGER = Logger.getLogger(HomePage.class);

@FindBy(xpath = "(//div[@id='account-icon-button'])[1]")
    private WebElement clickOnAccountButton;

@FindBy(xpath = "//input[@aria-label='Email address']")
private WebElement clickOnTheEmailAddressField;

@FindBy(xpath = "//input[@aria-label='Password']")
private WebElement clickOnThePasswordField;

@FindBy(xpath = "//button[@id='login-form-button' and @type='submit']")
private WebElement clickOnTheLogInButton;

@FindBy(id = "(//*[@class='cnn-badge-icon'])[1]")
private WebElement clickOnTheHomeButton;

@FindBy(id = "menuButton")
private WebElement clickOnTheMenuButton;

@FindBy(xpath = "//a[@type='collapsed' and @name='us']")
private WebElement clickOnTheNavigationMenuBarUS;

@FindBy(xpath = "(//button[@aria-label='Search'])[1]")
private WebElement clickEnterOnTheSearchBar;

@FindBy(xpath = "(//*[@class='search-icon'])[1]")
private WebElement clickOnTheSearchIcon;

@FindBy(id = "header-search-bar")
private WebElement clickOnTheHeaderSearchBar;

@FindBy(xpath = "//h3[@class='cnn-search__result-headline']")
private WebElement clickOnTheNews;

@FindBy(xpath = "(//a[@name='userLogout'])[1]")
private WebElement clickOnTheLogOutButton;

@FindBy(xpath = "(//a[@name='userSettings'])[1]")
private WebElement clickOnTheUserSettings;



public void userLogIn(){
    clickOnAccountButton.click();
    clickOnTheEmailAddressField.sendKeys("mnfattah_j@yahoo.com");
    clickOnThePasswordField.sendKeys("Afifa21lina@");
    clickOnTheLogInButton.click();
    TestBase.sleepFor(2);
    clickOnAccountButton.click();
    clickOnTheUserSettings.click();
    TestBase.sleepFor(1);
    String text1 = TestBase.driver.findElement(By.xpath("//input[@id='email-address-input']")).getAttribute("value");
    Assert.assertTrue(text1.contains("."), "You are not logged in");
    ExtentTestManager.log(text1 + " has been displayed to add or update more information", LOGGER);

}

public void menuBar(){
    clickOnTheMenuButton.click();
    String text = TestBase.driver.findElement(By.id("closeIconTitle")).getText();
    Assert.assertTrue(text.contains("Close"), "The menu bar is not displayed");
    ExtentTestManager.log(text + ": if you want to close the menu", LOGGER);
}

public void navigationTab(){
    clickOnTheNavigationMenuBarUS.click();
    String text1 = TestBase.driver.findElement(By.xpath("//h1[@class='metadata-header__title']")).getText();
    Assert.assertTrue(text1.contains("US"), "The navigation bar for US is not displayed");
    ExtentTestManager.log(text1 + " page has been displayed", LOGGER);
}

public void searchForANews(){
    clickOnTheSearchIcon.click();
    clickOnTheHeaderSearchBar.sendKeys("How to improve posture and relieve pain with your breath");
    clickEnterOnTheSearchBar.click();
    TestBase.sleepFor(3);
    clickOnTheNews.click();
    TestBase.sleepFor(5);
    String text = TestBase.driver.findElement(By.tagName("h1")).getText();
    Assert.assertTrue(text.contains("and"), "The news is not displayed");
    ExtentTestManager.log(text + ": article has been displayed", LOGGER);
}

public void userLogOut(){
    clickOnAccountButton.click();
    clickOnTheEmailAddressField.sendKeys("mnfattah_j@yahoo.com");
    clickOnThePasswordField.sendKeys("Afifa21lina@");
    clickOnTheLogInButton.click();
    TestBase.sleepFor(2);
    clickOnAccountButton.click();
    clickOnTheLogOutButton.click();
    TestBase.sleepFor(1);
    clickOnAccountButton.click();
    String text1 = TestBase.driver.findElement(By.id("login-title")).getText();
    Assert.assertTrue(text1.contains("Log In"), "You are not logged out");
    ExtentTestManager.log( "You are logout successfully", LOGGER);
}

}
