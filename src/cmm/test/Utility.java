package cmm.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

/**
 * Created by Raghavendra.A on 19-06-2017.
 */
public class Utility {


    public static WebElement findElement(By locator) {
        WebElement element = null;
        for (int i = 0; i < Constants.findElementRetryCount; i++) {
            try {
                System.out.println("Utility.findElement :: Finding Element " + locator.toString() + " Try " + i);
                element = DriverManager.driver.findElement(locator);
                return element;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Utility.findElement ::" + e.getMessage());
                System.out.println("Utility.findElement :: Element Not Found");
            }
        }
        return null;
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


    public static void CMM_Login(String userName,String password){
        typeText(Constants.loginId_text,userName);
        typeText(Constants.loginPassword_text,password);
        click(Constants.LoginSubmit_button);
        //Todo : Verify Login was successfull and return boolean value depending on that
    }
}
