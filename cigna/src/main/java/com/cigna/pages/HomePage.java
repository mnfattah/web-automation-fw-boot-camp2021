package com.cigna.pages;

import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Set;

public class HomePage {

    private static Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(linkText = "Log in to myCigna")
    private WebElement clickOnTheLogInButton;

    @FindBy(id = "username")
    private WebElement clickOnTheUsernameField;

    @FindBy(id = "password")
    private WebElement clickOnThePasswordField;

    @FindBy(id = "loginbutton")
    private WebElement enterTheLogInButton;

    @FindBy(id = "employers-brokers-level-one-link")
    private WebElement employeersAndBrokersMenu;

    @FindBy(id = "alertmessage")
    private WebElement alertmessage;

    public void handleCurrentWindowFromTwoWindow(){
        Set<String> w= TestBase.driver.getWindowHandles();
        System.out.println(w);
        String currentWindow = TestBase.driver.getWindowHandle();
        for (String newW:w){
            if(!newW.equalsIgnoreCase("currentWindow"));{
                TestBase.driver.switchTo().window(newW);

            }
        }
    }


    public void typeUsernameInUsernameField(String username) {
        clickOnTheLogInButton.click();
        handleCurrentWindowFromTwoWindow();
        clickOnTheUsernameField.sendKeys(username);
        Assert.assertTrue(clickOnTheUsernameField.isDisplayed());
    }

    public void typePasswordInPasswordField(String password) {
        clickOnThePasswordField.sendKeys(password);
        Assert.assertTrue(clickOnThePasswordField.isDisplayed());
    }

    public void clickOnTheLogInButtonToLogIn(){
        enterTheLogInButton.click();
        String text = alertmessage.getText();
        Assert.assertTrue(text.contains("not"), "You are logged in without valid credentials");
        ExtentTestManager.log(text + " : You cannot log in without valid credentials", LOGGER);
    }
}
