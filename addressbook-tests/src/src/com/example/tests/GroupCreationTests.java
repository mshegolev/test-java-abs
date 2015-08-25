package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Mikhail on 25.08.2015.
 */
public class GroupCreationTests {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        openMainPage();
        openGroupsPage();


        // init new group creation
        driver.findElement(By.name("new")).click();
        // fill group form
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys("group 1");
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys("header 1");
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys("footer 1");
        // submit group creation
        driver.findElement(By.name("submit")).click();
            /* return to groups page */
        driver.findElement(By.linkText("group page")).click();
    }

    private void openGroupsPage() {
        // open groups page
        driver.findElement(By.linkText("groups")).click();
    }

    private void openMainPage() {
        // open main page
        driver.get(baseUrl + "/addressbookv4.1.4/");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


}


