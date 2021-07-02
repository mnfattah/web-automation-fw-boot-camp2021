package com.facebook.tests;

import com.facebook.pages.HomePage;
import com.pnt.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class FacebookTests extends TestBase {

    private static Logger LOGGER = Logger.getLogger(FacebookTests.class);
    private HomePage homePage;

    @BeforeMethod
    public void setUpPOM(){

        homePage = PageFactory.initElements(driver, HomePage.class);
    }

@Test(enabled = true)
    public void validateUserCanSignInToFacebook(){
        homePage.facebookLogin();
}

@Test(enabled = true)
    public void validateUserCanSearchForAName(){
        homePage.searchForAName();
}

@Test(enabled = true)
    public void validateUserCanPostAComment(){
        homePage.postAComment();
}

@Test(enabled = true)
    public void validateUserCanLikeAPost(){
        homePage.likeAPost();
}

@Test(enabled =true)
    public void validateUserCanSendFriendRequest(){
        homePage.sendAFriendRequest();
}

@Test(enabled = true)
    public void validateUserCanAcceptFriendRequest(){
        homePage.acceptFriendRequest();
}

@Test(enabled = true)
    public void validateUserCanUploadAPicture() throws AWTException {
        homePage.uploadAnImage();
}

}
