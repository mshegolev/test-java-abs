package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Mikhail on 25.08.2015.
 */
public class GroupCreationTests extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.navigationHelper.openMainPage(app);
        app.navigationHelper.openGroupsPage(app);
        app.groupHelper.initGroupsPage(app);
        GroupsData groupsData = new GroupsData();
        groupsData.name = "group name 1";
        groupsData.header = "group name 1";
        groupsData.footer = "group name 1";
        app.groupHelper.fillGroupForm(groupsData, app);
        app.groupHelper.submitGroupCreation(app);
        app.navigationHelper.returnToGroupsPage(app);

    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app.navigationHelper.openMainPage(app);
        app.navigationHelper.openGroupsPage(app);
        app.groupHelper.initGroupsPage(app);
        app.groupHelper.fillGroupForm(new GroupsData("", "", ""), app);
        app.groupHelper.submitGroupCreation(app);
        app.navigationHelper.returnToGroupsPage(app);
    }


}


