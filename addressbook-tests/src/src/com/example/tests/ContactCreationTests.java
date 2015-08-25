package com.example.tests;

import org.testng.annotations.Test;
/**
 #parse Created by Mikhail on 25.08.2015.
 */
public class ContactCreationTests extends TestBase {

        @Test
        public void addNonEmptyContact() throws Exception {
            openMainPage();
            initCreateContactPage();
            fillContactForm(new ContactData("first name", "last name", "address", "telhome", "telmobile", "telwotk", "email1", "email2", "1", "January", "1990", "group name 1", "Secondary address", "home address"));
            submitContactCreation();
            returnToHomePage();
        }

    @Test
    public void addEmptyContact() throws Exception {
        openMainPage();
        initCreateContactPage();
        fillContactForm();
        submitContactCreation();
        returnToHomePage();
    }
}


