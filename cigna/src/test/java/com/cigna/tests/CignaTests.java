package com.cigna.tests;

import com.cigna.data.DataProvidersForTest;
import com.cigna.pages.HomePage;
import com.cigna.pages.NavigationPage;
import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CignaTests extends TestBase {

    private static Logger LOGGER = Logger.getLogger(NavigationPage.class);

    private HomePage homePage;
    private NavigationPage navigationPage;

    @BeforeMethod
    public void setUpPOM(){
        homePage= PageFactory.initElements(driver,HomePage.class);
        navigationPage=PageFactory.initElements(driver, NavigationPage.class);

    }

    @Test(enabled = true, dataProviderClass = DataProvidersForTest.class, dataProvider = "getDataForLogInTest")
    public void validateUserCannotLoginWithoutCredentials(String username, String password){
        homePage.typeUsernameInUsernameField(username);
        ExtentTestManager.log( "Username has been typed", LOGGER);
        homePage.typePasswordInPasswordField(password);
        ExtentTestManager.log( "Password has been typed", LOGGER);
        homePage.clickOnTheLogInButtonToLogIn();
        ExtentTestManager.log( "The log in button has been clicked", LOGGER);
    }

    @Test(enabled = true)
    public void validateUserCanSelectEmployersAndBrokersMenuFromNavigationMenuBar(){
        navigationPage.clickOnTheEmployersAndBrokersMenuFromNavigationBar();
        ExtentTestManager.log( "Employeers And Brokers Menu has been clicked", LOGGER);
        navigationPage.clickOnThePlanAndServicesTab();
        ExtentTestManager.log( "Plan And Services tab has been clicked", LOGGER);
        navigationPage.clickOnThePharmacyMenu();
        ExtentTestManager.log( "The Pharmacy Menu has been clicked", LOGGER);
      }


    @Test(enabled = true)
    public void validateUserCanSelectMedicareMenuFromNavigationBar(){
        navigationPage.clickOnTheMedicareMenuFromNavigationMenu();
        ExtentTestManager.log( "The Medicare Menu has been clicked", LOGGER);
        navigationPage.clickOnUnderstandingMedicareTabFromMenu();
        ExtentTestManager.log( "The Understanding Medicare tab has been clicked", LOGGER);
        navigationPage.clickOnTheWhatIsMedicareLink();
        ExtentTestManager.log( "The medicare link has been clicked", LOGGER);
    }

    @Test(enabled = true)
    public void validateUserCanSelectIndividualsAndFamiliesMenuFromNavigationBar(){
        navigationPage.clickOnIndividualsAndFamiliesMenuFromNavigationMenu();
        ExtentTestManager.log( "The Individuals And Families Menu has been clicked", LOGGER);
        navigationPage.clickOnHealthAndWellnessTabFromMenu();
        ExtentTestManager.log( "The Health And Wellness tab has been clicked", LOGGER);
        navigationPage.clickOnDentalHealthLinkFromMenu();
        ExtentTestManager.log( "The Dental menu has been clicked", LOGGER);
    }

    @Test(enabled = true)
    public void validateUserCanSelectHealthCareProvidersMenuFromNavigationBar(){
        navigationPage.clickOnTheHealthCareProvidersMenuFromNavigationBar();
        ExtentTestManager.log( "The Health Care Providers Menu has been clicked", LOGGER);
        navigationPage.clickOnTheProviderResourcesTabFromMenu();
        ExtentTestManager.log( "The Provider And Resources Tab has been clicked", LOGGER);
        navigationPage.clickOnTheProgramsForPatientsLinkFromMenu();
        ExtentTestManager.log( "The Programs For Patients menu has been clicked", LOGGER);
    }



}
