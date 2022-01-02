package org.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.practice.helpers.WebElementUtils;

import java.util.List;

public class ProductPage extends WebElementUtils {

    @FindBy (id = "send_friend_button")
            WebElement sendFriendBtn;
    @FindBy (name = "Submit")
            WebElement addToCartBtn;

    WebDriver driver;

    public ProductPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddToCartBtn(){
        return addToCartBtn;
    }

    private List<WebElement> getColorOptions(){

       List<WebElement> colorOptions = driver.findElements(By.xpath("//*[@id='color_to_pick_list']/li/a"));
       return colorOptions;
    }
    public void chooseColor(String color){
        List<WebElement> colorOptions = this.getColorOptions();
        for (int i = 1; i< colorOptions.size(); i++){
            String colors = colorOptions.get(i).getAttribute("name");
            if (colors.equalsIgnoreCase(color)){
                click(getColorOptions().get(i));
            }
        }
    }

    public Select chooseSize(String size){
        Select sizes = new Select(driver.findElement(By.id("group_1")));
        if(size.equalsIgnoreCase("s")){
            sizes.selectByVisibleText("S");
        }else if (size.equalsIgnoreCase("m")){
            sizes.selectByVisibleText("M");
        }else if (size.equalsIgnoreCase("l")){
            sizes.selectByVisibleText("L");
        }else{
            System.out.println("The size you've requested is not available. Please choose between option s,m, and l");
        }
        return sizes;
    }

    public void sendToAFriend(){
        click(sendFriendBtn);
    }

    public void addToCart(){
       addToCartBtn.click();
    }

}
