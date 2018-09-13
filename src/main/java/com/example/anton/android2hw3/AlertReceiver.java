package com.example.anton.android2hw3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Anton on 29.04.2018.
 */

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder notficBuilder = notificationHelper.getNotification();
        notificationHelper.getManager().notify(1, notficBuilder.build());
    }
}
