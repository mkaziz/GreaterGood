package com.greatergood.Activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;

import com.greatergood.R;
import com.greatergood.Fragments.DonationFragment;

public class DonationActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.donation, menu);
        return true;
    }

    @Override
    protected Fragment createFragment() {
        // TODO Auto-generated method stub
        return DonationFragment.createInstance();
    }

}
