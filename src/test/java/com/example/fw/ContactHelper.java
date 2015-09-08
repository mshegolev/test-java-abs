package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
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

    public void submitContactCreation() {
        manager.driver.findElement(By.name("submit")).click();
    }

    public void initCreateContactPage() {
        manager.driver.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contactData) {
        manager.driver.findElement(By.name("firstname")).clear();
        manager.driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        manager.driver.findElement(By.name("lastname")).clear();
        manager.driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        manager.driver.findElement(By.name("address")).clear();
        manager.driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
        manager.driver.findElement(By.name("home")).clear();
        manager.driver.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
        manager.driver.findElement(By.name("mobile")).clear();
        manager.driver.findElement(By.name("mobile")).sendKeys(contactData.getModilePhone());
        manager.driver.findElement(By.name("work")).clear();
        manager.driver.findElement(By.name("work")).sendKeys(contactData.getWorkPhone());
        manager.driver.findElement(By.name("email")).clear();
        manager.driver.findElement(By.name("email")).sendKeys(contactData.getEmailFirsts());
        manager.driver.findElement(By.name("email2")).clear();
        manager.driver.findElement(By.name("email2")).sendKeys(contactData.getEmailSecond());
        new Select(manager.driver.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthdayDay());
        new Select(manager.driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBithdayMounth());
        manager.driver.findElement(By.name("byear")).clear();
        manager.driver.findElement(By.name("byear")).sendKeys(contactData.getBirthdayYear());
        new Select(manager.driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getSelectGroup());
        manager.driver.findElement(By.name("address2")).clear();
        manager.driver.findElement(By.name("address2")).sendKeys(contactData.getSecondaryAddressSecond());
        manager.driver.findElement(By.name("phone2")).clear();
        manager.driver.findElement(By.name("phone2")).sendKeys(contactData.getSecondaryAddressHome());
    }
}
