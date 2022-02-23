package org.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.practice.helpers.WebElementUtils;

import java.util.List;


public class ProductComparisonPage extends WebElementUtils {

    @FindBy(xpath = "//div[contains(@id, 'center_column')]/h1")
    private WebElement pageName;
    @FindBy(xpath = "//td[contains(@class, 'ajax_block_product')]")
    private List<WebElement> listOfProductsToCompare;
    private String discount = "./div[@class = 'prices-container']/span[@class = 'price-percent-reduction']";
    private String addToCartBtn ="./div[@class='comparison_product_infos']/div/div/a";

    public ProductComparisonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Boolean pageIsComparison(String name) {
        Boolean userIsOnComparisonPage = false;
        if (tryAndCatchText(pageName).contains(name)) {
            userIsOnComparisonPage = true;
        }
        return userIsOnComparisonPage;
    }

    public void chooseProductWithDiscountOf20Percent(){
        for (WebElement product : listOfProductsToCompare){
            if(product.findElement(By.xpath(discount)).getText().contains("20")){
                click(product.findElement(By.xpath(addToCartBtn)));
            }
        }
    }


}
