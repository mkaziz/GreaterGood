package com.greatergood.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;

import com.greatergood.fragments.SignInFragment;

public class SignInActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected Fragment createFragment() {
        // TODO Auto-generated method stub
        return SignInFragment.createInstance();
    }

}
