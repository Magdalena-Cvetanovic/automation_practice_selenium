package org.practice.helpers;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class WebElementUtils {

    public static WebDriverWait wait;
    public WebDriver driver;
    private Actions action;
    private JavascriptExecutor js;

    public WebElementUtils(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable((element)));
    }
    public void waitUntilElementAttributeChanges(WebElement element, String attribute, String value){
        wait.until(ExpectedConditions.attributeContains(element,attribute,value));
    }
    public void click(WebElement element){
        try{
            waitForElementToBeClickable(element);
            element.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void sendKeys(WebElement element, String text){
        waitForElementToBeClickable(element);
        element.clear();
        element.sendKeys(text);
    }
    public void scrollDownJsByMore()  {
        js.executeScript("window.scrollBy(0,1000)");
    }
    public void scrollDownJsByLess(){
        js.executeScript("window.scrollBy(0,500)");
    }
    public void scrollUpJs(){
        js.executeScript("javascript:window.scrollBy(0,-250)");
    }
    public void moveToElement(WebElement element){
        waitForElementToBeVisible(element);
        action.moveToElement(element).perform();
    }
    public void moveAndClick(WebElement element){
        action.moveToElement(element).click(element).build().perform();
    }
    public String tryAndCatchText(WebElement element) {
        String text = "";
        try {
            waitForElementToBeVisible(element);
            text = element.getText();
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return text;
    }
    public int getRandomNumber(){
        Random rand = new Random();
        int number = rand.nextInt(2)+1;
        return number;
    }

    public String emailGenerator(){
        String email = RandomStringUtils.randomAlphabetic(6).toLowerCase() + "@mailinator.com";
        return email;
    }
}
