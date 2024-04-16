package org.openlib.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenLibPageLocators {


    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5")
    public WebElement homePageUserName;

    @FindBy(name = "q")
    public WebElement homePageSearch;

    @FindBy(className = "search-bar-submit")
    public WebElement homePageSubmitButton;

    @FindBy(id = "searchResults")
    public WebElement homePageSearchResult;

    @FindBy(xpath = "(//*[@title=\"English\"])[2]")
    public WebElement homePageEngLang;

    @FindBy(xpath = "(//*[@title=\"Spanish\"])[2]")
    public WebElement homePageEsLang;

    @FindBy(xpath = "(//*[@itemprop='author'])[2]")
    public WebElement bookPageAuthor;
}
