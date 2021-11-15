package test.morten;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class SampleTest {
  public class SampleTestTestFactory {
    public SampleTestTestFactory() {} // CTR necessary ?

    @Factory
    public Object[] createInstances() {
      return new SampleTest[] {
        new SampleTest(1, 0.1f), new SampleTest(10, 0.5f),
      };
    }
  }

  public SampleTest() {}

  public SampleTest(int capacity, float loadFactor) {
    System.out.println("CREATING TEST WITH " + capacity);
  }

  @Test
  public void testPut() {
    // FIXME: This test does nothing
    // HashMap hashTable = new HashMap(capacity, loadFactor);
    // ...
  }
}
