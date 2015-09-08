package com.example.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.fail;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class ApplicationManager {

    public WebDriver driver;
    public String baseUrl;
    public ApplicationManager app;
    public StringBuffer verificationErrors = new StringBuffer();

    public NavigationHelper navigationHelper;
    public GroupHelper groupHelper;
    public ContactHelper contactHelper;

    public ApplicationManager() {
        driver = new FirefoxDriver();
        WebDriver driver;
        String baseUrl;
        StringBuffer verificationErrors = new StringBuffer();
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    }
