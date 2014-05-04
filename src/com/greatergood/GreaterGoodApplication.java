package com.greatergood;

import android.app.Application;

import com.parse.Parse;

public class GreaterGoodApplication extends Application {

    private String APPLICATION_ID = "PCuOX6RRY77TBoCnbwLTJkJSOvmAxHxTKQicQZp4";
    private String CLIENT_KEY = "oN9Z3Zrza2YVQYrFb0hwS0KClgiPpTg0iOr0619d";

    @Override
    public void onCreate() {

        super.onCreate();

        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);

    }
}
