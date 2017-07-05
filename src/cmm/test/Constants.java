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
    //CMM Login credentials
    public static final String CMMURL="http://172.30.105.144:8080/managementconsole/login.action;jsessionid=361u8nv04ulj1";
    public static final String loginIdCMM="ekta";
    public static final String loginPasswordCMM="testing";
    //CMM Login page elements
    public static final By.ByName CMM_loginId_text= new By.ByName("j_username");
    public static final By.ByName CMM_loginPassword_text=new By.ByName("j_password");
    public static final By.ByXPath CMM_LoginSubmit_button=new By.ByXPath("//input[@type='submit']");
    //CMM Home page elements
    public static final By.ByPartialLinkText leftMenuDAC_link=new By.ByPartialLinkText("CtecDac");
    public static final By.ByXPath metaDataMngmntSrvcFolder_link=new By.ByXPath("//a[text()='Metadata Management Services']");
    public static final By.ByXPath expandIconMetaDataFolder=new By.ByXPath("(//td/a[text()='Metadata']/../parent::tr/td)[1]/a[1]");
    public static final By.ByLinkText assetsCategory=new By.ByLinkText("Assets");
    public static final By.ByPartialLinkText contentAssetTab=new By.ByPartialLinkText("Content Assets");
    public static final By.ByPartialLinkText contentPackageTab=new By.ByPartialLinkText("Content Packages");
    public static final By.ById assetId_text=new By.ById("searchFilter_criteria__cas_assetId__");
    public static final By.ById assetId_text_content_package=new By.ById("searchFilter_criteria__gas_assetId__");
    public static final By.ByXPath search_button=new By.ByXPath("//input[@type='submit' and @value='Search']");
    public static final By.ByXPath noResults=new By.ByXPath("(//table[@class='tablePageIndex'])[1]//td[contains(text(),'Items') and contains(text(),'0 - 0') and contains(text(),'of')]");
    public static final By.ByXPath expandAssetButton=new By.ByXPath("//tr[@class='whiterow']/td[2]/a[contains(@href,'details1') and contains(@href,'asset1')]");
    public static final By.ByXPath categoryPath=new By.ByXPath("//div[@id='details1']/table//tr/td[u[text()='Category Paths']]/../following-sibling::tr//a");
    public static final String Successful_Login_Title="Management Console for VOD";
    //MDMS Login credentials
    public static final String MDMS_URL="http://172.30.83.16:8300";
    public static final String LoginIdMDMS="seperftest@charter.com";
    public static final String LoginPasswordMDMS="charterqa";
    //MDMS Login Page Elements
    public static final By.ById MDMS_LoginId_Text=new By.ById("operator_email");
    public static final By.ById MDMS_LoginPassword_Text=new By.ById("operator_password");
    public static final By.ByXPath MDMS_LoginSubmit_Button=new By.ByXPath("//*[@id=\"new_operator\"]/fieldset[2]/input");
    //MDMS Home Page Elements
    public static final By.ByXPath MDMS_LoginSuccess_Message=new By.ByXPath("//p[@class='notice' and contains(text(),'Signed in successfully')]");
    public static final By.ByXPath MDMS_ModulesMenu_Link=new By.ByXPath("//a[span and  contains(text(),'Modules')]");
    public static final By.ByLinkText MDMS_AssetManagement_Link=new By.ByLinkText("Asset Management");
    public static final By.ByLinkText MDMS_OfferManagement_Link=new By.ByLinkText("Offer Management");
    //MDMS Search Asset Elements (Title brief URI)
    public static final By.ByXPath MDMS_ExpandSearchControl=new By.ByXPath("//div[@class='page-search-box']//p[@class='search']");
    public static final By.ById MDMS_TitleBriefOrURI_Text=new By.ById("search_localizable_titles.title_brief_or_uri_id");
    public static final By.ByXPath MDMS_SearchButton=new By.ByXPath("search_localizable_titles.title_brief_or_uri_id");
    public static final By.ByXPath MDMS_ResultsFiltered_Message=new By.ByXPath("//p[contains(@class,'pagination_filtered_notice')]");
    public static final By.ByXPath MDMS_SearchAssetList=new By.ByXPath("//table[contains(@class,'assets_list')]//tr");
    public static final By.ById MDMS_SearchTitleBriefStatus_Select=new By.ById("search_assets_status");
    //MDMS Search Asset Elements (Offer Management)
    public static final By.ById MDMS_OfferSearchCriteria_Select=new By.ById("offer_query_offer_query_criteria_attributes_0_key");
    public static final By.ByXPath MDMS_OfferSearchOperator_Select=new By.ByXPath("//select[@id='offer_query_offer_query_criteria_attributes_0_operator' and option[text()='contains']]");
    public static final By.ByXPath MDMS_OfferSearchValue_Text=new By.ByXPath("//input[@id='offer_query_offer_query_criteria_attributes_0_value']");
    public static final By.ByXPath MDMS_OfferSearchButton_Button=new By.ByXPath("//input[@name='commit' and @value='Search']");
    public static final By.ByXPath MDMS_OfferSearchResultList=new By.ByXPath("(//table[@id='offers_table']//tr)[2]");
    public static final By.ByXPath MDMS_FileLocationTable_Rows=new By.ByXPath("//table[tbody/tr/td[contains(text(),'Content')]]//tr[4]//table[tbody/tr/td[text()='File Locations:']]//tr");
    public static final By.ByXPath MDMS_FileLocationText=new By.ByXPath("//table[tbody/tr/td[contains(text(),'Content')]]//tr[4]//table[tbody/tr/td[text()='File Locations:']]//tr[3]/td[3]");
    public static final By.ByXPath MDMS_SearchOptions_Link=new By.ByXPath("//span[@class='dropdown']/../parent::p/a");
    public static final By.ByXPath MDMS_SearchOptionExpand_Indicator=new By.ByXPath("//span[@class='dropdown']/../parent::p");

    public static String current_mdms_package_id="";
}
