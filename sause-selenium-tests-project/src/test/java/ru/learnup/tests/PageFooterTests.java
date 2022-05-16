package ru.learnup.tests;

import org.junit.jupiter.api.Test;
import ru.learnup.pages.LoginPage;

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
