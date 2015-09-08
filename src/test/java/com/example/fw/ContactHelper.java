package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class ContactHelper {
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

    public void submitContactCreation(ApplicationManager applicationManager) {
        applicationManager.driver.findElement(By.name("submit")).click();
    }

    public void initCreateContactPage(ApplicationManager applicationManager) {
        applicationManager.driver.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contactData, ApplicationManager applicationManager) {
        applicationManager.driver.findElement(By.name("firstname")).clear();
        applicationManager.driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        applicationManager.driver.findElement(By.name("lastname")).clear();
        applicationManager.driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        applicationManager.driver.findElement(By.name("address")).clear();
        applicationManager.driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
        applicationManager.driver.findElement(By.name("home")).clear();
        applicationManager.driver.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
        applicationManager.driver.findElement(By.name("mobile")).clear();
        applicationManager.driver.findElement(By.name("mobile")).sendKeys(contactData.getModilePhone());
        applicationManager.driver.findElement(By.name("work")).clear();
        applicationManager.driver.findElement(By.name("work")).sendKeys(contactData.getWorkPhone());
        applicationManager.driver.findElement(By.name("email")).clear();
        applicationManager.driver.findElement(By.name("email")).sendKeys(contactData.getEmailFirsts());
        applicationManager.driver.findElement(By.name("email2")).clear();
        applicationManager.driver.findElement(By.name("email2")).sendKeys(contactData.getEmailSecond());
        new Select(applicationManager.driver.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthdayDay());
        new Select(applicationManager.driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBithdayMounth());
        applicationManager.driver.findElement(By.name("byear")).clear();
        applicationManager.driver.findElement(By.name("byear")).sendKeys(contactData.getBirthdayYear());
        new Select(applicationManager.driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getSelectGroup());
        applicationManager.driver.findElement(By.name("address2")).clear();
        applicationManager.driver.findElement(By.name("address2")).sendKeys(contactData.getSecondaryAddressSecond());
        applicationManager.driver.findElement(By.name("phone2")).clear();
        applicationManager.driver.findElement(By.name("phone2")).sendKeys(contactData.getSecondaryAddressHome());
    }
}
