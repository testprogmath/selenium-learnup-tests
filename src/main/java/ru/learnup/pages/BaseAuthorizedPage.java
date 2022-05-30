package ru.learnup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.learnup.elements.FooterPageElement;
import ru.learnup.elements.SideMenu;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.learnup.utils.TabUtils.switchToTheNextTab;

public class BaseAuthorizedPage extends BasePage implements FooterPageElement, SideMenu {
    //footer elements
    @FindBy(css = ".social_twitter a")
    WebElement twitterButton = null;
    @FindBy(css = ".social_facebook a")
    WebElement facebookButton = null;
    @FindBy(css = ".social_linkedin a")
    WebElement linkedInButton = null;

    @FindBy(id = "react-burger-menu-btn")
    WebElement sideMenu;
    @FindBy(id = "logout_sidebar_link")
    WebElement logOutButton;


    public BaseAuthorizedPage(final WebDriver driver) {
        super(driver);

    }

    @Override
    public void goToLinkedIn() {
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("linkedin.com"));
    }

    @Override
    public LoginPage logOut() {
        sideMenu.click();
        logOutButton.click();
        return new LoginPage(driver);
    }
}
