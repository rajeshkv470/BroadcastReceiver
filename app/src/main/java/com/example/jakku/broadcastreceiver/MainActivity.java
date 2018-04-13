package com.example.jakku.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
BroadcastService broadcastService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button);
                IntentFilter filter = new IntentFilter();
                filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

                broadcastService = new BroadcastService();
                registerReceiver(broadcastService, filter);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        if(broadcastService!=null){
            unregisterReceiver(broadcastService);
        }
        super.onDestroy();
    }
}
