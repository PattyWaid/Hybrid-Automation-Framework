package com.hybridframework.pageobjects;

import com.hybridframework.testcases.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        System.out.println(driver);
        PageFactory.initElements(driver, this);
        System.out.println(driver);
    }

    @FindBy(id="email")
    WebElement txtUserName;

    @FindBy(id="password")
    WebElement txtUserPassword;

    @FindBy(xpath="/html/body/app-root/div/div/div/app-auth/div/div/form/div[3]/button[2]")
    WebElement btnSwithToLogin;

    @FindBy(xpath="/html/body/app-root/div/div/div/app-auth/div/div/form/div[3]/button[1]")
    WebElement btnUserLogin;

    @FindBy(xpath="/html/body/app-root/div/div/div/app-auth/app-alert/div/div/div/button")
    WebElement popUpInvalidPasswordbuttonVisible;

    @FindBy(xpath="/html/body/app-root/div/div/div/app-auth/app-alert/div/div/div/button")
    WebElement popUpInvalidPasswordbutton;

    public void setUserName(String userEmail){
        txtUserName.sendKeys(userEmail);
    }

    public void setTxtUserPassword(String userPassword){
        txtUserPassword.sendKeys(userPassword);
    }

    public void clickOnSwithToLogin(){
        btnSwithToLogin.click();
    }

    public void clickOnLogin(){
        btnUserLogin.click();
    }

    public void clickOnInvalidPasswordButton(){
        popUpInvalidPasswordbutton.click();
    }

    public boolean popUpInvalidButtonVisible(){
        if(popUpInvalidPasswordbuttonVisible.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }

}
