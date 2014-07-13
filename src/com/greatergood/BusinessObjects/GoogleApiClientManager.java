package com.greatergood.BusinessObjects;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.plus.Plus;

public class GoogleApiClientManager implements ConnectionCallbacks,
        OnConnectionFailedListener {
    private GoogleApiClient mGoogleApiClient;

    public static GoogleApiClientManager get(Context c, ConnectionCallbacks cc,
            OnConnectionFailedListener cfl) {
        GoogleApiClientManager gacm = new GoogleApiClientManager();
        gacm.load(c, cc, cfl);
        return gacm;
    }

    public void connect() {
        if (!this.isConnecting()) {
            mGoogleApiClient.connect();
        }
    }

    public boolean isConnected() {
        return mGoogleApiClient.isConnected();
    }

    public void disconnectIfNecessary() {
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    public boolean isConnecting() {
        return mGoogleApiClient.isConnecting();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onConnectionSuspended(int cause) {
        // TODO Auto-generated method stub
        connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // TODO Auto-generated method stub
        // if (!result.hasResolution()) {
        // GooglePlayServicesUtil.getErrorDialog(result.getErrorCode(),
        // mContext, 0).show();
        // return;
        // }
    }

    private void load(Context c, ConnectionCallbacks cc,
            OnConnectionFailedListener cfl) { // , SignInFragment
        // f) {
        mGoogleApiClient = new GoogleApiClient.Builder(c)
                .addConnectionCallbacks(cc).addOnConnectionFailedListener(cfl)
                .addApi(Plus.API).addScope(Plus.SCOPE_PLUS_PROFILE).build();
        // mContext = c;
    }
}
