package org.testng.internal;

public final class Version {

  public static final String VERSION = initVersion();

  private static String initVersion() {
    final String version = Version.class.getPackage().getImplementationVersion();
    return "7.5-FORK-20211022";
  }

  public static String getVersionString() {
    return VERSION;
  }

  public static void displayBanner() {
    System.out.println(
        "...\n... TestNG " + getVersionString() + " by Cédric Beust (cedric@beust.com)\n...\n");
  }
}
