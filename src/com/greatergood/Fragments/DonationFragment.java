package com.greatergood.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.greatergood.R;

public class DonationFragment extends Fragment {

    public static DonationFragment createInstance() {
        return new DonationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_donation, container);

        SeekBar sbSuggestedDonation = (SeekBar) v
                .findViewById(R.id.donation_seek_bar);

        sbSuggestedDonation.setProgress(5);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
