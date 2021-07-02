package com.facebook.pages;

import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class HomePage {

    private static Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(id = "email")
    private WebElement clickOnTheUserIDField;

    @FindBy(id = "pass")
    private WebElement clickOnThePasswordField;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement clickOnTheLogInButton;

    @FindBy(xpath = "//input[@name='global_typeahead']")
    private WebElement clickOnTheSearchButton;

    @FindBy(xpath = "(//span[@class='nc684nl6'])[1]")
    private WebElement clickOnTheSelectedName;

    @FindBy(xpath = "//a[@aria-label='Home']")
    private WebElement clickOnTheHomeButton;

    @FindBy(xpath = "(//*[@id='mount_0_0_IX']/div/div[1]//p)[1]")
    private WebElement clickOnTheCommentBox;

    @FindBy(xpath = "(//span[contains(text(),'Find Friends')])[1]")
    private WebElement clickOnFindFriends;

    @FindBy(xpath = "//*[contains(text(),'Photo/Video')]")
    private WebElement clickOnThePhotoOrVideo;

    @FindBy(xpath = "//div[@class='k4urcfbm dati1w0a hv4rvrfc i1fnvgqd j83agx80 rq0escxv bp9cbjyn discj3wi']")
    private WebElement clickOnThePostButton;

    @FindBy(xpath = "//span[contains(text(), 'TestFirst TestSecond')]")
    private WebElement clickOnTheUserName;

    @FindBy(xpath = "//span[contains(text(), 'All Friends')]")
    private WebElement clickOnAllFriends;


    public void facebookLogin() {
        clickOnTheUserIDField.sendKeys("mnfattah_j@yahoo.com");
        clickOnThePasswordField.sendKeys("Afifa21lina");
        clickOnTheLogInButton.click();
        TestBase.sleepFor(5);
        String text = TestBase.driver.findElement(By.xpath("//span[contains(text(), 'TestFirst TestSecond')]")).getText();
        Assert.assertTrue(text.contains("TestFirst"), "You are not logged in");
        ExtentTestManager.log(text + " logged in", LOGGER);
    }

    public void searchForAName() {
        clickOnTheUserIDField.sendKeys("mnfattah_j@yahoo.com");
        clickOnThePasswordField.sendKeys("Afifa21lina");
        clickOnTheLogInButton.click();
        TestBase.sleepFor(2);
        clickOnTheSearchButton.sendKeys("helena begum");
        WebDriverWait wait = new WebDriverWait(TestBase.driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='helena begum']")));
        element.click();
        TestBase.sleepFor(2);
        clickOnTheSelectedName.click();
        String text = TestBase.driver.findElement(By.xpath("//h1[contains(text(),'Helena')]")).getText();
        Assert.assertTrue(text.contains(" "), "The page for Helena Begum is not displayed");
        ExtentTestManager.log(text + " page has been displayed", LOGGER);
    }

    public void postAComment() {
        clickOnTheUserIDField.sendKeys("mnfattah_j@yahoo.com");
        clickOnThePasswordField.sendKeys("Afifa21lina");
        clickOnTheLogInButton.click();
        TestBase.sleepFor(2);
        clickOnTheUserName.click();
        TestBase.sleepFor(2);
        List<WebElement> list = TestBase.driver.findElements(By.xpath("(//div[@aria-label='Write a comment'])"));
        for (int i = 0; i < list.size(); i++) {
            list.get(0).sendKeys("Nice!");
            TestBase.sleepFor(2);
            list.get(0).sendKeys(Keys.ENTER);
            break;

        }
        TestBase.sleepFor(2);
        String text = TestBase.driver.findElement(By.xpath("//div[@class='ecm0bbzt e5nlhep0 a8c37x1j']")).getText();
        Assert.assertTrue(text.contains("!"), "The comment is not displayed");
        ExtentTestManager.log(text + " comment has been posted", LOGGER);
    }

    public void likeAPost() {
        clickOnTheUserIDField.sendKeys("mnfattah_j@yahoo.com");
        clickOnThePasswordField.sendKeys("Afifa21lina");
        clickOnTheLogInButton.click();
        TestBase.sleepFor(2);
        clickOnTheUserName.click();
        List<WebElement> list = TestBase.driver.findElements(By.xpath("//span[contains(text(),'Like')]"));    //"(//div[@aria-label='Like'])"));
        for (int i = 0; i < list.size(); i++) {
            list.get(0).click();

        }
        TestBase.sleepFor(2);
        String text = TestBase.driver.findElement(By.xpath("(//span[@class='pcp91wgn'])[1]")).getText();
        Assert.assertTrue(text.contains(" "), "You did not like any post");
        ExtentTestManager.log(text + " like a post", LOGGER);
    }

    public void sendAFriendRequest() {
        clickOnTheUserIDField.sendKeys("mnfattah_j@yahoo.com");
        clickOnThePasswordField.sendKeys("Afifa21lina");
        clickOnTheLogInButton.click();
        TestBase.sleepFor(2);
        clickOnFindFriends.click();
        try {
            TestBase.driver.findElement(By.xpath("(//*[contains(text(),'Add Friend')])[1]")).click();
        } catch (Exception e) {
        }
        ExtentTestManager.log( "friend request has been sent", LOGGER);
    }

    public void acceptFriendRequest() {
        clickOnTheUserIDField.sendKeys("mnfattah_j@yahoo.com");
        clickOnThePasswordField.sendKeys("Afifa21lina");
        clickOnTheLogInButton.click();
        TestBase.sleepFor(2);
        clickOnFindFriends.click();
        try {
            TestBase.driver.findElement(By.xpath("(//*[contains(text(),'Confirm')])[1]")).click();
        } catch (Exception e) {
        }
        ExtentTestManager.log( "One friend request has been accepted", LOGGER);
    }

    public void uploadAnImage() throws AWTException {
        clickOnTheUserIDField.sendKeys("mnfattah_j@yahoo.com");
        clickOnThePasswordField.sendKeys("Afifa21lina");
        clickOnTheLogInButton.click();
        TestBase.sleepFor(2);
        clickOnTheHomeButton.click();
        TestBase.sleepFor(5);
        clickOnThePhotoOrVideo.click();

        /*   The below code was copied from https://www.softwaretestinghelp.com/file-upload-in-selenium/ */

        // creating object of Robot class
        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection("C:\\Users\\mdnfa\\IdeaProjects\\WebAutomationFWBootCamp2021\\facebook\\src\\test\\resources\\SeleniumTest.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        rb.setAutoDelay(1000);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);


        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.setAutoDelay(1000);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
       // clickOnThePhotoOrVideo.sendKeys("C:\\Users\\mdnfa\\Desktop\\SeleniumTest.jpg");
        clickOnThePostButton.click();
        ExtentTestManager.log("One picture has been uploaded", LOGGER);
    }
}