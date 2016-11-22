package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * #parse Created by Mikhail on 25.08.2015.
 */
public class TestBase {

    protected ApplicationManager app;

    public String generateRandomString() {
        Random rnd = new Random();
        String s;
        if (rnd.nextInt(3) == 0) {
            return s = "";
        } else {
            return s = "test" + rnd.nextInt();
        }
    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        List<Object[]> list = new ArrayList<Object[]>(); // Object[] произвольный набор объектов
        for (int i = 0; i < 5; i++) {
            GroupData group = new GroupData();
            group.name = generateRandomString();
            group.header = generateRandomString();
            group.footer = generateRandomString();
            ;
            list.add(new Object[]{group});
        }
        return list.iterator();
    }


    @BeforeTest
    public void setUp() throws Exception {
        app = new ApplicationManager();
    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();
    }

}
