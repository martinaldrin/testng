package test.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ResultContextListener implements ITestListener {

  public static boolean contextProvided = false;

  @Override
  public void onTestStart(ITestResult result) {
    ITestContext context = result.getTestContext();
    if (context != null) {
      contextProvided = true;
    }
  }

  @Override
  public void onTestSuccess(ITestResult result) {}

  @Override
  public void onTestFailure(ITestResult result) {}

  @Override
  public void onTestSkipped(ITestResult result) {}

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

  @Override
  public void onStart(ITestContext context) {}

  @Override
  public void onFinish(ITestContext context) {}
}
