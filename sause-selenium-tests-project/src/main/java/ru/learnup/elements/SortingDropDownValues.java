package ru.learnup.elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum SortingDropDownValues {
    NAME_ASC(By.cssSelector("[data-test=product_sort_container] > [value=az]"), "Name (A to Z)");
//    NAME_DESC(""),
//    PRICE_ASC,
//    PRICE_DESC;

    @Getter
    By elementLocator;
    @Getter
    String title;
    SortingDropDownValues( By cssSelector, String title) {
        this.elementLocator = cssSelector;
        this.title = title;
    }

    public SortingDropDownValues getByValue(String title) {
        return SortingDropDownValues.valueOf(title);
    }
}
