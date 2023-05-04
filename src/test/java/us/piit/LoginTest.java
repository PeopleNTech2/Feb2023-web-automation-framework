package us.piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends SetUp{
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void validCredential() {
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
    }

    @Test
    public void invalidUsername(){
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("#user-name","invalid_username");
        log.info("enter username success");
        type("#password","secret_sauce");
        log.info("enter password success");
        clickOn("#login-button");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = getElementText("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }

    @Test
    public void missingUsername(){
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("#user-name","");
        log.info("enter username success");
        type("#password","secret_sauce");
        log.info("enter password success");
        clickOn("#login-button");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Epic sadface: sername is required";
        String actualError = getElementText("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }
    @Test
    public void missingPassword(){
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("#user-name","standard_user");
        log.info("enter username success");
        type("#password","");
        log.info("enter password success");
        clickOn("#login-button");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Epic sadface: Password is required";
        String actualError = getElementText("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }
}
