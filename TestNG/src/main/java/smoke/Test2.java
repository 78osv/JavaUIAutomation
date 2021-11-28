package smoke;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 {

    @DataProvider(name = "db")
        public static Object[][] dbData () {
        return new Object[][] {
                {"SQL", new Integer(1)},
                {"NOSQL", new Integer(2)}
        };
    }

    @Test (dataProvider = "db")
    public void test2(String e1, int e2) {
        System.out.println("Test 2" + " " +e1 +" " + e2);
    }
}
