package com.cigna.tests;

import com.cigna.data.DataProvidersForTest;
import com.cigna.pages.HomePage;
import com.pnt.base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CignaTests extends TestBase {

    private HomePage homePage;

    @BeforeMethod
    public void setUpPOM(){
        homePage= PageFactory.initElements(driver,HomePage.class);
    }

    @Test(enabled = true, dataProviderClass = DataProvidersForTest.class, dataProvider = "getDataForLogInTest")
    public void validateUserCannotLoginWithoutCredentials(String username, String password){
        homePage.userLogIn(username,password);
    }

    @Test(enabled = true)
    public void validateUserCanSelectEmployersAndBrokersMenuFromNavigationMenuBar(){
        homePage.navigationBar();
    }

    @Test(enabled = true)
    public void validateUserCanSelectMedicareMenuFromNavigationBar(){homePage.medicareMenu();}

    @Test(enabled = true)
    public void validateUserCanSelectIndividualsAndFamiliesMenuFromNavigationBar(){homePage.individualsAndFamiliesMenu();}

    @Test(enabled = true)
    public void validateUserCanSelectHealthCareProvidersMenuFromNavigationBar(){homePage.healthCareProvidersMenu();}



}
