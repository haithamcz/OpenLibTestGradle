package org.openlib.com;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openlib.actions.OpenLibPageActions;
import org.openlib.utils.HttpServiceHandler;
import org.openlib.utils.TestBaseClass;
import org.testng.Assert;

import java.io.IOException;

public class OpenLibWebStepDefinitions {
    OpenLibPageActions objOpenLibPage = new OpenLibPageActions();

    HttpServiceHandler httpServiceHandler = new HttpServiceHandler();

    @And("User sets website in {string}")
    public void userSetsWebsiteIn(String lang) {
        objOpenLibPage.setPageLanguage(lang);
    }


    @Given("User is on OpenLibrary page {string}")
    public void loginPageTest(String url) {

        TestBaseClass.openPage(url);

    }

    @When("User searches using title option for book {string}")
    public void userSearchesUsingTitleOptionForBook(String book) {
        //search for book
        objOpenLibPage.searchBook(book);

    }

    @Then("User should be able to see that book {string}")
    public void userShouldBeAbleToSeeThatBook(String book) {
        //validate we got results with the book title
        Assert.assertTrue(objOpenLibPage.getSearchResult().contains(book));
    }

    @And("User chooses book published in {string}")
    public void userChoosesBookPublishedIn(String publishedYear) {
        //chose book published in year and get the author name
        objOpenLibPage.userChoosesBookPublishedInAndGetAuthorName(publishedYear);
    }

    @And("Get author from API {string}")
    public void getAuthorFromAPI(String authorName) throws IOException {
        httpServiceHandler.getAuthorByNameAndFilterByPublishYear(authorName, "1973");

    }

    @Then("Author from API matches author on book page")
    public void authorFromAPIMatchesAuthorOnBookPage() {
        Assert.assertEquals(TestBaseClass.authorNameApi, TestBaseClass.authorNameWeb);
    }
}
