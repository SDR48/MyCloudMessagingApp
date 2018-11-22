package com.myapps.sdr.mycloudmessagingapp;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessaging extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
String title = remoteMessage.getNotification().getTitle();
String body = remoteMessage.getNotification().getBody();
NotificationManager.getInstance(getApplicationContext()).displaynotification(title,body);
    }
}
