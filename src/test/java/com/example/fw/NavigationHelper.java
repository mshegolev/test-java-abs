package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage(ApplicationManager applicationManager) {
        applicationManager.driver.get(String.format("%s", applicationManager.baseUrl));
    }

    public void openGroupsPage(ApplicationManager applicationManager) {
        applicationManager.driver.findElement(By.linkText("groups")).click();
    }

    public void returnToHomePage(ApplicationManager applicationManager) {
        applicationManager.driver.findElement(By.linkText("home page")).click();
    }

    public void returnToGroupsPage(ApplicationManager applicationManager) {
        applicationManager.driver.findElement(By.linkText("group page")).click();
    }
}
