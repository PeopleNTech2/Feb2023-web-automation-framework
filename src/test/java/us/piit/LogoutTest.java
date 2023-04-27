package us.piit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogoutTest extends SetUp{

    @Test
    public void logout() throws InterruptedException {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        System.out.println("enter username success");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        System.out.println("enter password success");
        driver.findElement(By.id("login-button")).click();
        System.out.println("click on login button Success");

        //check user is logged in
        String expectedHomePageHeader = "Products";
        String actualHomePageHeader = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        System.out.println("user logged in success");

        //click on hamburger menu
        driver.findElement(By.id("react-burger-menu-btn")).click();
        System.out.println("click on hamburger menu success");
        Thread.sleep(1000);

        //hover hover & click on logout link
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("logout_sidebar_link"))).click().build().perform();
        System.out.println("click on logout link success");

        //check user is landed to the login page
        WebElement loginPageHeader =  driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
        boolean loginPageHeaderIsDisplayed = loginPageHeader.isDisplayed();
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        System.out.println("login page header is displayed");
        String expectedLoginPageHeaderText = "Swag Labs";
        String actualLoginPageHeaderText = loginPageHeader.getText();
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        System.out.println("login page header text validation success");
    }

}
