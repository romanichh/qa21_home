package com.wiki.tests;

import com.wiki.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class TestBase {
  protected static ApplicationManager app =
          new ApplicationManager(System.getProperty("browser", BrowserType.EDGE));
  Logger logger = LoggerFactory.getLogger(TestBase.class);
  @BeforeSuite
  public  void setUp(){
    app.init();
  }

  @AfterSuite
  public void tearDown() throws InterruptedException {

    app.stop();
  }
 @BeforeMethod
  public void startLogger(Method m){
    logger.info("start test "+ m.getName() );
  }
  @AfterMethod
  public void stopLogger(Method m){
    logger.info("stop test " + m.getName());
  }
}
