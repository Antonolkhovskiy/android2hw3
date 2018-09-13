package com.example.anton.android2hw3;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;



/**
 * Created by Anton on 29.04.2018.
 */

public class GeofenceTransitionsIntentService extends IntentService {
    private static final String TAG = "MapActivity";

    public GeofenceTransitionsIntentService() {
        super("GeofenceTransitionsIntentService");
        Log.d(TAG, "GeofenceTransitionsIntentService: created");
    }



/*
    public GeofenceTransitionsIntentService(String name) {
        super(name); 
        Log.d(TAG, "GeofenceTransitionsIntentService: adsfasdf");
    }
*/

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent: sending notification");
            alarmNotifiaction();
        Log.d(TAG, "onHandleIntent:  notification sent");
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void alarmNotifiaction(){
        Log.d(TAG, "alarmNotifiaction: start");
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,1 , intent, 0);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, 0, pendingIntent);
        Log.d(TAG, "alarmNotifiaction: end");

    }

}

