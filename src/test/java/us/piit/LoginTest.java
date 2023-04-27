package us.piit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends SetUp{

    @Test
    public void validCredential() {
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
    }

    @Test
    public void invalidUsername(){
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        driver.findElement(By.id("user-name")).sendKeys("invalid_username");
        System.out.println("enter username success");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        System.out.println("enter password success");
        driver.findElement(By.id("login-button")).click();
        System.out.println("click on login button Success");

        //validate the error message
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")).getText();
        Assert.assertEquals(expectedError, actualError);
        System.out.println("validate error success");
    }

    @Test
    public void missingUsername(){
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        driver.findElement(By.id("user-name")).sendKeys("");
        System.out.println("enter username success");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        System.out.println("enter password success");
        driver.findElement(By.id("login-button")).click();
        System.out.println("click on login button Success");

        //validate the error message
        String expectedError = "Epic sadface: sername is required";
        String actualError = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")).getText();
        Assert.assertEquals(expectedError, actualError);
        System.out.println("validate error success");
    }
    @Test
    public void missingPassword(){
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        System.out.println("enter username success");
        driver.findElement(By.id("password")).sendKeys("");
        System.out.println("enter password success");
        driver.findElement(By.id("login-button")).click();
        System.out.println("click on login button Success");

        //validate the error message
        String expectedError = "Epic sadface: Password is required";
        String actualError = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")).getText();
        Assert.assertEquals(expectedError, actualError);
        System.out.println("validate error success");
    }
}
