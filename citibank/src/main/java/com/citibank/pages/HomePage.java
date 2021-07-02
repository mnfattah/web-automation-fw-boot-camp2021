package com.citibank.pages;

import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class HomePage {

    private static Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(id = "signOnFocus")
    private WebElement clickOnSignOnButton;

    @FindBy(id = "username")
    private WebElement clickOnTheUserNameField;

    @FindBy(id = "password")
    private WebElement clickOnThePasswordField;

    @FindBy(id = "signInBtn")
    private WebElement enterTheSignOnButton;

    @FindBy(id = "navcreditCardmainAnchor0")
    private WebElement clickOnTheCreditCardMenu;

    @FindBy(id = "Cash Back Credit CardschildLink4")
    private WebElement clickOnCashBackCreditCards;

    @FindBy(id = "navbankingmainAnchor1")
    private WebElement clickOnTheBankingMenu;

    @FindBy(id = "SavingschildLink1")
    private WebElement clickOnTheSavings;

    @FindBy(id = "zipcode")
    private WebElement clickOnTheZipcode;

    @FindBy(xpath = "(//button[contains(text(),'Submit')])[1]")
    private WebElement enterTheSubmitButton;

    @FindBy(id = "personetics-citi-menu")
    private WebElement clickOnTheSearchMenu;

    @FindBy(id = "autocomplete-search")
    private WebElement clickOnTheSearchBox;

    @FindBy(xpath = "//a[contains(text(),' Mortgage - Refinancing a ')]")
    private WebElement clickOnTheRefinancingAHomeLink;

    @FindBy(id = "investingmainAnchor3")
    private WebElement clickOnTheInvestingMenu;

    @FindBy(id = "Citi Wealth BuilderchildLink2")
    private WebElement clickOnTheCityWealthBuilder;


    public void signIn(String username, String password){
        clickOnTheUserNameField.sendKeys(username);
        clickOnThePasswordField.sendKeys(password);
        enterTheSignOnButton.click();
        String text = TestBase.driver.findElement(By.xpath("//span[@class='strong']")).getText();
        Assert.assertTrue(text.contains("Trouble"), "You are logged in without valid credentials");
        ExtentTestManager.log(text + " : You cannot log in without valid credentials", LOGGER);
    }

    public void creditCards(){
        WebElement menu = clickOnTheCreditCardMenu;
        Actions m = new Actions(TestBase.driver);
        m.moveToElement(menu).build().perform();
        TestBase.sleepFor(1);
        clickOnCashBackCreditCards.click();
        TestBase.sleepFor(1);
        String text = TestBase.driver.findElement(By.xpath("//h1[contains(text(),'Cash Back Credit Cards')]")).getText();
        Assert.assertTrue(text.contains("Cash"), "The cash back credit cards webpage is not displayed");
        ExtentTestManager.log(text + " : webpage displayed", LOGGER);
    }

    public void BankingNavigationMenu(){
        WebElement menu= clickOnTheBankingMenu;
        Actions m = new Actions(TestBase.driver);
        m.moveToElement(menu).build().perform();
        TestBase.sleepFor(1);
        clickOnTheSavings.click();
        TestBase.sleepFor(1);
        clickOnTheZipcode.sendKeys("22309");
        enterTheSubmitButton.click();
        TestBase.sleepFor(1);
        String text = TestBase.driver.findElement(By.xpath("//p[contains(text(),'Simplify Your Savings')]")).getText();
        Assert.assertTrue(text.contains("Savings"), "Savings webpage is not displayed");
        ExtentTestManager.log(text + " : webpage displayed", LOGGER);
    }

    public void searchItems(){
        clickOnTheSearchMenu.click();
        clickOnTheSearchBox.sendKeys("Refinance home");
        clickOnTheSearchBox.sendKeys(Keys.ENTER);
        clickOnTheRefinancingAHomeLink.click();
        String text = TestBase.driver.findElement(By.xpath("//h1[@class='title-h1 spacing-bottom-ripoff-sm']")).getText();
        Assert.assertTrue(text.contains("Refinancing"), "Refinancing Your Home- webpage is not displayed");
        ExtentTestManager.log(text + " : webpage displayed", LOGGER);
    }

    public void investingMenu(){
        WebElement menu= clickOnTheInvestingMenu;
        Actions m = new Actions(TestBase.driver);
        m.moveToElement(menu).build().perform();
        TestBase.sleepFor(1);
        clickOnTheCityWealthBuilder.click();
        String text = TestBase.driver.findElement(By.xpath("(//div[@class='banner-info'])[1]")).getText();
        Assert.assertTrue(text.contains("Wealth"), "Refinancing Your Home- webpage is not displayed");
        ExtentTestManager.log(text + ": Citybank feature that offers for their customer", LOGGER);
    }

    public void validateLinks() {

        String url = "";

        HttpURLConnection huc = null;

        int respCode = 200;

        List<WebElement> links = TestBase.driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()) {

            url = it.next().getAttribute("href");

            System.out.println(url);

            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            if (!url.startsWith("https://www.citi.com/")) {
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }

            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    }

