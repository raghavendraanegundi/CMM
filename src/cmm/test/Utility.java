package cmm.test;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by Raghavendra.A on 19-06-2017.
 */
public class Utility {

    public static ArrayList<HashMap<String, String>> hashData = null;

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

    public static Boolean select_by_visbleText(By locator, String value) {
        try {
            click(locator);
            Select dropDownList = new Select(findElement(locator));
            System.out.println("Options :: " + dropDownList.getOptions());
            dropDownList.selectByVisibleText(value);
            if (dropDownList.getFirstSelectedOption().getText().equalsIgnoreCase(value)) {
                System.out.println("Utility.select_by_visbleText :: Successful");
                return true;
            } else {
                System.out.println("Utility.select_by_visbleText :: Failed");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static Boolean CMM_Login(String userName, String password) {
        typeText(Constants.CMM_loginId_text, userName);
        typeText(Constants.CMM_loginPassword_text, password);
        click(Constants.CMM_LoginSubmit_button);
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

    public static Boolean open_content_packages_tab() {
        click(Constants.contentPackageTab);
        if (isElementAccessible(Constants.assetId_text_content_package)) {
            System.out.println("Utility.open_content_assets_tab :: Successful");
            return true;
        } else {
            System.out.println("Utility.open_content_assets_tab :: Failed");
            return false;
        }
    }

    public static Boolean CMM_search_for_paid_in_content_pkg(String pkg_id) {
        try {
            open_content_packages_tab();
            typeText(Constants.assetId_text_content_package, pkg_id);
            click(Constants.search_button);
            if (isElementAccessible(Constants.noResults)) {
                System.out.println("Utility.search_for_paid :: Search Failed - No Search results found for Package Id " + pkg_id);
                return false;
            } else {
                System.out.println("Utility.search_for_paid :: Search Successful for Package Id " + pkg_id);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean search_for_paid(String pkg_id) {
        try {
            open_content_assets_tab();
            typeText(Constants.assetId_text, pkg_id);
            click(Constants.search_button);
            if (isElementAccessible(Constants.noResults)) {
                System.out.println("Utility.search_for_paid :: Search Failed - No Search results found for Package Id " + pkg_id);
                return false;
            } else {
                System.out.println("Utility.search_for_paid :: Search Successful for Package Id " + pkg_id);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void search_all_package_id_in_CMM() {
        for (HashMap<String, String> eachRow : hashData) {
            String headEnd = null;
            String package_id = null;
            String title = null;

            if ((eachRow.get("TargetHeadend").toString()).contains("a6h1")) {
                headEnd = "a6h1";
                String title_brief = eachRow.get("Title_Brief").toString();
                String provider = eachRow.get("Provider").toString();
                package_id = eachRow.get("Package_ID").toString();
                String cpid = eachRow.get("cPID").toString();
                String runtime = eachRow.get("RunTime").toString();
                String rating = eachRow.get("Rating").toString();
                String price = eachRow.get("Price").toString();
                String trick = eachRow.get("Trick").toString();
                String licensestart = eachRow.get("LicenseStart").toString();
                String licenseend = eachRow.get("LicenseEnd").toString();
                String genre = eachRow.get("Genre").toString();
                String category = eachRow.get("Category").toString();
                title = eachRow.get("Title").toString();
                String episodename = eachRow.get("EpisodeName").toString();
                String episodenum = eachRow.get("EpisodeNum").toString();
                String targetheadend = "a6h1";
                String csv_content = title_brief + "|" + provider + "|" + package_id + "|" + cpid + "|" + runtime + "|" + rating + "|" + price + "|" + trick + "|" + licensestart + "|" + licenseend + "|" + genre + "|" + category + "|" + title + "|" + episodename + "|" + episodenum + "|" + targetheadend;
                System.out.println("****************After Search  Before  Write");
                String cmm_category_path = "Not Found";
                /*/*if (search_for_paid(package_id)) {
                    cmm_category_path = get_category_path_of_asset();
                } else {
                    cmm_category_path = "Not Found";
                *//*}*/
                if (CMM_search_for_paid_in_content_pkg(package_id)) {
                    cmm_category_path = get_category_path_of_asset();
                } else {
                    cmm_category_path = "Not Found";
                }
                csv_content = csv_content + "|" + cmm_category_path;
                System.out.println(cmm_category_path);
                write_to_file("CMM_SEARCH_OUTPUT.csv", csv_content);
            }
        }
    }

    public static void read_excel() {
        hashData = ExcelUtil.getMapOfRows();
    }


    public static String get_category_path_of_asset() {
       try {
           System.out.println("Utility.get_category_path_of_asset :: Todo");

           String fileLocation = "Not Found";
           if (isElementAccessible(Constants.noResults)) {
               System.out.println("Utility.get_category_path_of_asset :: Search Failed - No Search results found for Package Id ");
               return fileLocation;
           } else {
               click(Constants.expandAssetButton);
               fileLocation = findElement(Constants.categoryPath).getText();
               return fileLocation;
           }
       }catch(Exception e){
           e.printStackTrace();
           return "Not Found";
       }
    }

    public static Boolean MDMS_Login(String loginIdMDMS, String loginPasswordMDMS) {
        try {
            WebElement element = findElement(Constants.MDMS_LoginSubmit_Button);
            typeText(Constants.MDMS_LoginId_Text, loginIdMDMS);
            typeText(Constants.MDMS_LoginPassword_Text, loginPasswordMDMS);
            Actions act = new Actions(DriverManager.driver);
            act.moveToElement(element).click(element).build().perform();
            if (isElementAccessible(Constants.MDMS_LoginSuccess_Message)) {
                System.out.println("Utility.MDMS_Login :: Login Successful ");
                return true;
            } else {
                System.out.println("Utility.MDMS_Login :: Login Failed ");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Utility.MDMS_Login :: Login Failed with exception " + e.getMessage());
            return false;
        }
    }

    public static Boolean navigate_to_offer_management_MDMS() {
        click(Constants.MDMS_ModulesMenu_Link);
        click(Constants.MDMS_OfferManagement_Link);
        DriverManager.driver.navigate().to("http://172.30.83.16:8300/catalogs/master/offers");
        System.out.println(findElement(new By.ByXPath("//div[@class='heading']//h1")).getText());
        if (DriverManager.driver.getCurrentUrl().contains("offers")) {
            System.out.println("Utility.navigate_to_offer_management_MDMS :: Successfully navigated to offer Management");
            return true;
        } else {
            System.out.println("Utility.navigate_to_offer_management_MDMS :: Failed to Navigate to offer management");
            System.out.println("Utility.navigate_to_offer_management_MDMS :: current url is " + DriverManager.driver.getCurrentUrl());
            return false;
        }
    }

    public static void search_in_offer_management(String package_id) {
        try {
            if (!findElement(Constants.MDMS_SearchOptionExpand_Indicator).getAttribute("class").contains("open")) {
                click(Constants.MDMS_ExpandSearchControl);
            }
            select_by_visbleText(Constants.MDMS_OfferSearchCriteria_Select, "URI");
            select_by_visbleText(Constants.MDMS_OfferSearchOperator_Select, "contains");
            typeText(Constants.MDMS_OfferSearchValue_Text, package_id);
            isElementAccessible(Constants.MDMS_OfferSearchResultList);
            System.out.println(findElement(Constants.MDMS_OfferSearchResultList).getAttribute("innerHTML"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(DriverManager.driver.getPageSource());
        }
    }

    public static void get_category_path_MDMS() {
        try {
            click(new By.ByXPath("//table[@id='offers_table']/tbody/tr[1]/td[@class='name']/a"));
            if (isElementAccessible(new By.ByXPath("//table[@id='categories']/tbody/tr[1]/td[1]/a"))) {
                click(new By.ByXPath("//table[@id='categories']/tbody/tr[1]/td[1]/a"));
            }
            System.out.println(findElement(new By.ByXPath("(//dl[@class='attribute-list']/dt[text()='URI ID']/following-sibling::dd)[1]")).getText());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(DriverManager.driver.getPageSource());
        }
    }


    public static void write_to_file(String fileName, String content) {
        try {
            URL root_location = CMMGetCategoryPathTest.class.getProtectionDomain().getCodeSource().getLocation();
            String file_path = root_location.getPath().replace("CMM.jar", fileName);
//    file_path="C:\\Users\\598470\\Desktop\\VOD_VBO_SELENIUM\\CMM\\src\\cmm\\test\\"+fileName;
            FileWriter fout = new FileWriter(file_path, true);
            fout.append(content + "##" + "\n");
            fout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
