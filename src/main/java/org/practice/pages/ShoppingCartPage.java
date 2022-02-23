package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.helpers.WebElementUtils;

public class ShoppingCartPage extends WebElementUtils {

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckOutBtn;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickProceedToCheckout() {
        click(proceedToCheckOutBtn);
    }

}

