package smoke;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    @Parameters({"db"})
    @Test (groups = {"smokeTest", "regress"})
    public void test1 (String db) {
        System.out.println("Test1"+ db);
    }

    @Test (groups = {"regress"})
    public void test11 () {
        System.out.println("Test11");
    }

    @Test (groups = {"regress"})
    public void test111 () {
        System.out.println("Test111");
    }

}
