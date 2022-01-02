package org.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.helpers.WebElementUtils;

import java.util.List;
import java.util.Random;

public class ProductComparisonPage extends WebElementUtils {

    @FindBy(xpath = "//div[contains(@id, 'center_column')]/h1")
    private WebElement pageName;
    @FindBy(xpath = "//*[@id='product_comparison']/tbody/tr[1]/td[2]/div[5]/div/div/a[1]")
    private WebElement addToCartProductOneBtn;
    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[1]/td[3]/div[5]/div/div/a[1]")
    private WebElement addToCartProductTwoBtn;

    public ProductComparisonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean pageIsComparison(String name) {
        Boolean userIsOnComparisonPage = false;
        if (tryAndCatchText(pageName).contains(name)) {
            userIsOnComparisonPage = true;
        }
        return userIsOnComparisonPage;
    }

    public void chooseProduct() {
        if (getRandomNumber() == 1) {
            click(addToCartProductOneBtn);
        } else {
            click(addToCartProductTwoBtn);
        }
    }


}
