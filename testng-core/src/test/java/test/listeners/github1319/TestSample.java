package test.listeners.github1319;

import com.google.common.collect.Maps;
import java.util.Map;
import org.testng.Assert;
import org.testng.IConfigurationListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestSample.Listener.class)
public class TestSample {
  public static int hashcode;

  public TestSample() {
    hashcode = hashCode();
  }

  @Test
  public void test1() {
    Assert.assertTrue(true);
  }

  @Test
  public void test2() {
    Assert.assertTrue(false);
  }

  @Test
  public void test3() {
    throw new SkipException("simulating a skip");
  }

  @AfterClass
  public void afterClass() {}

  @AfterTest
  public void afterTest() {
    throw new RuntimeException("Simulating a failure");
  }

  @AfterSuite
  public void afterSuite() {
    throw new SkipException("simulating a skip");
  }

  public static class Listener implements IConfigurationListener, ITestListener {
    public static Map<String, Object> maps = Maps.newConcurrentMap();

    @Override
    public void onConfigurationSuccess(ITestResult itr) {
      maps.put(itr.getMethod().getMethodName(), itr.getInstance());
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
      maps.put(itr.getMethod().getMethodName(), itr.getInstance());
    }

    @Override
    public void onConfigurationSkip(ITestResult itr) {
      maps.put(itr.getMethod().getMethodName(), itr.getInstance());
    }

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult itr) {
      maps.put(itr.getMethod().getMethodName(), itr.getInstance());
    }

    @Override
    public void onTestFailure(ITestResult itr) {
      maps.put(itr.getMethod().getMethodName(), itr.getInstance());
    }

    @Override
    public void onTestSkipped(ITestResult itr) {
      maps.put(itr.getMethod().getMethodName(), itr.getInstance());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
  }
}
