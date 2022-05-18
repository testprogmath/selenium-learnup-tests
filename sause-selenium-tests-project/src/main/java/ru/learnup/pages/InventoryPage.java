package ru.learnup.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.learnup.elements.SortingDropDownValues;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;

public class InventoryPage extends BaseAuthorizedPage {

    @Getter
    @FindBy(id = "shopping_cart_container")
    WebElement cartContainer;
    @Getter
    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadge;

    @Getter
    @FindBy(css = "[data-test=product_sort_container]")
    WebElement sortingDropdown;

    public InventoryPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public InventoryPage checkInventoryPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    public InventoryPage checkCartOnThePage() {
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo(0)));
        return this;
    }

    // имя опции текстом
    public InventoryPage chooseSortingOption(String value) {
        sortingDropdown.click();
        By locator = SortingDropDownValues.valueOf(value).getElementLocator();
        driver.findElement(locator).click();
        return this;
    }
    // имя опции типом ENUM
    public InventoryPage chooseSortingOption(SortingDropDownValues value) {
        sortingDropdown.click();
        driver.findElement(value.getElementLocator()).click();
        return this;
    }


}
