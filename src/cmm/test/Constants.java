package cmm.test;

import org.openqa.selenium.By;

/**
 * Created by Raghavendra.A on 19-06-2017.
 *
 * Contains all the constants and element locators used across the scripts
 */
public class Constants {

    public static final int pageLoadTimeout=5;
    public static final int findElementRetryCount=3;
    public static final String CMMURL="http://172.30.105.144:8080/managementconsole/login.action;jsessionid=361u8nv04ulj1";
    public static final String loginIdCMM="ekta";
    public static final String loginPasswordCMM="testing";
    //Login page elements
    public static final By.ByName loginId_text= new By.ByName("j_username");
    public static final By.ByName loginPassword_text=new By.ByName("j_password");
    public static final By.ByXPath LoginSubmit_button=new By.ByXPath("//input[@type='submit']");
    //Home page elements
    public static final By.ByPartialLinkText leftMenuDAC_link=new By.ByPartialLinkText("CtecDac");
    public static final By.ByXPath metaDataMngmntSrvcFolder_link=new By.ByXPath("//a[text()='Metadata Management Services']");
    public static final By.ByXPath expandIconMetaDataFolder=new By.ByXPath("(//td/a[text()='Metadata']/../parent::tr/td)[1]/a[1]");
    public static final By.ByLinkText assetsCategory=new By.ByLinkText("Assets");
    public static final By.ByPartialLinkText contentAssetTab=new By.ByPartialLinkText("Content Assets");
    public static final By.ById assetId_text=new By.ById("searchFilter_criteria__cas_assetId__");
    public static final By.ByXPath search_button=new By.ByXPath("//input[@type='submit' and @value='Search']");
    public static final By.ByXPath noResults=new By.ByXPath("(//table[@class='tablePageIndex'])[1]//td[contains(text(),'Items') and contains(text(),'0 - 0') and contains(text(),'of')]");
    public static final By.ByXPath expandAssetButton=new By.ByXPath("");
    public static final By.ByXPath categoryPath=new By.ByXPath("");

    //Others
    public static final String Successful_Login_Title="Management Console for VOD";
}
