package com.mds2019.broadcastreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {

    private static final String ACTION = "com.mds2019.broadcastreceiver.action";

    @Override
    public void onReceive(Context context,
                          Intent intent) {
        final String action = intent.getAction();
        if (ACTION.equals(action)) {
            context.startService(intent);
        }
    }
}
