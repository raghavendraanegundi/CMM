package cmm.test;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;


import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Raghavendra.A on 19-06-2017.
 */
public class IntiateTestNG {

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testngCMM=new TestNG();
        testngCMM.addListener(tla);
        testngCMM.setTestClasses(new Class[] {CMMGetCategoryPathTest.class});
        testngCMM.addListener(tla);
        testngCMM.run();



            }
        }



