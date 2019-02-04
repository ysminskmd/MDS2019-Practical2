package com.mds2019.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String EXTRA_DATA = "extra_data";

    public MyIntentService() {
        super("MyIntentService");
    }

    //adb shell am startservice com.mds2019.broadcastreceiver/.MyIntentService

    @Override
    protected void onHandleIntent(Intent intent) {
        final int count = intent.getIntExtra(EXTRA_DATA, 0);
        for (int i = 0; i < count; i++) {
            Log.d("MDS", "i = " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
