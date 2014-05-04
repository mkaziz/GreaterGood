package com.greatergood.Activities;

import android.app.Fragment;
import android.os.Bundle;

import com.greatergood.Fragments.PreferencesFragment;

public class PreferencesActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        // TODO Auto-generated method stub
        return new PreferencesFragment();
    }

}
