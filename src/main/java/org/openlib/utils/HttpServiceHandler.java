package org.openlib.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

public class HttpServiceHandler {
    public void getAuthorByNameAndFilterByPublishYear(String author, String year) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request
                .Builder()
                .url("https://openlibrary.org/search.json?author=" + author + "&first_publish_year=" + year)
                .get()
                .build();
        Response response = client.newCall(request).execute();

        // check status code is 200
        Assert.assertEquals(response.code(), 200);
        // extract author data from response
        String jsonData = response.body().string();
        JSONObject jObj = new JSONObject(jsonData);
        JSONArray jsonArray = jObj.getJSONArray("docs");
        TestBaseClass.authorNameApi = jsonArray.getJSONObject(0).getJSONArray("author_name").getString(0).toLowerCase();
    }
}
