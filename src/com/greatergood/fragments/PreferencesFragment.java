package com.greatergood.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import com.greatergood.R;
import com.greatergood.activities.SignInActivity;

public class PreferencesFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        Preference signInPreference = findPreference("pref_sign_in");

        // GoogleApiClientManager.get(getActivity(), this, this);
        signInPreference
                .setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference arg0) {
                        // code for what you want it to do

                        Intent i = new Intent(getActivity(),
                                SignInActivity.class);
                        startActivity(i);

                        return true;
                    }
                });
    }

}
