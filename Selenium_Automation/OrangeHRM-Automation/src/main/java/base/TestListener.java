package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import driver.DriverFactory;
import utils.ConfigReader;
import utils.ExtentManager;

public class TestListener implements ITestListener {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();
    private static ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Initialize WebDriver
        WebDriver driver = DriverFactory.initDriver();
        driver.get(ConfigReader.get("url"));
        driverThreadLocal.set(driver);

        // Create test report
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThreadLocal.set(test);
        
        test.info("Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().pass("✓ Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getTest().fail("✗ Test Failed: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().skip("⊘ Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Quit driver
        if (driverThreadLocal.get() != null) {
            DriverFactory.quitDriver();
            driverThreadLocal.remove();
        }
        testThreadLocal.remove();

        // Flush report
        extent.flush();
    }

    // Static methods to access driver and test
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static ExtentTest getTest() {
        return testThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            DriverFactory.quitDriver();
            driverThreadLocal.remove();
        }
    }
}