package ru.learnup.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        this.driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(30))
                .implicitlyWait(Duration.ofSeconds(4));

        initElements(this.driver, this);
    }
}
