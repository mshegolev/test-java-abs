package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Mikhail on 25.08.2015.
 */
public class AlsoGroupCreationTests extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        openMainPage();
        openGroupsPage();
        initGroupsPage();
        GroupsData groupsData = new GroupsData();

        groupsData.name = "group name 1";
        groupsData.header = "group name 1";
        groupsData.footer = "group name 1";

        fillGroupForm(groupsData);
        submitGroupCreation();
        returnToGroupsPage();

    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        openMainPage();
        openGroupsPage();
        initGroupsPage();
        fillGroupForm(new GroupsData("", "", ""));
        submitGroupCreation();
        returnToGroupsPage();
    }


}


