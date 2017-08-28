package com.tutorials.hp.alarmmanagerstarter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Oclemy for ProgrammingWizards Channel and http://www.camposha.info.
 - Our MyReciever class.
 - Derives from  android.content.BroadcastReceiver class.
 - Methods: onReceive().
 - We show a toast message in our onReceive() method to simulate alarm ringing.
 */


public class MyReceiver extends BroadcastReceiver {
    /*
    RING ALARM WHEN IN WHEN WE RECEIVE OUR BROADCAST
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Ringing...", Toast.LENGTH_SHORT).show();
    }
}
