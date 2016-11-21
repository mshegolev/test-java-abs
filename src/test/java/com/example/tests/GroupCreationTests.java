package com.example.tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Mikhail on 25.08.2015.
 */
public class GroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().openGroupsPage();
        // save old test
        List<GroupsData> oldList= app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().initGroupsPage();
        GroupsData groupsData = new GroupsData();
        groupsData.name = "group name 1";
        groupsData.header = "group name 1";
        groupsData.footer = "group name 1";
        app.getGroupHelper().fillGroupForm(groupsData);
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().returnToGroupsPage();

        //save new state
        List<GroupsData> newList = app.getGroupHelper().getGroups();

        //compare state
        assertEquals(newList.size(),oldList.size()+1);

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


