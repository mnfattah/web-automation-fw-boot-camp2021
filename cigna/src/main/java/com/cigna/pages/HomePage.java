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

    @FindBy(id = "plans-services-2-tab")
    private WebElement clickOnThePlansAndServicesTab;

    @FindBy(linkText = "Pharmacy")
    private WebElement clickOnThePharmacy;

    @FindBy(id = "medicare-level-one-link")
    private WebElement medicareMenu;

    @FindBy(id = "understanding-medicare-tab")
    private WebElement clickOnUnderstandingMedicareTab;

    @FindBy(xpath = "//a[contains(text(),'What is Medicare?')]")
    private WebElement clickOnWhatIsMedicareLink;

    @FindBy(id = "individuals-families-level-one-link")
    private WebElement individualsAndFamiliesMenu;

    @FindBy(id = "health-wellness-tab")
    private WebElement clickOnHealthAndWellnessTab;

    @FindBy(xpath = "//a[contains(text(),'Dental Health')]")
    private WebElement clickOnDentalHealthLink;

    @FindBy(id = "health-care-providers-level-one-link")
    private WebElement healthCareProvidersMenu;

    @FindBy(id = "resources-2-tab")
    private WebElement clickOnTheProviderResourcesTab;

    @FindBy(xpath = "//a[contains(text(),'Programs for Patients')]")
    private WebElement clickOnTheProgramsForPatientsLink;

    public void userLogIn(String username, String password){
        clickOnTheLogInButton.click();
        Set<String> w= TestBase.driver.getWindowHandles();
        System.out.println(w);
        String currentWindow = TestBase.driver.getWindowHandle();
        for (String newW:w){
            if(!newW.equalsIgnoreCase("currentWindow"));{
                TestBase.driver.switchTo().window(newW);

            }
        }
        clickOnTheUsernameField.sendKeys(username);
        clickOnThePasswordField.sendKeys(password);
        enterTheLogInButton.click();
        String text = TestBase.driver.findElement(By.id("alertmessage")).getText();
        Assert.assertTrue(text.contains("not"), "You are logged in without valid credentials");
        ExtentTestManager.log(text + " : You cannot log in without valid credentials", LOGGER);
    }

    public void navigationBar(){
        WebElement menu = employeersAndBrokersMenu;
        Actions m = new Actions(TestBase.driver);
        m.moveToElement(menu).build().perform();
        //TestBase.driver.switchTo().alert().accept();
        TestBase.sleepFor(1);
        clickOnThePlansAndServicesTab.click();
        TestBase.sleepFor(1);
        clickOnThePharmacy.click();
        TestBase.sleepFor(1);
        String text = TestBase.driver.findElement(By.xpath("//h1[contains(text(),'Cigna Integrated Pharmacy')]")).getText();
        Assert.assertTrue(text.contains("Pharmacy"), "The pharmacy webpage is not displayed");
        ExtentTestManager.log(text + " : webpage displayed", LOGGER);
    }

    public void medicareMenu(){
        WebElement menu = medicareMenu;
        Actions m = new Actions(TestBase.driver);
        m.moveToElement(menu).build().perform();
        TestBase.sleepFor(1);
        clickOnUnderstandingMedicareTab.click();
        TestBase.sleepFor(1);
        clickOnWhatIsMedicareLink.click();
        TestBase.sleepFor(1);
        String text = TestBase.driver.findElement(By.xpath("//h1[contains(text(),'What is Medicare?')]")).getText();
        Assert.assertTrue(text.contains("Medicare"), "The medicare webpage is not displayed");
        ExtentTestManager.log(text + " : webpage displayed", LOGGER);
    }

    public void individualsAndFamiliesMenu(){
        WebElement menu = individualsAndFamiliesMenu;
        Actions m = new Actions(TestBase.driver);
        m.moveToElement(menu).build().perform();
        TestBase.sleepFor(1);
        clickOnHealthAndWellnessTab.click();
        TestBase.sleepFor(1);
        clickOnDentalHealthLink.click();
        TestBase.sleepFor(1);
        String text = TestBase.driver.findElement(By.xpath("//h1[contains(text(),'Dental Health')]")).getText();
        Assert.assertTrue(text.contains("Dental"), "The dental webpage is not displayed");
        ExtentTestManager.log(text + " : webpage displayed", LOGGER);

    }

    public void healthCareProvidersMenu(){
        WebElement menu = healthCareProvidersMenu;
        Actions m = new Actions(TestBase.driver);
        m.moveToElement(menu).build().perform();
        TestBase.sleepFor(1);
        clickOnTheProviderResourcesTab.click();
        TestBase.sleepFor(1);
        clickOnTheProgramsForPatientsLink.click();
        TestBase.sleepFor(1);
        String text = TestBase.driver.findElement(By.xpath("//h1[contains(text(),'Programs for Patients')]")).getText();
        Assert.assertTrue(text.contains("Programs"), "The programs for patients webpage is not displayed");
        ExtentTestManager.log(text + " : webpage displayed", LOGGER);

    }

}
