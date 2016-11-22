package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class GroupHelper extends HelperBase {
    private List<GroupData> groups;

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initGroupsPage() {
        click(By.name("new"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.name);
        type(By.name("group_header"), groupData.header);
        type(By.name("group_footer"), groupData.footer);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }


    public void deleteGroup(int index) {
        selectGroupByIndex(index);
        click(By.name("delete"));

    }

    private void selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
    }

    public void initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));

    }

    public void submitGroupModification(int index) {
        click(By.name("update"));
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox : checkboxes){
            GroupData groupData = new GroupData();
            String title = checkbox.getAttribute("title");
            groupData.name=title.substring("Select (".length(),title.length() - ")".length());
            groups.add(groupData);
        }
        return groups;
    }
}
