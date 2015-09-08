package com.example.tests;


import org.testng.annotations.Test;

/**
 #parse Created by Mikhail on 25.08.2015.
 */
public class ContactCreationTests extends TestBase {
    @Test
    public void addNonEmptyContactNoGroup() throws Exception {
            app.navigationHelper.openMainPage(app);
            app.contactHelper.initCreateContactPage(app);
        ContactData contactData = new ContactData();
        app.contactHelper.defaultContact(contactData);
        app.contactHelper.fillContactForm(contactData, app);
            app.contactHelper.submitContactCreation(app);
            app.navigationHelper.returnToHomePage(app);
        }

    @Test
    public void addNonEmptyContactToGroup() throws Exception {
        app.navigationHelper.openMainPage(app);
        app.navigationHelper.openGroupsPage(app);
        app.groupHelper.initGroupsPage(app);
        GroupsData groupsData = new GroupsData();
        groupsData.name = "Auto_addNonEmptyContactToGroup1";
        groupsData.header = "header test for new contact";
        groupsData.footer = "footer test for new contact";
        app.groupHelper.fillGroupForm(groupsData, app);
        app.groupHelper.submitGroupCreation(app);
        app.navigationHelper.openMainPage(app);
        app.contactHelper.initCreateContactPage(app);
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
        app.contactHelper.fillContactForm();
        app.contactHelper.submitContactCreation(app);
        app.navigationHelper.returnToHomePage(app);
    }

    @Test
    public void addEmptyContact() throws Exception {
        app.navigationHelper.openMainPage(app);
        app.contactHelper.initCreateContactPage(app);
        app.contactHelper.fillContactForm();
        app.contactHelper.submitContactCreation(app);
        app.navigationHelper.returnToHomePage(app);
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







