package cmm.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by 598470 on 6/27/2017.
 */
public class Firefox {

    public static  void main(String[] args){
        System.setProperty("webdriver.gecko.driver","libs/geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        driver.get(Constants.MDMS_URL);
    }
}
