package us.piit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SetUp {
    String browserName = "firefox";
    String url = "https://www.saucedemo.com/";
    WebDriver driver;

    @Before
    public void setUp(){
        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            System.out.println("chrome browser open success");
        }else if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            System.out.println("firefox browser open success");
        }else if (browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            System.out.println("edge browser open success");
        }
        //open the Chrome browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //navigate to login Page
        driver.get(url);
    }
    @After
    public void tearDown(){
        //close browser
        driver.close();
        System.out.println("browser close success");
    }
}
