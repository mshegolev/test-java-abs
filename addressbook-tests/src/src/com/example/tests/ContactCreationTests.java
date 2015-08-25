package com.example.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;
/**
 * Created by Mikhail on 25.08.2015.
 */
public class ContactCreationTests extends TestBase {



        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @BeforeTest
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "http://localhost/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testUntitled() throws Exception {
            openMainPage();
            initCreateContactPage();
            fillContactForm("first name", "last name", "address", "telhome", "telmobile", "telwotk", "email1", "email2", "1", "January", "1990", "group name 1", "Secondary address", "home address");
            submitContactCreation();
            returnToHomePage();
        }

    private void initCreateContactPage() {
        driver.findElement(By.linkText("add new")).click();
    }

    private void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    private void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    private void fillContactForm(String firstName, String lastName, String address, String homePhone, String modilePhone, String workPhone, String emailFirsts, String emailSecond, String birthdayDay, String bithdayMounth, String birthdayYear, String selectGroup, String secondaryAddressSecond, String secondaryAddressHome) {
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(homePhone);
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(modilePhone);
        driver.findElement(By.name("work")).clear();
        driver.findElement(By.name("work")).sendKeys(workPhone);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(emailFirsts);
        driver.findElement(By.name("email2")).clear();
        driver.findElement(By.name("email2")).sendKeys(emailSecond);
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(birthdayDay);
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(bithdayMounth);
        driver.findElement(By.name("byear")).clear();
        driver.findElement(By.name("byear")).sendKeys(birthdayYear);
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(selectGroup);
        driver.findElement(By.name("address2")).clear();
        driver.findElement(By.name("address2")).sendKeys(secondaryAddressSecond);
        driver.findElement(By.name("phone2")).clear();
        driver.findElement(By.name("phone2")).sendKeys(secondaryAddressHome);
    }

    @AfterTest
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


