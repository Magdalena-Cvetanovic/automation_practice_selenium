package org.practice;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasicTest {

    public WebDriver driver;
    public Properties properties;
    public SoftAssert sa;

    @BeforeClass
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "resources/browserdriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.properties = new Properties();
        properties.load(new FileInputStream("resources/site.properties"));
        driver.manage().window().maximize();
        driver.navigate().to(properties.getProperty("BASE_URL"));
        sa = new SoftAssert();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterClass
    public void afterClass() {
        this.driver.close();
    }

}
