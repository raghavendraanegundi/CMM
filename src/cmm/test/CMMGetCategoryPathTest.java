package cmm.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * Created by Raghavendra.A on 19-06-2017.
 */
public class CMMGetCategoryPathTest {

    WebDriver driver=null;
    String csv_file_name="CMM_SEARCH_OUTPUT.csv";
    String output_file_header="Title_Brief|Provider|Package_ID|tcPID|RunTime|Rating|Price|Trick|LicenseStart|LicenseEnd|Genre|Category|Title|EpisodeName|EpisodeNum|TargetHeadend|CategoryPath";

    @BeforeTest
    public void setUp(){
        driver= DriverManager.getDriver();
        driver.get(Constants.CMMURL);
        Utility.read_excel();
        Utility.write_to_file(csv_file_name,output_file_header);
    }

    @Test
    public void cmmGetCategoryPathTest(){
        Utility.CMM_Login(Constants.loginIdCMM,Constants.loginPasswordCMM);
        Utility.navigate_to_assets_category();
//        Utility.open_content_assets_tab();
        Utility.search_all_package_id_in_CMM();
   }

    @AfterTest
    public void tearDown(){

    }

}
