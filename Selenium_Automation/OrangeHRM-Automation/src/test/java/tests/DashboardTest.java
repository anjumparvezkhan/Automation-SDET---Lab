package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.Assert;

import base.TestListener;
import pages.DashboardPage;

@Listeners(TestListener.class)
public class DashboardTest {

    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void verifyDashboardElements() {
        try {
            WebDriver driver = TestListener.getDriver();
            TestListener.getTest().info("Initializing DashboardPage object");
            dashboardPage = new DashboardPage(driver);
            TestListener.getTest().pass("DashboardPage initialized successfully");
            
            // Verify User Dropdown Tab
            TestListener.getTest().info("Verifying User Dropdown Tab...");
            boolean isUserDropdownDisplayed = dashboardPage.isUserDropdownTabDisplayed();
            Assert.assertTrue(isUserDropdownDisplayed, "User Dropdown Tab is not displayed!");
            TestListener.getTest().pass("✓ User Dropdown Tab is displayed");
            
            // Verify Dashboard Loaded Successfully
            TestListener.getTest().info("Verifying Dashboard is loaded successfully...");
            boolean isDashboardLoaded = dashboardPage.isDashboardLoadedSuccessfully();
            Assert.assertTrue(isDashboardLoaded, "Dashboard is not loaded successfully!");
            TestListener.getTest().pass("✓ Dashboard loaded successfully");
            
            // Verify Profile Image
            TestListener.getTest().info("Verifying Profile Image is displayed...");
            boolean isProfileImageDisplayed = dashboardPage.isProfileImageDisplayed();
            Assert.assertTrue(isProfileImageDisplayed, "Profile Image is not displayed!");
            TestListener.getTest().pass("✓ Profile Image is displayed");
            
            // Verify Navigation Bar
            TestListener.getTest().info("Verifying Navigation Bar is displayed...");
            boolean isNavigationBarDisplayed = dashboardPage.isNavigationBarDisplayed();
            Assert.assertTrue(isNavigationBarDisplayed, "Navigation Bar is not displayed!");
            TestListener.getTest().pass("✓ Navigation Bar is displayed");

            // Verify Page Title
            TestListener.getTest().info("Verifying page title...");
            String Expected_HeaderText = dashboardPage.getPageHeaderText();
            Assert.assertNotNull(Expected_HeaderText, "Page header text is null!");
            Assert.assertEquals(Expected_HeaderText, "Dashboard", "Page header text does not match expected value!");
            TestListener.getTest().pass("✓ Page header text verified: " + Expected_HeaderText);
            
        } catch (AssertionError | Exception e) {
            TestListener.getTest().fail("Test failed with error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }    
}
