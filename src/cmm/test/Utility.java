package cmm.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;

/**
 * Created by Raghavendra.A on 19-06-2017.
 */
public class Utility {


    public static WebElement findElement(By locator) {
        WebElement element = null;
        for (int i = 0; i < Constants.findElementRetryCount; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Utility.findElement :: Finding Element " + locator.toString() + " Try " + i);
                element = DriverManager.driver.findElement(locator);
                return element;
            } catch (NoSuchElementException | StaleElementReferenceException | InterruptedException e) {
                System.out.println("Utility.findElement ::" + e.getMessage());
                System.out.println("Utility.findElement :: Element Not Found");
            }
        }
        return element;
    }

    public static Boolean isElementAccessible(By locator) {
        WebElement element = findElement(locator);
        if (element == null) {
            System.out.println("Utility.isElementAccessible :: Element Not Accessible ");
            return false;
        }
        for (int i = 0; i < Constants.findElementRetryCount; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Utility.isElementAccessible :: Accessing Element " + locator.toString() + " Try " + i);
                if (element.isDisplayed() && element.isEnabled()) {
                    System.out.println("Utility.isElementAccessible :: Element is Accessible");
                    return true;
                }
            } catch (NoSuchElementException | StaleElementReferenceException | InterruptedException e) {
                System.out.println("Utility.findElement ::" + e.getMessage());
                System.out.println("Utility.findElement :: Element Not Accessible");
            }
        }
        return false;
    }

    public static void typeText(By locator, String value) {
        try {
            WebElement textBox = findElement(locator);
            textBox.clear();
            textBox.sendKeys(value);
            System.out.println("Utility.typeText :: Successful");
        } catch (Exception e) {
            System.out.println("Utility.typeText :: Failed " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void click(By locator) {
        try {
            WebElement textBox = findElement(locator);
            textBox.click();
            System.out.println("Utility.click :: Successful");
        } catch (Exception e) {
            System.out.println("Utility.click :: Failed " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void doubleClick(By locator) {
        try {
            Actions act = new Actions(DriverManager.driver);
            WebElement element = findElement(locator);
            act.doubleClick(element).build().perform();
            System.out.println("Utility.DoubleClick :: Successful");
        } catch (Exception e) {
            System.out.println("Utility.DoubleClick :: Failed " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static Boolean CMM_Login(String userName, String password) {
        typeText(Constants.loginId_text, userName);
        typeText(Constants.loginPassword_text, password);
        click(Constants.LoginSubmit_button);
        //Todo : Verify Login was successfull and return boolean value depending on that
        if (DriverManager.driver.getTitle().contains(Constants.Successful_Login_Title)) {
            System.out.println("Utility.CMM_Login :: Login Successful ");
            return true;
        } else {
            System.out.println("Utility.CMM_Login :: Login Failed");
            return false;
        }
    }


    public static Boolean navigate_to_assets_category() {
        if (!isElementAccessible(Constants.metaDataMngmntSrvcFolder_link)) {
            doubleClick(Constants.leftMenuDAC_link);
        }
        doubleClick(Constants.metaDataMngmntSrvcFolder_link);
        click(Constants.expandIconMetaDataFolder);
        click(Constants.assetsCategory);
        if (isElementAccessible(Constants.contentAssetTab)) {
            System.out.println("Utility.navigate_to_assets_category :: Successful");
            return true;
        } else {
            System.out.println("Utility.navigate_to_assets_category :: Failed");
            return false;
        }
    }

    public static Boolean open_content_assets_tab() {
        click(Constants.contentAssetTab);
        if (isElementAccessible(Constants.assetId_text)) {
            System.out.println("Utility.open_content_assets_tab :: Successful");
            return true;
        } else {
            System.out.println("Utility.open_content_assets_tab :: Failed");
            return false;
        }
    }

    public static Boolean search_for_paid(String pkg_id) {
        navigate_to_assets_category();
        open_content_assets_tab();
        typeText(Constants.assetId_text,pkg_id);
        click(Constants.search_button);
        if (isElementAccessible(Constants.noResults)) {
            System.out.println("Utility.search_for_paid :: Search Failed - No Search results found for Package Id "+pkg_id);
            return false;
        }else{
            System.out.println("Utility.search_for_paid :: Search Successful for Package Id "+pkg_id);
            return true;
        }
    }

    public static void get_category_path_of_asset() {
        System.out.println("Utility.get_category_path_of_asset :: Todo");
    }
}
