package com.tutorials.hp.alarmmanagerstarter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Oclemy on 1/19/2017 for ProgrammingWizards Channel and http://www.camposha.com.
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
