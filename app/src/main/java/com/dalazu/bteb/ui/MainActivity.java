package com.dalazu.bteb.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dalazu.bteb.R;
import com.google.android.material.card.MaterialCardView;
import com.onesignal.Continue;
import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;

public class MainActivity extends AppCompatActivity {
    private static final String ONESIGNAL_APP_ID = "559591ca-14b6-4a78-b8b3-0871501496de";

    private MaterialCardView cardIndividualResult, cardGroupResults, cardCgpaCatculetor, cardBtebNotice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardIndividualResult = findViewById(R.id.card_individual_result);
        cardGroupResults = findViewById(R.id.card_group_results);
        cardCgpaCatculetor = findViewById(R.id.card_cgpa_catculetor);
        cardBtebNotice = findViewById(R.id.card_bteb_notice);

        cardIndividualResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IndividualResultActivity.class));
            }
        });

        cardGroupResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GroupResultActivity.class));
            }
        });
        cardCgpaCatculetor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CgpaCalculetorActivity.class));
            }
        });
        cardBtebNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BtebNoticeActivity.class));
            }
        });

        //One Signal Notifiaction section
        OneSignal.getDebug().setLogLevel(LogLevel.VERBOSE);
        OneSignal.initWithContext(this, ONESIGNAL_APP_ID);
        OneSignal.getNotifications().requestPermission(false, Continue.none());


    }
}