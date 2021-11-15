package test.configuration;

import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import test.SimpleBaseTest;

public abstract class ConfigurationBaseTest extends SimpleBaseTest {
  protected void testConfiguration(Class<?>... classes) {
    TestNG tng = create(classes);

    TestListenerAdapter tla = new TestListenerAdapter();
    tng.addListener(tla);
    tng.run();

    Assert.assertEquals(
        tla.getConfigurationFailures().size(),
        0,
        getFailedResultMessage(tla.getConfigurationFailures()));
    Assert.assertEquals(
        tla.getFailedTests().size(), 0, getFailedResultMessage(tla.getFailedTests()));
    Assert.assertEquals(
        tla.getSkippedTests().size(), 0, getFailedResultMessage(tla.getSkippedTests()));
    Assert.assertFalse(tla.getPassedTests().isEmpty(), "All tests should pass");
  }
}
