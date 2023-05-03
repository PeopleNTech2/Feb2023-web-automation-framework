package us.piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogoutTest extends SetUp{
    Logger log = LogManager.getLogger(LogoutTest.class.getName());

    @Test
    public void logout() throws InterruptedException {
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("#user-name","standard_user");
        log.info("enter username success");
        type("#password","secret_sauce");
        log.info("enter password success");
        clickOn("#login-button");
        log.info("click on login button Success");

        //check user is logged in
        String expectedHomePageHeader = "Products";
        String actualHomePageHeader = getElementText("//span[contains(text(),'Products')]");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");

        //click on hamburger menu
        clickOn("#react-burger-menu-btn");
        log.info("click on hamburger menu success");
        Thread.sleep(1000);

        //hover hover & click on logout link
        hoverOver("#logout_sidebar_link");
        log.info("click on logout link success");

        //check user is landed to the login page
        boolean loginPageHeaderIsDisplayed = isVisible("//div[contains(text(),'Swag Labs')]");
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        log.info("login page header is displayed");
        String expectedLoginPageHeaderText = "Swag Labs";
        String actualLoginPageHeaderText = getElementText("//div[contains(text(),'Swag Labs')]");
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");
    }

}
