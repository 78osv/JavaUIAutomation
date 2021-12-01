package example;

import org.testng.annotations.Test;

public class Test3 {

    @Test
    public void test3 () {
        System.out.println("Test 3");
    }

    @Test (dependsOnMethods = {"test3"},
           alwaysRun = true) //зависимость/выполнить даже если первый упал
                             // гр.* - сначала все тесты данной группы
    public void test33 () {
        System.out.println("Test 33");
    }
}
