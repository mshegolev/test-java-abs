package com.example.tests;

import org.testng.annotations.Test;

/**
 * #parse Created by Mikhail on 25.08.2015.
 */
public class AlsoGroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().openGroupsPage();
        app.getGroupHelper().initGroupsPage();
        GroupsData groupsData = new GroupsData();

        groupsData.name = "group name 1";
        groupsData.header = "group name 1";
        groupsData.footer = "group name 1";

        app.getGroupHelper().fillGroupForm(groupsData);
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().returnToGroupsPage();

    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().openGroupsPage();
        app.getGroupHelper().initGroupsPage();
        app.getGroupHelper().fillGroupForm(new GroupsData());
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().returnToGroupsPage();
    }


}


