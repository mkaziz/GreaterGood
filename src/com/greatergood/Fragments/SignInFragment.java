package com.greatergood.Fragments;

import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.plus.Plus;
import com.greatergood.R;
import com.greatergood.BusinessObjects.GoogleApiClientManager;

public class SignInFragment extends BaseFragment implements OnClickListener,
        ConnectionCallbacks, OnConnectionFailedListener {

    private GoogleApiClientManager mGoogleApiClientManger;
    // private GoogleApiClient googleApiClient;
    private static final int RC_SIGN_IN = 0;
    private boolean intentInProgress;
    private boolean signInClicked = false;
    private ConnectionResult connectionResult;

    @Override
    public void onCreateOptionsMenu(Menu menu,
            android.view.MenuInflater inflator) {
        // override to prevent settings menu display
    };

    public static SignInFragment createInstance() {
        return new SignInFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // mGoogleApiClientManger = GoogleApiClientManager.get();
    }

    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClientManger.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        mGoogleApiClientManger.disconnectIfNecessary();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_in, container);

        SignInButton btnSignIn = (SignInButton) v
                .findViewById(R.id.sign_in_button);

        btnSignIn.setOnClickListener(this);

        googleApiClient = new GoogleApiClient.Builder(this.getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_PROFILE).build();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sign_in_button
                && !mGoogleApiClientManger.isConnecting()) {
            signInClicked = true;
            resolveSignInError();
        }
    }

    private void resolveSignInError() {
        if (connectionResult.hasResolution()) {
            try {
                intentInProgress = true;
                connectionResult.startResolutionForResult(this.getActivity(),
                        RC_SIGN_IN);
            } catch (SendIntentException e) {
                intentInProgress = false;
                mGoogleApiClientManger.connect();

            }
        }
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        signInClicked = false;
        Toast.makeText(this.getActivity(), "User is connected!",
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onConnectionSuspended(int cause) {
        mGoogleApiClientManger.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        if (!result.hasResolution()) {
            GooglePlayServicesUtil.getErrorDialog(result.getErrorCode(),
                    this.getActivity(), 0).show();
            return;
        }

        if (!intentInProgress) {
            // Store the ConnectionResult for later usage
            connectionResult = result;

            if (signInClicked) {
                // The user has already clicked 'sign-in' so we attempt to
                // resolve all
                // errors until the user is signed in, or they cancel.
                resolveSignInError();
            }
        }

    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent data) {
        // TODO Auto-generated method stub
        if (requestCode == RC_SIGN_IN) {
            if (responseCode != this.getActivity().RESULT_OK) {
                signInClicked = false;
            }

            intentInProgress = false;

            mGoogleApiClientManger.connect();

            super.onActivityResult(requestCode, responseCode, data);
        }
    }
}
