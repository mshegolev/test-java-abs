package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Mikhail on 27.09.2015.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().openGroupsPage();
        app.getGroupHelper().initGroupModification(1);
        GroupsData groupsData = new GroupsData();
        groupsData.name="new name";
        app.getGroupHelper().fillGroupForm(groupsData);
        app.getGroupHelper().submitGroupModification(1);
        app.getNavigationHelper().returnToGroupsPage();
    }
}
