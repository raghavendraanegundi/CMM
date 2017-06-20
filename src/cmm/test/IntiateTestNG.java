package cmm.test;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/**
 * Created by Raghavendra.A on 19-06-2017.
 */
public class IntiateTestNG {

    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng=new TestNG();
        testng.setTestClasses(new Class[] { CMMGetCategoryPathTest.class });
        testng.addListener(tla);
        testng.run();
   }

}
