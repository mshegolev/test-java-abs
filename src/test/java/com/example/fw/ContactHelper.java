package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class ContactHelper extends HelperBase {
    private int index;

    public ContactHelper(ApplicationManager manager) {
        super(manager);
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
        //contactData.selectGroup = "[none]";
        contactData.secondaryAddressSecond = "secondaryAddressSecond";
        //TODO: BUG3|2. phone2 may by rename this field for secondaddresshome
        contactData.secondaryAddressHome = "secondaryAddressHome";
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initCreateContactPage() {
        click(By.linkText("add new"));
    }

    public void fillContactForm() {
        ContactData contactData = new ContactData();
        fillContactForm(contactData);
    }


    public void fillContactFormUpdate(ContactData contactData) {
        type(By.name("firstname"), contactData.firstName);
        type(By.name("lastname"), contactData.lastName);
        type(By.name("address"), contactData.address);
        type(By.name("home"), contactData.homePhone);
        type(By.name("mobile"), contactData.modilePhone);
        type(By.name("work"), contactData.workPhone);
        type(By.name("email"), contactData.emailFirsts);
        type(By.name("email2"), contactData.emailSecond);
        selectByText(By.name("bday"), contactData.birthdayDay);
        selectByText(By.name("bmonth"), contactData.bithdayMounth);
        type(By.name("byear"), contactData.birthdayYear);
        type(By.name("address2"), contactData.secondaryAddressSecond);
        type(By.name("phone2"), contactData.secondaryAddressHome);
    }
    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstName);
        type(By.name("lastname"), contactData.lastName);
        type(By.name("address"), contactData.address);
        type(By.name("home"), contactData.homePhone);
        type(By.name("mobile"), contactData.modilePhone);
        type(By.name("work"), contactData.workPhone);
        type(By.name("email"), contactData.emailFirsts);
        type(By.name("email2"), contactData.emailSecond);
        selectByText(By.name("bday"), contactData.birthdayDay);
        selectByText(By.name("bmonth"), contactData.bithdayMounth);
        type(By.name("byear"), contactData.birthdayYear);
        selectByText(By.name("new_group"), contactData.selectGroup);
        type(By.name("address2"), contactData.secondaryAddressSecond);
        type(By.name("phone2"), contactData.secondaryAddressHome);
    }

    public boolean isConctactExist() {
        return isConctactExist(2);
    }

    public boolean isConctactExist(int index) {
        return isElementPresent(getContact(index));
    }

    private By getContactByIndex(String xpathExpression) {
        return By.xpath(xpathExpression);
    }

    private String selectContactByIndex(int index) {
        return ".//*[@id='maintable']/tbody/tr[" + index + "]/td[7]/a/img";
    }

    public boolean initContactModification() {
        return initContactModification(2);
    }

    public boolean initContactModification(int index) {
        if (isConctactExist(index))
            click(getContact(index));
        return true;

    }

    private By getContact(int index) {
        return getContactByIndex(selectContactByIndex(index));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void deleteContact() {
        click(getContactByIndex("//input[@value='Delete']"));
    }
}
