package ru.learnup.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.learnup.pages.LoginPage;
@Feature("Тесты на подвал страницы")
public class PageFooterTests extends BaseTest{

    @Test
    void goToLinkedInTest(){
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .goToLinkedIn();
    }
}
