package com.greatergood.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.greatergood.R;
import com.greatergood.Activities.PreferencesActivity;

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflator) {
        super.onCreateOptionsMenu(menu, inflator);
        inflator.inflate(R.menu.fragment_donation, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_settings:
            Intent i = new Intent(getActivity(), PreferencesActivity.class);
            startActivity(i);
            break;
        default:
            break;
        }
        return false;

    }
}
