package smoke;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Test4 {
    @Test (retryAnalyzer = Retry.class)
    public void test4 () {
        System.out.println("Test 4");
        Assert.fail();
    }
}

