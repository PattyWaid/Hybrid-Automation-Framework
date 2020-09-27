package com.hybridframework.testcases;

import com.hybridframework.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC01_LoginPage_001 extends Base{

    LoginPage loginPage;

    @Test
    public void loginTest() throws InterruptedException, IOException {
        driver.get(baseURL);
        logger.debug("Opening the URL");
        Thread.sleep(5000);
        loginPage = new LoginPage(Base.driver);
        loginPage.setUserName(username);
        logger.debug("Typing the user name");
        loginPage.setTxtUserPassword(password);
        logger.debug("Typing the password");
        loginPage.clickOnSwithToLogin();
        loginPage.clickOnLogin();
        logger.debug("Clicking on Login");

        if(driver.getTitle().equals("World Of Blogs")){
            Assert.assertTrue(true);
            logger.debug("Test case passed");
        } else {
            captureScreenshot(driver, this.getClass().getName());
            Assert.assertTrue(false);
            logger.debug("Test case failed");
        }
    }
}
