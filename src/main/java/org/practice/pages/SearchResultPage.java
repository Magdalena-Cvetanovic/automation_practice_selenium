package org.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.helpers.WebElementUtils;

import java.util.List;


public class SearchResultPage extends WebElementUtils {

    @FindBy(xpath = "//form[@class = 'compare-form']")
    private WebElement compareBtn;
    @FindBy(xpath = "//input[@class ='compare_product_count']")
    private WebElement numberOfAddedToCompare;
    @FindBy(linkText = "Add to Compare")
    private WebElement addToCompareBtn;
    @FindBy(xpath = "//ul[@class = 'product_list grid row']/li")
    @CacheLookup
    private List<WebElement> searchResults;
    private String discountedProducts = "./div/div/div/span[@class ='price-percent-reduction']";
    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void viewProduct(){
        click(searchResults.get(0));
    }

    public void findProductWithDiscount(){
        for (WebElement discounted : searchResults){
            try {
                discounted.findElement(By.xpath(discountedProducts));
                moveToElement(discounted);
                click(addToCompareBtn);
                scrollDownJsByLess();
            }catch (Exception e){
            }
    }}
    public int getNoOfItemsToCompare() {
        String noOfItems = numberOfAddedToCompare.getAttribute("value");
        int numberOfItems = Integer.parseInt(noOfItems);
        return numberOfItems;
    }
    public Boolean twoProductsAdded() {
        Boolean added = false;
        waitUntilElementAttributeChanges(numberOfAddedToCompare,"value", "2");
        if (getNoOfItemsToCompare() == 2) {
            added = true;
        }else{
            System.out.println("The compare section does not contain 2 products.");
        }
        return added;
    }

    public void clickCompareBtn() {
        click(compareBtn);
    }

}
