package org.openlib.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenLibPageLocators {


    @FindBy(name = "q")
    public WebElement homePageSearch;

    @FindBy(className = "search-bar-submit")
    public WebElement homePageSubmitButton;

    @FindBy(id = "searchResults")
    public WebElement homePageSearchResult;

    @FindBy(xpath = "(//*[contains(text(), \"English (en)\")])[2]")
    public WebElement homePageEngLang;

    @FindBy(xpath = "(//*[contains(text(), \"Español (es)\")])[2]")
    public WebElement homePageEsLang;

    @FindBy(xpath = "(//*[@itemprop='author'])[2]")
    public WebElement bookPageAuthor;
}