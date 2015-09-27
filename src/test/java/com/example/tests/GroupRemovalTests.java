package com.example.tests;

import org.testng.annotations.*;


/**
 * Created by Mikhail on 27.09.2015.
 */
public class GroupRemovalTests extends TestBase {
    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().openGroupsPage();
        app.getGroupHelper().deleteGroup(1);
        app.getNavigationHelper().returnToGroupsPage();
    }

}
