package com.cnn.tests;

import com.cnn.pages.HomePage;
import com.pnt.base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CnnTests extends TestBase {

    private HomePage homePage;

    @BeforeMethod
    public void setUpPOM(){
        homePage=PageFactory.initElements(driver,HomePage.class);
    }

@Test(enabled = true)
    public void validateUserCanLogInToCNN(){
        homePage.userLogIn();
}

@Test(enabled = true)
    public void validateUserCanClickOnTheNavigationBar(){
        homePage.navigationTab();
}

@Test(enabled = true)
    public void validateUserCanClickOnTheMenuBar(){
        homePage.menuBar();
}

@Test(enabled = true)
    public void validateUserCanSearchForANews(){
        homePage.searchForANews();
}

@Test(enabled = true)
    public void validateUserCanLogOutFromCNNWebsite(){
        homePage.userLogOut();
}

}
