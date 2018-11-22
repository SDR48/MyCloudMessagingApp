package com.myapps.sdr.mycloudmessagingapp;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.app.NotificationCompat;

public class NotificationManager {
    private Context context;
    private static NotificationManager notificationManager;
    private NotificationManager(Context context)
    {
        this.context=context;
    }
    public static synchronized NotificationManager getInstance(Context context)
    {
        if(notificationManager==null)
        {
            notificationManager = new NotificationManager(context);
        }
        return notificationManager;
    }
    public void displaynotification(String title, String text){
        android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(context,constants.channelId)
                .setSmallIcon(R.drawable.ic_launcher_web).setContentTitle(title).setContentText(text);
        Intent intent = new Intent(context,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(notificationManager!=null)
        {
            notificationManager.notify(1,builder.build());
        }
    }
}
