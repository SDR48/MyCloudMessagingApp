package com.myapps.sdr.mycloudmessagingapp;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createchannel();
        spinner=findViewById(R.id.spinner);
findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String topic = spinner.getSelectedItem().toString();
        FirebaseMessaging.getInstance().subscribeToTopic(topic);
        Toast.makeText(MainActivity.this,"Successfully subscribed to topic",Toast.LENGTH_SHORT).show();

    }
});

    }
    private void createchannel(){
        if(Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.O)
        {
            android.app.NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel = new NotificationChannel(constants.channelId,constants.channelname, android.app.NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription(constants.channeldesc);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[] {100,200,300,400,500,400,300,200,400});
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }
}
