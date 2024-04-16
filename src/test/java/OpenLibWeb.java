import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openlib.actions.OpenLibPageActions;
import org.openlib.utils.HttpServiceHandler;
import org.openlib.utils.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class OpenLibWeb {
    OpenLibPageActions objOpenLibPage = new OpenLibPageActions();

    HttpServiceHandler httpServiceHandler = new HttpServiceHandler();
    private String publishedYear = "//*[@class='publishedYear' and  contains (text(),'".replace("'", "\'");

    @And("User sets website in {string}")
    public void userSetsWebsiteIn(String arg0) {
        objOpenLibPage.setPageLanguage("English");
    }


    @Given("User is on OpenLibrary page {string}")
    public void loginPageTest(String url) {

        TestBaseClass.openPage(url);

    }

    @When("User searches using title option for book {string}")
    public void userSearchesUsingTitleOptionForBook(String arg0) {
        //search for book
        objOpenLibPage.searchBook(arg0);
        //validate we got results with the book title
        Assert.assertTrue(objOpenLibPage.getSearchResult().contains(arg0));

    }

    @Then("User should be able to see that book {string}")
    public void userShouldBeAbleToSeeThatBook(String arg0) {
        //validate we got results with the book title
        Assert.assertTrue(objOpenLibPage.getSearchResult().contains(arg0));
    }

    @And("User chooses book published in {string}")
    public void userChoosesBookPublishedIn(String arg0) {
        // locate book section by published year
        WebDriverWait webDriverWait = new WebDriverWait(TestBaseClass.getDriver(), Duration.ofMillis(5000));
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(publishedYear + arg0 + "' )]//following::a[1]")));
        //click on book section
        element.click();
        //wait for book page to load and get the author name
        TestBaseClass.authorNameWeb = objOpenLibPage.getAuthorName();
        TestBaseClass.authorNameWeb.toLowerCase();
    }

    @And("Get author from API")
    public void getAuthorFromAPI() throws IOException {
        Response httpResponse = httpServiceHandler.getAuthorByNameAndFilterByPublishYear("F+.+Gilot", "1973");
        // check status code is 200
        Assert.assertEquals(httpResponse.code(), 200);
        String jsonData = httpResponse.body().string();
        JSONObject jObj = new JSONObject(jsonData);
        JSONArray jsonArray = jObj.getJSONArray("docs");
        TestBaseClass.authorNameApi = jsonArray.getJSONObject(0).getJSONArray("author_name").getString(0);

    }

    @Then("Author from API matches author on book page")
    public void authorFromAPIMatchesAuthorOnBookPage() {
        Assert.assertEquals(TestBaseClass.authorNameApi, TestBaseClass.authorNameWeb);
    }
}
