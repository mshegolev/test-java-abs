package com.example.tests;


import org.testng.annotations.Test;

/**
 #parse Created by Mikhail on 25.08.2015.
 */
public class ContactCreationTests extends TestBase {
    @Test
    public void addNonEmptyContactNoGroup() throws Exception {
            app.openMainPage();
            app.initCreateContactPage();
        ContactData contactData = new ContactData();
        app.defaultContact(contactData);
        app.fillContactForm(contactData);
            app.submitContactCreation();
            app.returnToHomePage();
        }

    @Test
    public void addNonEmptyContactToGroup() throws Exception {
        app.openMainPage();
        app.openGroupsPage();
        app.initGroupsPage();
        GroupsData groupsData = new GroupsData();
        groupsData.name = "Auto_addNonEmptyContactToGroup1";
        groupsData.header = "header test for new contact";
        groupsData.footer = "footer test for new contact";
        app.fillGroupForm(groupsData);
        app.submitGroupCreation();
        app.openMainPage();
        app.initCreateContactPage();
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
        contactData.selectGroup = groupsData.name;
        contactData.secondaryAddressSecond = "secondaryAddressSecond";
        contactData.secondaryAddressHome = "secondaryAddressHome";
        app.fillContactForm();
        app.submitContactCreation();
        app.returnToHomePage();
    }

    @Test
    public void addEmptyContact() throws Exception {
        app.openMainPage();
        app.initCreateContactPage();
        app.fillContactForm();
        app.submitContactCreation();
        app.returnToHomePage();
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







