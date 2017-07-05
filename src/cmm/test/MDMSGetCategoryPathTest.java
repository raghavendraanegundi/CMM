package cmm.test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

import java.util.HashMap;

/**
 * Created by 598470 on 6/21/2017.
 */
public class MDMSGetCategoryPathTest {



    HtmlUnitDriverExt localDriver=null;
    WebDriver driver=null;

    @BeforeTest
    public void setUp(){
//        localDriver=new HtmlUnitDriverExt(new BrowserVersion("Netscape", "5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.3029.110 Safari/537.36", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.3029.110 Safari/537.36", 52),true);
//        DriverManager.setDriver(localDriver);
//        driver=DriverManager.getDriver();
        DriverManager.createDriver();
        DriverManager.driver.get(Constants.MDMS_URL);
    }

    @Test
    public void _MDMSGetCategoryPathTest(){
   /* Utility.MDMS_Login(Constants.LoginIdMDMS,Constants.LoginPasswordMDMS);
    Utility.navigate_to_offer_management_MDMS();
    Utility.search_in_offer_management("INPK0517204000351861");
    Utility.get_category_path_MDMS();*/




                System.out.println("Searching Package ID "+Constants.current_mdms_package_id);
                Utility.MDMS_Login(Constants.LoginIdMDMS,Constants.LoginPasswordMDMS);
                Utility.navigate_to_offer_management_MDMS();
                Utility.search_in_offer_management(Constants.current_mdms_package_id);
                Utility.get_category_path_MDMS();



    }

    @AfterTest
    public void tearDown(){

        DriverManager.driver.quit();

    }
}
