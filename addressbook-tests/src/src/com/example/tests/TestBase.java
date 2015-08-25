package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 #parse Created by Mikhail on 25.08.2015.
 */
public class TestBase {
    private static WebDriver driver;
    private static String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void returnToGroupsPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupsData groupsData) {
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupsData.name);
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupsData.header);
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupsData.footer);
    }

    protected void initGroupsPage() {
        driver.findElement(By.name("new")).click();
    }

    protected void openGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void openMainPage() {
        driver.get(String.format("%s/addressbookv4.1.4/", baseUrl));
    }

    protected void initCreateContactPage() {
        driver.findElement(By.linkText("add new")).click();
    }

    protected void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillContactForm(ContactData contactData) {
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(contactData.getModilePhone());
        driver.findElement(By.name("work")).clear();
        driver.findElement(By.name("work")).sendKeys(contactData.getWorkPhone());
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contactData.getEmailFirsts());
        driver.findElement(By.name("email2")).clear();
        driver.findElement(By.name("email2")).sendKeys(contactData.getEmailSecond());
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthdayDay());
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBithdayMounth());
        driver.findElement(By.name("byear")).clear();
        driver.findElement(By.name("byear")).sendKeys(contactData.getBirthdayYear());
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getSelectGroup());
        driver.findElement(By.name("address2")).clear();
        driver.findElement(By.name("address2")).sendKeys(contactData.getSecondaryAddressSecond());
        driver.findElement(By.name("phone2")).clear();
        driver.findElement(By.name("phone2")).sendKeys(contactData.getSecondaryAddressHome());
    }

    protected void fillContactForm() {
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
