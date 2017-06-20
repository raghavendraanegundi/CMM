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
    public static final By.ById loginId_text= new By.ById("");
    public static final By.ById loginPassword_text=new By.ById("");
    public static final By.ById LoginSubmit_button=new By.ById("");
    //Home page elements
    public static final By.ByLinkText leftMenuDAC_link=new By.ByLinkText("");
    public static final By.ByLinkText metaDataMngmntSrvcFolder_link=new By.ByLinkText("");
    public static final By.ByXPath expandIconMetaDataFolder=new By.ByXPath("");
    public static final By.ByXPath assetsCategory=new By.ByXPath("");
    public static final By.ByXPath contentAssetTab=new By.ByXPath("");
    public static final By.ByXPath assetId_text=new By.ByXPath("");
    public static final By.ById search_button=new By.ById("");
    public static final By.ByXPath expandAssetButton=new By.ByXPath("");
    public static final By.ByXPath categoryPath=new By.ByXPath("");
}
