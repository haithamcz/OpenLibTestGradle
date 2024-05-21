package org.openlib.actions;

import org.openlib.locators.OpenLibPageLocators;
import org.openlib.utils.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OpenLibPageActions {
    OpenLibPageLocators homePageLocators = null;

    private String publishedYearLink = "//*[@class='publishedYear' and  contains (text(),'".replace("'", "\'");

    public OpenLibPageActions() {

        this.homePageLocators = new OpenLibPageLocators();

        PageFactory.initElements(TestBaseClass.getDriver(), homePageLocators);
    }


    public void setPageLanguage(String language) {
        switch (language) {
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

        //validate we got results with the book title
        Assert.assertTrue(getSearchResult().contains(book));
    }

    public String getSearchResult() {

        return homePageLocators.homePageSearchResult.getText();
    }

    public void userChoosesBookPublishedInAndGetAuthorName(String publishedYear) {
        // locate book section by published year
        WebDriverWait webDriverWait = new WebDriverWait(TestBaseClass.getDriver(), Duration.ofMillis(5000));
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(publishedYearLink + publishedYear + "' )]//following::a[1]")));
        //click on book section
        element.click();
        //get the author name and set global author name
        TestBaseClass.authorNameWeb = getAuthorName();
    }

    public String getAuthorName() {
        return homePageLocators.bookPageAuthor.getText().toLowerCase();
    }
}
