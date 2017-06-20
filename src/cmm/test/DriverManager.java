package cmm.test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import sun.plugin2.util.BrowserType;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Raghavendra.A on 19-06-2017.
 */
public class DriverManager {

    public static WebDriver driver;
    public static void createDriver(){
        if(driver==null) {
            driver = new HtmlUnitDriver(BrowserVersion.CHROME,true);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public static WebDriver getDriver(){
        createDriver();
        return driver;
    }
}
