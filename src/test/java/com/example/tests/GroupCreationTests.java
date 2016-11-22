package com.example.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

/**
 * Created by Mikhail on 25.08.2015.
 */
public class GroupCreationTests extends TestBase {


    public String generateRandomString(){
        Random rnd = new Random();
        String s;
        if (rnd.nextInt(3) == 0){
            return s ="";
        } else {
            return s = "test" + rnd.nextInt();
        }
    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator(){
        List<Object[]> list = new ArrayList<Object[]>(); // Object[] произвольный набор объектов
        for (int i =0; i<5; i++){
            GroupData group = new GroupData();
            group.name = generateRandomString();
            group.header = generateRandomString();
            group.footer = generateRandomString();;
            list.add(new Object[]{group});
        }
        return list.iterator();
    }

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        // save old test
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().initGroupsPage();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().returnToGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare state
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList,oldList);
    }

}


