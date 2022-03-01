package org.practice;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.io.File;
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

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void afterClass() {
        this.driver.quit();
    }

}
