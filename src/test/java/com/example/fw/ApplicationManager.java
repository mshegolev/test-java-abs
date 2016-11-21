package com.example.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class ApplicationManager {

    public WebDriver driver;
    public String baseUrl;
    public StringBuffer verificationErrors = new StringBuffer();


    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;

    public ApplicationManager() {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/addressbookv4.1.4/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public GroupHelper getGroupHelper() {
        if (groupHelper == null) {
            groupHelper = new GroupHelper(this);
        }
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        if (contactHelper == null) {
            contactHelper = new ContactHelper(this);
        }
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        if (navigationHelper == null) {
            navigationHelper = new NavigationHelper(this);
        }
        return navigationHelper;
    }

    public void stop() {
        driver.quit();
    }


}
