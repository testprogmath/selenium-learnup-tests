package ru.learnup.tests.tech;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import ru.learnup.pages.InventoryPage;
import ru.learnup.pages.LoginPage;
import ru.learnup.tests.BaseTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.learnup.elements.SortingDropDownValues.NAME_ASC;

@Slf4j
@Epic("Технические тесты")
@Story("Тесты на удаление/добавление cookie")
public class CookiesTests extends BaseTest {


    @Test
    // тест должен падать, так как мы подставляем сломанного пользователя
    void setCookiesTest() {
        InventoryPage inventoryPage = new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("session-username", "locked_out_user", "/"));
// тест должен падать
        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
    }

    @Test
    void name() {
      new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
              .chooseSortingOption(NAME_ASC);

        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        // сделать проверку на сортировку, используя компараторы
    }

    @AfterEach
    void tearDown() {
        new InventoryPage(driver)
                .logOut();
    }
}
