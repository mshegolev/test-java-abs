package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Mikhail on 27.09.2015.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void addNonEmptyContactNoGroup() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModification(1);
        ContactData contactData = new ContactData();
        contactData.firstName="John";
        contactData.lastName="Smith";
        app.getContactHelper().fillContactForm(contactData);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
    }
}
