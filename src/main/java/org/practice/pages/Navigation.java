package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.helpers.WebElementUtils;

public class Navigation extends WebElementUtils {

    @FindBy(linkText = "My Store")
    WebElement homePageLink;
    @FindBy(linkText = "Women")
    WebElement womenLink;
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    WebElement dressesLink;
    @FindBy(linkText = "T-shirts")
    WebElement tShirtsLink;

    public Navigation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomePage() {
        return homePageLink;
    }

    public WebElement getWomen() {
        return womenLink;
    }

    public WebElement getDresses() {
        return dressesLink;
    }

    public WebElement getTShirts() {
        return tShirtsLink;
    }

    public void clickDresses() {
        scrollUpJs();
        getDresses().click();
    }

}
