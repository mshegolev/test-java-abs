package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;


/**
 * Created by Mikhail on 27.09.2015.
 */
public class GroupRemovalTests extends TestBase {

    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        // save old test
        List<GroupData> oldList= app.getGroupHelper().getGroups();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);

        //actions
        app.getGroupHelper().deleteGroup(index);
        app.getNavigationHelper().returnToGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare state
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList,oldList);
    }

}
