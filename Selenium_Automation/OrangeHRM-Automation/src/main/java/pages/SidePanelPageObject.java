package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SidePanelPageObject {

    WebDriver driver;
    WebDriverWait wait;

    // Side Panel WebElements
    @FindBy(xpath = "//aside[@class='oxd-sidebar']")
    private WebElement sidePanel;
    
    @FindBy(xpath = "//nav[@class='oxd-navbar']//button[@type='button']")
    private WebElement toggleSidePanel;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item']")
    private List<WebElement> menuItems;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(text(), 'Admin')]")
    private WebElement adminMenu;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(text(), 'PIM')]")
    private WebElement pimMenu;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(text(), 'Leave')]")
    private WebElement leaveMenu;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(text(), 'Time')]")
    private WebElement timeMenu;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(text(), 'Recruitment')]")
    private WebElement recruitmentMenu;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(text(), 'My Info')]")
    private WebElement myInfoMenu;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(text(), 'Performance')]")
    private WebElement performanceMenu;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(text(), 'Directory')]")
    private WebElement directoryMenu;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(text(), 'Maintenance')]")
    private WebElement maintenanceMenu;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(text(), 'Claim')]")
    private WebElement claimMenu;
    
    @FindBy(xpath = "//div[@class='oxd-sidebar-body']")
    private WebElement sidePanelBody;
    
    @FindBy(xpath = "//div[@class='oxd-sidebar-header']")
    private WebElement sidePanelHeader;
    
    @FindBy(xpath = "//div[@class='oxd-text oxd-text--h6']")
    private WebElement sidePanelTitle;
    
    @FindBy(xpath = "//ul[@class='oxd-main-menu']")
    private WebElement mainMenu;
    
    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']")
    private List<WebElement> menuItemWrappers;

    public SidePanelPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private WebElement findElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Side Panel Methods

    public boolean isSidePanelDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(sidePanel)).isDisplayed();
        } catch (NoSuchElementException e) {
            System.err.println("Side panel not found: " + e.getMessage());
            return false;
        }
    }

    public void toggleSidePanelVisibility() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(toggleSidePanel)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Toggle side panel button not found: " + e.getMessage());
        }
    }

    public void clickAdminMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Admin menu not found: " + e.getMessage());
        }
    }

    public void clickPIMMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
        } catch (NoSuchElementException e) {
            System.err.println("PIM menu not found: " + e.getMessage());
        }
    }

    public void clickLeaveMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(leaveMenu)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Leave menu not found: " + e.getMessage());
        }
    }

    public void clickTimeMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(timeMenu)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Time menu not found: " + e.getMessage());
        }
    }

    public void clickRecruitmentMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(recruitmentMenu)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Recruitment menu not found: " + e.getMessage());
        }
    }

    public void clickMyInfoMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(myInfoMenu)).click();
        } catch (NoSuchElementException e) {
            System.err.println("My Info menu not found: " + e.getMessage());
        }
    }

    public void clickPerformanceMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(performanceMenu)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Performance menu not found: " + e.getMessage());
        }
    }

    public void clickDirectoryMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(directoryMenu)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Directory menu not found: " + e.getMessage());
        }
    }

    public void clickMaintenanceMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(maintenanceMenu)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Maintenance menu not found: " + e.getMessage());
        }
    }

    public void clickClaimMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(claimMenu)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Claim menu not found: " + e.getMessage());
        }
    }

    public int getMenuItemsCount() {
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElements(menuItems)).size();
        } catch (NoSuchElementException e) {
            System.err.println("Menu items not found: " + e.getMessage());
            return 0;
        }
    }

    public List<WebElement> getAllMenuItems() {
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElements(menuItems));
        } catch (NoSuchElementException e) {
            System.err.println("Menu items not found: " + e.getMessage());
            return null;
        }
    }

    public void clickMenuItemByIndex(int index) {
        try {
            List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElements(menuItems));
            if (index < items.size()) {
                wait.until(ExpectedConditions.elementToBeClickable(items.get(index))).click();
            } else {
                System.err.println("Menu item index out of bounds: " + index);
            }
        } catch (NoSuchElementException e) {
            System.err.println("Menu items not found: " + e.getMessage());
        }
    }

    public void clickMenuItemByText(String menuText) {
        try {
            By menuLocator = By.xpath("//a[@class='oxd-main-menu-item' and contains(text(), '" + menuText + "')]");
            findElement(menuLocator).click();
        } catch (NoSuchElementException e) {
            System.err.println("Menu item with text '" + menuText + "' not found: " + e.getMessage());
        }
    }

    public boolean isMenuItemPresent(String menuText) {
        try {
            By menuLocator = By.xpath("//a[@class='oxd-main-menu-item' and contains(text(), '" + menuText + "')]");
            return wait.until(ExpectedConditions.presenceOfElementLocated(menuLocator)) != null;
        } catch (NoSuchElementException e) {
            System.err.println("Menu item with text '" + menuText + "' not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isSidePanelHeaderDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(sidePanelHeader)).isDisplayed();
        } catch (NoSuchElementException e) {
            System.err.println("Side panel header not found: " + e.getMessage());
            return false;
        }
    }

    public String getSidePanelTitleText() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(sidePanelTitle)).getText();
        } catch (NoSuchElementException e) {
            System.err.println("Side panel title not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isSidePanelBodyDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(sidePanelBody)).isDisplayed();
        } catch (NoSuchElementException e) {
            System.err.println("Side panel body not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isMainMenuDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(mainMenu)).isDisplayed();
        } catch (NoSuchElementException e) {
            System.err.println("Main menu not found: " + e.getMessage());
            return false;
        }
    }

    public int getMenuItemWrappersCount() {
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElements(menuItemWrappers)).size();
        } catch (NoSuchElementException e) {
            System.err.println("Menu item wrappers not found: " + e.getMessage());
            return 0;
        }
    }

    public boolean verifySidePanelFullyLoaded() {
        try {
            return isSidePanelDisplayed() && isSidePanelHeaderDisplayed() && 
                   isSidePanelBodyDisplayed() && isMainMenuDisplayed();
        } catch (Exception e) {
            System.err.println("Error verifying side panel fully loaded: " + e.getMessage());
            return false;
        }
    }
}
