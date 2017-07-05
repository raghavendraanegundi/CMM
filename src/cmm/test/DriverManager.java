package cmm.test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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

            driver=new HtmlUnitDriver(new BrowserVersion("Netscape", "5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.3029.110 Safari/537.36", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.3029.110 Safari/537.36", 52),true);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public static WebDriver getDriver(){
        createDriver();
        return driver;
    }

    public static void setDriver(HtmlUnitDriverExt customDriver){
        driver=customDriver;
    }
}
