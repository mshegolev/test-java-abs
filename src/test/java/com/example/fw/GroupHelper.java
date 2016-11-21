package com.example.fw;

import com.example.tests.GroupsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class GroupHelper extends HelperBase {
    private List<GroupsData> groups;

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initGroupsPage() {
        click(By.name("new"));
    }

    public void fillGroupForm(GroupsData groupsData) {
        type(By.name("group_name"), groupsData.name);
        type(By.name("group_header"), groupsData.header);
        type(By.name("group_footer"), groupsData.footer);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }


    public void deleteGroup(int index) {
        selectGroupByIndex(index);
        click(By.name("delete"));

    }

    private void selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + index + "]"));
    }

    public void initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));

    }

    public void submitGroupModification(int index) {
        click(By.name("update"));
    }

    public List<GroupsData> getGroups() {
        List<GroupsData> groups = new ArrayList<GroupsData>();
        List<WebElement> checkboxes = driver.findElements(By.name("selcted[]"));
        for (WebElement checkbox : checkboxes){
            GroupsData groupsData = new GroupsData();
            String title = checkbox.getAttribute("title");
            groupsData.name=title.substring("Select (".length(),title.length() - ")".length());
            groups.add(groupsData);
        }
        return groups;
    }
}
