package org.openlib.actions;

import org.openlib.locators.OpenLibPageLocators;
import org.openlib.utils.TestBaseClass;
import org.openqa.selenium.support.PageFactory;

public class OpenLibPageActions {
    OpenLibPageLocators homePageLocators = null;

    public OpenLibPageActions() {

        this.homePageLocators = new OpenLibPageLocators();

        PageFactory.initElements(TestBaseClass.getDriver(), homePageLocators);
    }

    // Get the User name from Home Page
    public String getHomePageText() {
        return homePageLocators.homePageUserName.getText();
    }

    public void setPageLanguage(String language) {
        switch (language) {
            case "English":
                homePageLocators.homePageEngLang.click();
                break;
            case "Spanish":
                homePageLocators.homePageEsLang.click();
                break;
            default:
                homePageLocators.homePageEngLang.click();
        }
    }

    public void searchBook(String book) {
        //click into text search box
        homePageLocators.homePageSearch.click();
        //enter text in search box and hit search button
        homePageLocators.homePageSearch.sendKeys(book);
        homePageLocators.homePageSubmitButton.click();
    }

    public String getSearchResult() {

        return homePageLocators.homePageSearchResult.getText();
    }

    public String getAuthorName() {
        return homePageLocators.bookPageAuthor.getText();
    }
}
