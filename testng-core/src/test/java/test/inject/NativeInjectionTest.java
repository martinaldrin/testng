package test.inject;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.SimpleBaseTest;
import test.inject.NativeInjectionTestSamples.BadAfterClassSample;
import test.inject.NativeInjectionTestSamples.BadAfterGroupsSample;
import test.inject.NativeInjectionTestSamples.BadAfterMethodSample;
import test.inject.NativeInjectionTestSamples.BadAfterSuiteSample;
import test.inject.NativeInjectionTestSamples.BadAfterTestSample;
import test.inject.NativeInjectionTestSamples.BadBeforeClassSample;
import test.inject.NativeInjectionTestSamples.BadBeforeGroupsSample;
import test.inject.NativeInjectionTestSamples.BadBeforeMethodSample;
import test.inject.NativeInjectionTestSamples.BadBeforeSuiteSample;
import test.inject.NativeInjectionTestSamples.BadBeforeTestSample;

public class NativeInjectionTest extends SimpleBaseTest {

  @Test(dataProvider = "getTestData")
  public void testBeforeSuiteInjection(Class clazz, String methodName, String expected) {
    TestNG tng = create(clazz);
    InjectionResultHolder holder = new InjectionResultHolder();
    tng.addListener(holder);
    tng.setGroups("test");
    tng.run();
    Assert.assertTrue(holder.getErrorMessage().contains(expected + methodName));
  }

  @DataProvider
  public Object[][] getTestData() {
    String variant1 = "Can inject only one of <ITestContext, XmlTest> into a @%s annotated ";
    String variant2 =
        "Can inject only one of <ITestContext, XmlTest, Method, Object[], ITestResult> into a @%s annotated ";
    return new Object[][] {
      {
        BadBeforeSuiteSample.class,
        "beforeSuite",
        String.format(variant1, BeforeSuite.class.getSimpleName())
      },
      {
        BadBeforeTestSample.class,
        "beforeTest",
        String.format(variant1, BeforeTest.class.getSimpleName())
      },
      {
        BadBeforeClassSample.class,
        "beforeClass",
        String.format(variant1, BeforeClass.class.getSimpleName())
      },
      {
        BadBeforeMethodSample.class,
        "beforeMethod",
        String.format(variant2, BeforeMethod.class.getSimpleName())
      },
      {
        BadAfterMethodSample.class,
        "afterMethod",
        String.format(variant2, AfterMethod.class.getSimpleName())
      },
      {
        BadAfterClassSample.class,
        "afterClass",
        String.format(variant1, AfterClass.class.getSimpleName())
      },
      {
        BadAfterTestSample.class,
        "afterTest",
        String.format(variant1, AfterTest.class.getSimpleName())
      },
      {
        BadAfterSuiteSample.class,
        "afterSuite",
        String.format(variant1, AfterSuite.class.getSimpleName())
      },
      {
        BadBeforeGroupsSample.class,
        "beforeGroups",
        String.format(variant1, BeforeGroups.class.getSimpleName())
      },
      {
        BadAfterGroupsSample.class,
        "afterGroups",
        String.format(variant1, AfterGroups.class.getSimpleName())
      }
    };
  }

  public static class InjectionResultHolder extends TestListenerAdapter {
    private String errorMessage;

    String getErrorMessage() {
      return errorMessage;
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
      this.errorMessage = itr.getThrowable().getMessage();
    }
  }
}
