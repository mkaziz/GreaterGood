package com.greatergood.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.greatergood.R;
import com.greatergood.BusinessObjects.Donation;
import com.greatergood.services.DonationService;

public class DonationFragment extends Fragment {

    private Button btnDonation;
    private int donationAmount;

    public static DonationFragment createInstance() {
        return new DonationFragment();
    }

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
            // start settings activity
            break;
        default:
            break;
        }
        return false;

    }

    private void onDonationAmountChanged(int dollarAmount) {
        btnDonation.setText("Donate $" + Integer.toString(dollarAmount));
        donationAmount = dollarAmount;

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
                        donationAmount * 100, 1, 1);

                DonationService.SaveDonation(donation);

                Toast.makeText(getActivity(),
                        "Donated: $" + Integer.toString(donationAmount),
                        Toast.LENGTH_SHORT).show();
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
