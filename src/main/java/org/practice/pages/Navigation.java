package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.practice.helpers.WebElementUtils;

import java.util.List;

public class Navigation extends WebElementUtils {

    @FindBy(xpath = "//ul[contains(@class, 'clearfix menu-content')]/li/a")
    private List<WebElement> navigationLinks;

    public Navigation(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickNavLink(String linkName){
        for(WebElement navLink : navigationLinks){
            if (navLink.getText().equalsIgnoreCase(linkName)) {
                click(navLink);
                break;
            }
        }
    }

}
