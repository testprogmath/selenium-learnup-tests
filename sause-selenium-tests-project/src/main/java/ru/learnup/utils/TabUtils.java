package ru.learnup.utils;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;

public class TabUtils {
    public static void switchToTheNextTab(WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Переключаемся на вторую вкладку
        driver.switchTo().window(tabs.get(1));
    }
}
