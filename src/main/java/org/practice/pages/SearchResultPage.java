package org.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.helpers.WebElementUtils;

import java.util.List;


public class SearchResultPage extends WebElementUtils {

    @FindBy(linkText = "Faded Short Sleeve T-shirts")
    private WebElement searchResult;
    @FindBy(xpath = "//span[contains(@class,'lighter')]")
    private WebElement searchResultText;
    @FindBy(xpath = "//ul[contains(@class, 'product_list grid row')]/li)")
    private List<WebElement> searchResultList;
    @FindBy(xpath = "//a[contains(@class, 'add_to_compare')]")
    private WebElement addToCompareBtn;
    @FindBy(xpath = "//*//*[@id='center_column']/div[4]/div/form")
    private WebElement compareBtn;
    @FindBy(xpath = "//*[@id='center_column']/div[4]/div/form/button/span/strong")
    private WebElement numberOfItemsToCompare;


    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCompareBtn() {
        return compareBtn;
    }

    public void clickProduct() {
        click(searchResult);
    }

    public String getSearchResultText() {
        tryAndCatchText(searchResultText);
        return searchResultText.getText();
    }

    public List<WebElement> getSearchResultItems() {
        List<WebElement> searchResult = driver.findElements(By.xpath("//*[@class='product_list grid row']/li"));
        return searchResult;

    }

    public int getNoOfItemsToCompare() {
        String noOfItems = tryAndCatchText(numberOfItemsToCompare);
        int numberOfItems = Integer.parseInt(noOfItems);
        return numberOfItems;
    }

    public void clickAddToCompare(String text) throws InterruptedException {
        List<WebElement> products = getSearchResultItems();
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            Thread.sleep(1000);
            if (name.contains(text)) {
                WebElement product = products.get(i);
                moveToElement(product);
                WebElement addToCompare = products.get(i).findElement(By.xpath(".//div/div[3]/div[2]/a"));
                moveAndClick(addToCompare);
                scrollDownJsByLess();

            }
        }
    }

    public Boolean productsAdded() {
        Boolean added = false;
        if (getNoOfItemsToCompare() == 2) {
            added = true;
        }
        return added;
    }

    public void clickCompareBtn() {
        moveAndClick(getCompareBtn());
    }

}
