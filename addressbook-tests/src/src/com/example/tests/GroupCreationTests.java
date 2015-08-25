package com.example.tests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.*;
import org.testng.annotations.Test;

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
    public void testNonEmptyGroupCreation() throws Exception {
        openMainPage();
        openGroupsPage();
        initGroupsPage();
        GroupsData groupsData = new GroupsData();

        groupsData.name = "group name 1";
        groupsData.header = "group name 1";
        groupsData.footer = "group name 1";

        /*groupsData.setName("groups 52");
        groupsData.setFooter("footer 52");
        groupsData.setHeader("header 52");*/
        fillGroupForm(groupsData);
        submitGroupCreation();
        returnToGroupsPage();

    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        openMainPage();
        openGroupsPage();
        initGroupsPage();
        fillGroupForm(new GroupsData("", "", ""));
        submitGroupCreation();
        returnToGroupsPage();
    }

    private void returnToGroupsPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    private void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupsData groupsData) {
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupsData.name);
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupsData.header);
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupsData.footer);
    }

    private void initGroupsPage() {
        driver.findElement(By.name("new")).click();
    }

    private void openGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    private void openMainPage() {
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


