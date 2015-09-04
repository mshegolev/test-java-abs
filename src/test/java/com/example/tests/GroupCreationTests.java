package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Mikhail on 25.08.2015.
 */
public class GroupCreationTests extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.openMainPage();
        app.openGroupsPage();
        app.initGroupsPage();
        GroupsData groupsData = new GroupsData();
        groupsData.name = "group name 1";
        groupsData.header = "group name 1";
        groupsData.footer = "group name 1";
        app.fillGroupForm(groupsData);
        app.submitGroupCreation();
        app.returnToGroupsPage();

    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app.openMainPage();
        app.openGroupsPage();
        app.initGroupsPage();
        app.fillGroupForm(new GroupsData("", "", ""));
        app.submitGroupCreation();
        app.returnToGroupsPage();
    }


}


