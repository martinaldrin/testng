package test.jarpackages;

import java.io.File;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import test.SimpleBaseTest;

public class JarPackagesTest extends SimpleBaseTest {
  private TestListenerAdapter init(String jarFile) {
    TestNG tng = create();
    File currentDir = new File(".");
    StringBuilder path = new StringBuilder().append(currentDir.getAbsolutePath());
    char s = File.separatorChar;
    path.append(s)
        .append("test")
        .append(s)
        .append("src")
        .append(s)
        .append("test")
        .append(s)
        .append("jarpackages")
        .append(s);
    String finalPath = path.append(jarFile).toString();
    tng.setTestJar(finalPath);
    TestListenerAdapter result = new TestListenerAdapter();
    tng.addListener(result);
    tng.run();

    return result;
  }

  @Test
  public void jarWithTestngXml() {
    TestListenerAdapter tla = init("withtestngxml.jar");
    Assert.assertEquals(tla.getPassedTests().size(), 2);
    String first = tla.getPassedTests().get(0).getName();
    String second = tla.getPassedTests().get(1).getName();
    boolean fThenG = "f".equals(first) && "g".equals(second);
    boolean gThenF = "g".equals(first) && "f".equals(second);
    Assert.assertTrue(fThenG || gThenF);
  }

  @Test
  public void jarWithoutTestngXml() {
    TestListenerAdapter tla = init("withouttestngxml.jar");
    Assert.assertEquals(tla.getPassedTests().size(), 2);
    String first = tla.getPassedTests().get(0).getName();
    String second = tla.getPassedTests().get(1).getName();
    boolean fThenG = "f".equals(first) && "g".equals(second);
    boolean gThenF = "g".equals(first) && "f".equals(second);
    Assert.assertTrue(fThenG || gThenF);
  }
}
