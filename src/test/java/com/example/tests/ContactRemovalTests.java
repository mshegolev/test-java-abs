package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Mikhail on 27.09.2015.
 */
public class ContactRemovalTests extends TestBase {
    @Test
    public void deleteSomeContact(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnToHomePage();
    }
}
