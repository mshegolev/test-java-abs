package com.example.fw;

import com.example.tests.GroupsData;
import org.openqa.selenium.By;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class GroupHelper {
    public void initGroupsPage(ApplicationManager applicationManager) {
        applicationManager.driver.findElement(By.name("new")).click();
    }

    public void submitGroupCreation(ApplicationManager applicationManager) {
        applicationManager.driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm() {
    }

    public void fillGroupForm(GroupsData groupsData, ApplicationManager applicationManager) {
        applicationManager.driver.findElement(By.name("group_name")).clear();
        applicationManager.driver.findElement(By.name("group_name")).sendKeys(groupsData.name);
        applicationManager.driver.findElement(By.name("group_header")).clear();
        applicationManager.driver.findElement(By.name("group_header")).sendKeys(groupsData.header);
        applicationManager.driver.findElement(By.name("group_footer")).clear();
        applicationManager.driver.findElement(By.name("group_footer")).sendKeys(groupsData.footer);
    }
}
