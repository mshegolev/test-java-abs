package com.example.fw;

import com.example.tests.ContactData;
import com.example.tests.GroupsData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.fail;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class ApplicationManager {


    private static WebDriver driver;
    private static String baseUrl;
    protected com.example.fw.ApplicationManager app;
    private StringBuffer verificationErrors = new StringBuffer();

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

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void returnToGroupsPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void fillGroupForm() {
    }

    public void fillGroupForm(GroupsData groupsData) {
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupsData.name);
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupsData.header);
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupsData.footer);
    }

    public void initGroupsPage() {
        driver.findElement(By.name("new")).click();
    }

    public void openGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void openMainPage() {
        driver.get(String.format("%s", baseUrl));
    }

    public void initCreateContactPage() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillContactForm(ContactData contactData) {
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

    public void fillContactForm() {
    }

    public void defaultContact(ContactData contactData) {
        contactData.firstName = "firstName";
        contactData.lastName = "lastName";
        contactData.address = "address";
        contactData.homePhone = "homePhone";
        contactData.modilePhone = "modilePhone";
        contactData.workPhone = "workPhone";
        contactData.emailFirsts = "emailFirsts";
        contactData.emailSecond = "emailSecond";
        //TODO: add select numberic day
        contactData.birthdayDay = "1";
        //TODO: add select mounth
        contactData.bithdayMounth = "January";
        //TODO: add input year
        contactData.birthdayYear = "1990";
        //TODO: add select exsistings group
        contactData.selectGroup = "[none]";
        contactData.secondaryAddressSecond = "secondaryAddressSecond";
        //TODO: BUG3|2. phone2 may by rename this field for secondaddresshome
        contactData.secondaryAddressHome = "secondaryAddressHome";
    }

    public void closeReklama() throws Exception {
//        driver.get(baseUrl + "/");
        driver.get(baseUrl + "/");
        Assert.assertEquals("Address book", driver.getTitle());
        driver.findElement(By.cssSelector("a.close.bClose")).click();
        driver.findElement(By.linkText("home")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | wy7vo | 30000]]
        Assert.assertEquals("Address book", driver.getTitle());
        driver.findElement(By.linkText("home")).click();
        Assert.assertEquals("Address book", driver.getTitle());
    }

    protected void clickDelete() {
        driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();
    }

    //TODO: write xpath querry
    protected void EditContact() {
        By.xpath("id('maintable'):tbody(like\"lastname\"):td[7]/x:a/x:img").findElement(driver).click();
    }

    //TODO: write xpath querry
    protected void selectContact() {
        driver.findElement(By.id("select by name")).click();
    }
}
