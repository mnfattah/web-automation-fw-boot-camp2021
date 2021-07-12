package com.cigna.pages;

import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NavigationPage {

    private static Logger LOGGER = Logger.getLogger(NavigationPage.class);

    @FindBy(id = "employers-brokers-level-one-link")
    private WebElement employeersAndBrokersMenu;

    @FindBy(id = "plans-services-2-tab")
    private WebElement clickOnThePlansAndServicesTab;

    @FindBy(linkText = "Pharmacy")
    private WebElement clickOnThePharmacy;

    @FindBy(xpath = "//h1[contains(text(),'Cigna Integrated Pharmacy')]")
    private WebElement getTextFromThePharmacyPageHeader;

    @FindBy(id = "medicare-level-one-link")
    private WebElement medicareMenu;

    @FindBy(id = "understanding-medicare-tab")
    private WebElement clickOnUnderstandingMedicareTab;

    @FindBy(xpath = "//a[contains(text(),'What is Medicare?')]")
    private WebElement clickOnWhatIsMedicareLink;

    @FindBy(xpath = "//h1[contains(text(),'What is Medicare?')]")
    private WebElement whatIsMedicare;

    @FindBy(id = "individuals-families-level-one-link")
    private WebElement individualsAndFamiliesMenu;

    @FindBy(id = "health-wellness-tab")
    private WebElement clickOnHealthAndWellnessTab;

    @FindBy(xpath = "//a[contains(text(),'Dental Health')]")
    private WebElement clickOnDentalHealthLink;

    @FindBy(xpath = "//h1[contains(text(),'Dental Health')]")
    private WebElement dentalHealth;

    @FindBy(id = "health-care-providers-level-one-link")
    private WebElement healthCareProvidersMenu;

    @FindBy(id = "resources-2-tab")
    private WebElement clickOnTheProviderResourcesTab;

    @FindBy(xpath = "//a[contains(text(),'Programs for Patients')]")
    private WebElement clickOnTheProgramsForPatientsLink;

    @FindBy(xpath = "//h1[contains(text(),'Programs for Patients')]")
    private WebElement programsForPatients;

    public void windowHandle(WebElement menu){
        Actions actions = new Actions(TestBase.driver);
        actions.moveToElement(menu).build().perform();
    }


    public void clickOnTheEmployersAndBrokersMenuFromNavigationBar(){
        windowHandle(employeersAndBrokersMenu);
        Assert.assertTrue(employeersAndBrokersMenu.isDisplayed());

    }

    public void clickOnThePlanAndServicesTab(){
        clickOnThePlansAndServicesTab.click();
        Assert.assertTrue(clickOnThePlansAndServicesTab.isDisplayed());
    }

    public void clickOnThePharmacyMenu(){
        clickOnThePharmacy.click();
        String text = getTextFromThePharmacyPageHeader.getText();
        Assert.assertTrue(text.contains("Pharmacy"), "The pharmacy webpage is not displayed");

    }

    public void clickOnTheMedicareMenuFromNavigationMenu(){
        windowHandle(medicareMenu);
        Assert.assertTrue(medicareMenu.isDisplayed());
    }

    public void clickOnUnderstandingMedicareTabFromMenu(){
        clickOnUnderstandingMedicareTab.click();
        Assert.assertTrue(clickOnUnderstandingMedicareTab.isDisplayed());
    }

    public void clickOnTheWhatIsMedicareLink(){
        clickOnWhatIsMedicareLink.click();
        String text = whatIsMedicare.getText();
        Assert.assertTrue(text.contains("Medicare"), "The medicare webpage is not displayed");
    }

    public void clickOnIndividualsAndFamiliesMenuFromNavigationMenu(){
        windowHandle(individualsAndFamiliesMenu);
        Assert.assertTrue(individualsAndFamiliesMenu.isDisplayed());
    }

    public void clickOnHealthAndWellnessTabFromMenu(){
        clickOnHealthAndWellnessTab.click();
        Assert.assertTrue(clickOnHealthAndWellnessTab.isDisplayed());
    }

    public void clickOnDentalHealthLinkFromMenu(){
        clickOnDentalHealthLink.click();
        String text = dentalHealth.getText();
        Assert.assertTrue(text.contains("Dental"), "The Dental webpage is not displayed");
    }

    public void clickOnTheHealthCareProvidersMenuFromNavigationBar(){
        windowHandle(healthCareProvidersMenu);
        Assert.assertTrue(healthCareProvidersMenu.isDisplayed());

    }

    public void clickOnTheProviderResourcesTabFromMenu(){
        clickOnTheProviderResourcesTab.click();
        Assert.assertTrue(clickOnTheProviderResourcesTab.isDisplayed());
    }

    public void clickOnTheProgramsForPatientsLinkFromMenu(){
        clickOnTheProgramsForPatientsLink.click();
        String text = programsForPatients.getText();
        Assert.assertTrue(text.contains("Programs"), "The programs for patients webpage is not displayed");

    }

}
