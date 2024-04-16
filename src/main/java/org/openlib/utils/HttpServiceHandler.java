package org.openlib.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpServiceHandler {
    public Response getAuthorByNameAndFilterByPublishYear(String author, String year) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request
                .Builder()
                .url("https://openlibrary.org/search.json?author=" + author + "&first_publish_year=" + year)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }
}
