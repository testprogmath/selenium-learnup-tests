package ru.learnup;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotMaker {
    public static File makeScreenshotOnFailure(WebDriver driver) {
       return ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    }
}
