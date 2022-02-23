package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.practice.helpers.WebElementUtils;

import java.util.List;

public class ProductPage extends WebElementUtils {

    @FindBy (id = "send_friend_button")
            WebElement sendToAFriendBtn;
    @FindBy (name = "Submit")
            WebElement addToCartBtn;
    @FindBy(id = "group_1")
            private WebElement sizeDropdown;
    @FindBy(xpath ="//ul[@id = 'color_to_pick_list']/li/a")
            private List<WebElement> colorOptions;

    WebDriver driver;

    public ProductPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void chooseColor(String option){
        for(WebElement options : colorOptions){
            if(options.getAttribute("name").equalsIgnoreCase(option)){
                click(options);
                break;
            }
        }
    }
    public void chooseSize(String size){
        Select sizes = new Select(sizeDropdown);
        if(size.equalsIgnoreCase("s")){
            sizes.selectByVisibleText("S");
        }else if(size.equalsIgnoreCase("m")){
            sizes.selectByVisibleText("M");
        }else if(size.equalsIgnoreCase("l")){
            sizes.selectByVisibleText("L");
        }else{
            System.out.println("The size you've requested is not available. Please choose between options s,m, and l");
        }
    }

    public void sendToAFriend(){
        click(sendToAFriendBtn);
    }

    public void addToCart(){
       addToCartBtn.click();
    }

}
