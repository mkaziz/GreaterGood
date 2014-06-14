package com.greatergood.BusinessObjects;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;

public class GoogleApiClientManager implements ConnectionCallbacks {
    private GoogleApiClient mGoogleApiClient;

    public static GoogleApiClientManager get(Context c) {
        GoogleApiClientManager gacm = new GoogleApiClientManager();
        // gacm.Builder(c);
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

    public GoogleApiClientManager load(Context c) {
        // mGoogleApiClient = new GoogleApiClient.Builder(c)
        // .addConnectionCallbacks(this);
        // .addOnConnectionFailedListener(this).addApi(Plus.API)
        // .addScope(Plus.SCOPE_PLUS_PROFILE).build();
        return this;
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onConnectionSuspended(int cause) {
        // TODO Auto-generated method stub

    }
}
