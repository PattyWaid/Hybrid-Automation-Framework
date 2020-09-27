package com.hybridframework.testcases;

import com.hybridframework.pageobjects.LoginPage;
import com.hybridframework.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC02_LoginDataDriven_002 extends Base{

    @Test(dataProvider = "LoginData")
    public void LoginDataDrivenTest(String username, String password) throws InterruptedException {
        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
        loginPage.setTxtUserPassword(password);
        loginPage.clickOnSwithToLogin();
        loginPage.clickOnLogin();
        Thread.sleep(5000);
        if(loginPage.popUpInvalidButtonVisible()){
            loginPage.clickOnInvalidPasswordButton();
            Assert.assertTrue(true);
            logger.debug("Test case Passed");
        } else {
            Assert.assertTrue(false);
            logger.debug("Test case Failed");
        }
        Thread.sleep(2000);
    }

    @DataProvider(name="LoginData")
    public Object[][] getData() throws IOException {
        String loginData[][];
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\hybridframework\\testdata\\LoginData.xlsx";
        int row = XLUtils.getRowCount(path, "Sheet1");
        int col = XLUtils.getCellCount(path, "Sheet1", 1);
        loginData=new String[row][col];

        for(int i=1; i<= row; i++){
            for(int j=0; j< col; j++){
                loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return loginData;
    }
}
