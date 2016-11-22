package com.example.tests;

import org.testng.annotations.Test;

/**
 * #parse Created by Mikhail on 25.08.2015.
 */
public class AlsoGroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupsPage();
        GroupData groupData = new GroupData();

        groupData.name = "group name 1";
        groupData.header = "group name 1";
        groupData.footer = "group name 1";

        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().returnToGroupsPage();

    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupsPage();
        app.getGroupHelper().fillGroupForm(new GroupData());
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().returnToGroupsPage();
    }


}


