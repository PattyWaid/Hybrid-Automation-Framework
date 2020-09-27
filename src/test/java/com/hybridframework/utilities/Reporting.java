package com.hybridframework.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Reporting extends TestListenerAdapter
{
    public ExtentReporter reporter;
    public ExtentReports extent;
    public ExtentTest logger;


    public void onStart(ITestContext testContext)
    {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
        String repName="Test-Report-"+timeStamp+".html";
        extent=new ExtentReports();
        reporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
        extent.attachReporter((ExtentObserver) reporter);
        extent.setSystemInfo("Host name","localhost");
        extent.setSystemInfo("Environemnt","QA");
        extent.setSystemInfo("user","Prathamesh Waidande");

    }

    public void onTestSuccess(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
    }

    public void onTestFailure(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted

        String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";

        File f = new File(screenshotPath);

        if(f.exists())
        {
            logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
        }

    }

    public void onTestSkipped(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext)
    {
        extent.flush();
    }
}
