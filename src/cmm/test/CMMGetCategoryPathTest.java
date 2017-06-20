package cmm.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;

/**
 * Created by Raghavendra.A on 19-06-2017.
 */
public class CMMGetCategoryPathTest {

    WebDriver driver=null;

    @BeforeTest
    public void setUp(){
        driver= DriverManager.getDriver();
        driver.get(Constants.CMMURL);
    }

    @Test
    public void cmmGetCategoryPathTest(){
        Utility.CMM_Login(Constants.loginIdCMM,Constants.loginPasswordCMM);
    }

}
