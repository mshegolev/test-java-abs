package com.example.fw;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class ApplicationManager {

    public NavigationHelper navigationHelper;
    public GroupHelper groupHelper;
    public ContactHelper contactHelper;
    public HelperBase helperBase;
    WebDriver driver;
    String baseUrl;
    ApplicationManager app;
    StringBuffer verificationErrors = new StringBuffer();

    public ApplicationManager() {
        ApplicationManager app;
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
