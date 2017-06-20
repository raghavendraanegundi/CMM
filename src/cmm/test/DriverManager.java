package cmm.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Raghavendra.A on 19-06-2017.
 */
public class DriverManager {

    public static WebDriver driver;
    public static void createDriver(){
        if(driver==null) {
            driver = new HtmlUnitDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        }
    }

    public static WebDriver getDriver(){
        createDriver();
        return driver;
    }
}
