package org.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasicTest {

    public WebDriver driver;
    public Properties properties;
    public SoftAssert sa;

    @BeforeClass
    @Parameters({"URL","BrowserType"})
    public void setup(String url, String browserType) throws IOException {
        if(browserType.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "resources/browserdriver/chromedriver");
            this.driver = new ChromeDriver();}
        else if(browserType.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", "resources/browserdriver/geckodriver");
            this.driver = new FirefoxDriver();
        }
        this.properties = new Properties();
        properties.load(new FileInputStream("resources/site.properties"));
        driver.manage().window().maximize();
        driver.navigate().to(url);
        sa = new SoftAssert();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void afterClass() {
        this.driver.quit();
    }

}
