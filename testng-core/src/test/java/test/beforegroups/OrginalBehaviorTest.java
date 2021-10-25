package test.beforegroups;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/** This Class is used for live demo sessions. Do not add any test code here. */
public class OrginalBehaviorTest {

//  boolean valueA = false;
//  boolean valueB = false;
//
//  @BeforeClass
//  public void setup() {
//    System.setProperty("testng.disable.new.group.beavhor", "true");
//  }
//
//  @BeforeGroups(groups = "groupA")
//  public void beforeGroupA() {
//    System.out.println("beforeGroupA");
//    valueA = true;
//  }
//
//  @BeforeGroups(groups = "groupB")
//  public void beforeGroupB() {
//    valueB = true;
//    System.out.println("beforeGroupB");
//  }
//
//  @BeforeGroups(groups = "groupC")
//  public void beforeGroupC() {
//    System.out.println("beforeGroupC No Test exist, should not run.");
//  }
  
	 @BeforeSuite(priority=100)
	  public void beforeSuiteA() {
		  System.out.println("beforeSuiteA");
	  }
	  
	 @BeforeSuite(priority = 1)
	  public void beforeSuiteB() {
		  System.out.println("beforeSuiteB");
	  }
	
	
	 @BeforeClass(priority=100)
	  public void beforeClassA() {
		  System.out.println("beforeClassA");
	  }
	  
	 @BeforeClass(priority = 1)
	  public void beforeClassB() {
		  System.out.println("beforeClassB");
	  }
	
	
	
  @BeforeMethod(priority=100)
  public void beforeA() {
	  System.out.println("beforeMethodA");
  }
  
  @BeforeMethod(priority = 1)
  public void beforeB() {
	  System.out.println("beforeMethodB");
  }
  

  @Test(priority = 100)
  public void testA() {
    System.out.println("TestA");
  }

  @Test
  public void testB() {
    System.out.println("TestB");
  }
//
//  @Test
//  public void testC() {
//    System.out.println("TestC");
//  }
//
//  @Test(groups = "groupA")
//  public void testGroupA1() {
//    System.out.println("testGroupA1");
//    Assert.assertTrue(valueA, "BeforeGroupA was not executed");
//  }
//
//  @Test(groups = "groupA")
//  public void testGroupA2() {
//    System.out.println("testGroupA2");
//    Assert.assertTrue(valueA, "BeforeGroupA was not executed");
//  }
//
//  @Test(groups = "groupA")
//  public void testGroupA3() {
//    System.out.println("testGroupA3");
//    Assert.assertTrue(valueA, "BeforeGroupA was not executed");
//  }
//
//  @Test(groups = "groupB")
//  public void testGroupB() {
//    System.out.println("testGroupB");
//    Assert.assertTrue(valueB, "BeforeGroupB was not executed");
//  }
//
//  @AfterGroups(groups = "groupA")
//  public void afterGroupA() {
//    System.out.println("afterGroupA");
//    valueA = false;
//  }
//
//  @AfterGroups(groups = "groupB")
//  public void afterGroupB() {
//    System.out.println("afterGroupB");
//    valueB = false;
//  }
//
//  @AfterClass
//  public void afterClass() {
//    Assert.assertFalse(valueA, "AfterGroupsA was not executed");
//    Assert.assertFalse(valueB, "AfterGroupsB was not executed");
//  }
}
