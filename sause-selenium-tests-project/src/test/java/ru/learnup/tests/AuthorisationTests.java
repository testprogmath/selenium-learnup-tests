package ru.learnup.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.learnup.pages.LoginPage;

class AuthorisationTests extends BaseTest {

    @Test
    void authorisationWithLoginPagePositiveTest() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }

    @AfterEach
    void tearDown() {
        // тоже нужно вынести в BaseAuthorizedPage
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}