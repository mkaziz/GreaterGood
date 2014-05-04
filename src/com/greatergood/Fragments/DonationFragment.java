package com.greatergood.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.greatergood.R;
import com.greatergood.Activities.ConfirmationActivity;
import com.greatergood.BusinessObjects.Donation;
import com.greatergood.services.DonationService;

public class DonationFragment extends BaseFragment {

    private Button btnDonation;
    private int donationAmountInDollars;

    private int DOLLARS_TO_CENTS_MULTIPLIER = 100;

    public static DonationFragment createInstance() {
        return new DonationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void onDonationAmountChanged(int dollarAmount) {
        btnDonation.setText("Donate $" + Integer.toString(dollarAmount));
        donationAmountInDollars = dollarAmount;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_donation, container);

        btnDonation = (Button) v.findViewById(R.id.donate_button);

        btnDonation.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Donation donation = Donation.CreateDonation(
                        donationAmountInDollars * DOLLARS_TO_CENTS_MULTIPLIER,
                        1, 1);

                DonationService.SaveDonation(donation);

                Toast.makeText(
                        getActivity(),
                        "Donated: $"
                                + Integer.toString(donationAmountInDollars),
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(), ConfirmationActivity.class);
                startActivity(i);

            }

        });

        SeekBar sbSuggestedDonation = (SeekBar) v
                .findViewById(R.id.donation_seek_bar);

        sbSuggestedDonation.setProgress(10);
        onDonationAmountChanged(10);

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
                        onDonationAmountChanged(progress);

                    }
                });

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
