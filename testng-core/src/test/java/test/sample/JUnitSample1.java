package test.sample;

import junit.framework.TestCase;

/**
 * This class
 *
 * @author Cedric Beust, May 5, 2004
 */
public class JUnitSample1 extends TestCase {
  public static final String EXPECTED2 = "testSample1_2";
  public static final String EXPECTED1 = "testSample1_1";

  public JUnitSample1() {
    super();
  }

  public JUnitSample1(String n) {
    super(n);
  }

  @Override
  public void setUp() {}

  @Override
  public void tearDown() {}

  public void testSample1_1() {}

  public void testSample1_2() {}
}
