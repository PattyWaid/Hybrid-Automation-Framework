package com.hybridframework.testcases;

import com.hybridframework.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class Base {

    ReadConfig readConfig = new ReadConfig();
    public String baseURL= readConfig.readProperties("baseURL");
    public String username= readConfig.readProperties("username");
    public String password= readConfig.readProperties("password");
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br){
        logger = Logger.getLogger("devpinoyLogger");
        PropertyConfigurator.configure("log4j.properties");
        if(br.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ readConfig.readProperties("chromedriverpath"));
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ readConfig.readProperties("firefoxdriverpath"));
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        logger = Logger.getLogger("devpinoyLogger");
        PropertyConfigurator.configure("log4j.properties");
    }


    @AfterClass
    public void teardown(){
        driver.quit();
    }

    public void captureScreenshot(WebDriver driver, String testcasename) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/"+ testcasename + ".png");
        FileUtils.copyFile(source, target);
        logger.debug("Screenshot Captured");
    }
}
