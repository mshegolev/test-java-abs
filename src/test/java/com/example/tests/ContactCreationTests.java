package com.example.tests;


import org.testng.annotations.Test;

/**
 * #parse Created by Mikhail on 25.08.2015.
 */
public class ContactCreationTests extends TestBase {
    @Test
    public void addNonEmptyContactNoGroup() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initCreateContactPage();
        ContactData contactData = new ContactData();
        app.getContactHelper().defaultContact(contactData);
        app.getContactHelper().fillContactForm(contactData);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
    }

    @Test
    public void addNonEmptyContactToGroup() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupsPage();
        GroupData groupData = new GroupData();
        groupData.name = "Auto_addNonEmptyContactToGroup1";
        groupData.header = "header test for new contact";
        groupData.footer = "footer test for new contact";
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initCreateContactPage();
        ContactData contactData = new ContactData();
        contactData.firstName = "firstName";
        contactData.lastName = "lastName";
        contactData.address = "address";
        contactData.homePhone = "homePhone";
        contactData.modilePhone = "modilePhone";
        contactData.workPhone = "workPhone";
        contactData.emailFirsts = "emailFirsts";
        contactData.emailSecond = "emailSecond";
        contactData.birthdayDay = "1";
        contactData.bithdayMounth = "January";
        contactData.birthdayYear = "1990";
        contactData.selectGroup = groupData.name;
        contactData.secondaryAddressSecond = "secondaryAddressSecond";
        contactData.secondaryAddressHome = "secondaryAddressHome";
        app.getContactHelper().fillContactForm();
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
    }

    @Test
    public void addEmptyContact() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initCreateContactPage();
        app.getContactHelper().fillContactForm();
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
    }
/*
    @Test
    public void deleteContact() throws Exception {
        openMainPage();
        EditContact();
        clickDelete();
    }
*/

}







