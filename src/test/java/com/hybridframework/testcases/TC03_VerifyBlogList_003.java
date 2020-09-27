package com.hybridframework.testcases;

import com.hybridframework.pageobjects.BlogListPage;
import com.hybridframework.pageobjects.LoginPage;
import org.testng.annotations.Test;

public class TC03_VerifyBlogList_003 extends Base{

    @Test
    public void verifyBlogList(){
        driver.get(baseURL);
        logger.debug("Opening the URL");
        LoginPage loginPage = new LoginPage(Base.driver);
        loginPage.setUserName(username);
        logger.debug("Typing the user name");
        loginPage.setTxtUserPassword(password);
        logger.debug("Typing the password");
        loginPage.clickOnSwithToLogin();
        loginPage.clickOnLogin();
        logger.debug("Clicking on Login");

        BlogListPage blogListPage = new BlogListPage(driver);
        if(blogListPage.visiblityOfMyBlogSection()){
            blogListPage.clickOnMyBlogSection();
        } else {
            logger.debug("Test case Failed");
        }
        if(blogListPage.visiblityOfMyBlogList()){
            blogListPage.clickOnBlogFromList();
        } else {
            logger.debug("Test case Failed");
        }
        blogListPage.blogDetailHeader();
    }
}
