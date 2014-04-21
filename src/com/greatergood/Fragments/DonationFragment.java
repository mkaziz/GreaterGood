package com.greatergood.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.greatergood.R;

public class DonationFragment extends Fragment {

    public static DonationFragment createInstance() {
        return new DonationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private Button btnDonation;

    private void setDonationButtonText(int dollarAmount) {
        btnDonation.setText("Donate $" + Integer.toString(dollarAmount));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_donation, container);

        btnDonation = (Button) v.findViewById(R.id.donate_button);

        SeekBar sbSuggestedDonation = (SeekBar) v
                .findViewById(R.id.donation_seek_bar);

        sbSuggestedDonation.setProgress(10);
        setDonationButtonText(10);

        sbSuggestedDonation
                .setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                            int progress, boolean fromUser) {
                        // TODO Auto-generated method stub
                        setDonationButtonText(progress);

                    }
                });

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
