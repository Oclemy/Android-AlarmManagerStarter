package com.tutorials.hp.alarmmanagerstarter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*
- Our MainActivity class.
- Derives from AppCompatActivity which resides in the support library.
- Methods: onCreate(),initializeViews(),go().
- Inflated From content_main.xml using the setContentView() method.
- The views we use are EditTexts and Buttons.
- Reference EditText and Button from our layout specification using findViewById().
- Initialize and start our alarm in go() method.
 */
public class MainActivity extends AppCompatActivity {

    Button startBtn;
    EditText timeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         initializeViews();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    /*
    INITIALIZE VIEWS
     */
    private void initializeViews()
    {
        timeTxt= (EditText) findViewById(R.id.timeTxt);
        startBtn= (Button) findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               go();
            }
        });
    }

    /*
    INITIALIZE AND START OUR ALARM
     */
    private void go()
    {
        //GET TIME IN SECONDS AND INITIALIZE INTENT
        int time=Integer.parseInt(timeTxt.getText().toString());
        Intent i=new Intent(this,MyReceiver.class);

        //PASS CONTEXT,YOUR PRIVATE REQUEST CODE,INTENT OBJECT AND FLAG
        PendingIntent pi=PendingIntent.getBroadcast(this,0,i,0);

        //INITIALIZE ALARM MANAGER
        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);

        //SET THE ALARM
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(time*1000),pi);
        Toast.makeText(MainActivity.this, "Alarm set in "+time+" seconds", Toast.LENGTH_SHORT).show();
    }


}
