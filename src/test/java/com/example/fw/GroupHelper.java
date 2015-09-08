package com.example.fw;

import com.example.tests.GroupsData;
import org.openqa.selenium.By;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class GroupHelper extends HelperBase {
    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initGroupsPage() {
        manager.driver.findElement(By.name("new")).click();
    }

    public void submitGroupCreation() {
        manager.driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm() {
    }

    public void fillGroupForm(GroupsData groupsData) {
        manager.driver.findElement(By.name("group_name")).clear();
        manager.driver.findElement(By.name("group_name")).sendKeys(groupsData.name);
        manager.driver.findElement(By.name("group_header")).clear();
        manager.driver.findElement(By.name("group_header")).sendKeys(groupsData.header);
        manager.driver.findElement(By.name("group_footer")).clear();
        manager.driver.findElement(By.name("group_footer")).sendKeys(groupsData.footer);
    }
}
