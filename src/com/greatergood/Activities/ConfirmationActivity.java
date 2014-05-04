package com.greatergood.Activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;

import com.greatergood.Fragments.ConfirmationFragment;

public class ConfirmationActivity extends SingleFragmentActivity {

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
        return new ConfirmationFragment();
    }

}
