package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;

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
        click(By.name("submit"));
    }

    public void initCreateContactPage() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getModilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmailFirsts());
        type(By.name("email2"), contactData.getEmailSecond());
        selectByText(By.name("bday"), contactData.getBirthdayDay());
        selectByText(By.name("bmonth"), contactData.getBithdayMounth());
        type(By.name("byear"), contactData.getBirthdayYear());
        selectByText(By.name("new_group"), contactData.getSelectGroup());
        type(By.name("address2"), contactData.getSecondaryAddressSecond());
        type(By.name("phone2"), contactData.getSecondaryAddressHome());
    }

    public void initContactModification(int index) {
        for (; (By.xpath("//*[@id='id" + index + "']/../..//img[@alt=\"Edit\"]")) == null; index++) {
            index++;
            if (index == 20) {
                break;
            }
        }
        click(By.xpath("//*[@id='id" + index + "']/../..//img[@alt=\"Edit\"]"));


        //click(By.xpath("//input[@name='selected[]' and @value=" + index + "]/../../td[7]"));

    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }
}
