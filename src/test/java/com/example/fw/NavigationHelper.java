package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by mikhail.shchegolev on 04.09.2015.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage() {
        manager.driver.get(String.format("%s", manager.baseUrl));
    }

    public void openGroupsPage() {
        manager.driver.findElement(By.linkText("groups")).click();
    }

    public void returnToHomePage() {
        manager.driver.findElement(By.linkText("home page")).click();
    }

    public void returnToGroupsPage() {
        manager.driver.findElement(By.linkText("group page")).click();
    }
}
