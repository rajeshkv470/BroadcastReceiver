package com.example.jakku.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by jakku on 4/13/2018.
 */

public class BroadcastService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connect = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = connect.getActiveNetworkInfo();
        boolean networkavailable =false;

        if(netinfo!=null){
            if(netinfo.isAvailable()){
                    networkavailable = true;
                }
        }
        if(networkavailable){
     Toast.makeText(context,"Rajesh Jakkula", Toast.LENGTH_LONG).show();
    }else{
        Toast.makeText(context, "Rajeswari Jakkula", Toast.LENGTH_LONG).show();

        }
    }
    }

