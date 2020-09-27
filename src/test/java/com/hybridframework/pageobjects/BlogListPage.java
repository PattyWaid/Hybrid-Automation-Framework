package com.hybridframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BlogListPage {

    WebDriver driver;

    public BlogListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-header/nav/div/div[2]/ul[2]/li[1]/a")
    @CacheLookup
    WebElement myBolgSection;

    @FindBy(how = How.XPATH, using = "//app-recipe-item[1]/a")
    @CacheLookup
    WebElement blogList;

    @FindBy(how = How.XPATH, using = "//app-recipe-item[1]/a")
    @CacheLookup
    WebElement blogItem;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/div/app-recipes/div/div[2]/app-recipe-detail/div[2]/div/h1")
    @CacheLookup
    WebElement blogDetailHeader;

    public boolean visiblityOfMyBlogSection(){
        if(myBolgSection.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }

    public void clickOnMyBlogSection(){
        myBolgSection.click();
    }

    public boolean visiblityOfMyBlogList(){
        if(blogList.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }

    public void clickOnBlogFromList(){
        blogItem.click();
    }

    public void blogDetailHeader(){
        blogDetailHeader.equals("Automobile Article");
    }

}
