package com.example.tests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Mikhail on 25.08.2015.
 */
public class GroupCreationTests extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        openMainPage();
        openGroupsPage();
        initGroupsPage();
        GroupsData groupsData = new GroupsData();

        groupsData.name = "group name 1";
        groupsData.header = "group name 1";
        groupsData.footer = "group name 1";

        /*groupsData.setName("groups 52");
        groupsData.setFooter("footer 52");
        groupsData.setHeader("header 52");*/
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


