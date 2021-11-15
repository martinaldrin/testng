package test.ant;

import org.testng.annotations.Test;

@Test
public class DontOverrideSuiteNameTest {
  @Test(groups = {"nopackage"})
  public void test() {}
}
