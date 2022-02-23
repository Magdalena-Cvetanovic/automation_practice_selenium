package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.helpers.WebElementUtils;

public class HomePage extends WebElementUtils {
    @FindBy(id = "search_query_top")
    private WebElement searchBar;
    @FindBy(name = "submit_search")
    private WebElement searchBtn;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //what is this for???
    public String getSearchBarValue() {
        return searchBar.getCssValue("value");
    }

    public void search(String text) {
        sendKeys(searchBar, text);
        click(searchBtn);
    }


}
