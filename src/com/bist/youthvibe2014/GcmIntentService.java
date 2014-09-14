package com.bist.youthvibe2014;

import java.util.HashSet;
import java.util.Set;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

public class GcmIntentService extends IntentService {
    public static final int NOTIFICATION_ID;

    static {
        NOTIFICATION_ID = 1;
    }

    private static final String TAG = "GcmIntentService";
    // @SuppressWarnings("FieldCanBeLocal")
    private NotificationManager mNotificationManager;
    // @SuppressWarnings("UnusedDeclaration")
    NotificationCompat.Builder builder;

    public GcmIntentService() {
        super("GcmIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);

        if (!extras.isEmpty()) {  // has effect of unparcelling Bundle
            /*
             * Filter messages based on message type. Since it is likely that GCM
             * will be extended in the future with new message types, just ignore
             * any message types you're not interested in, or that you don't
             * recognize.
             */
            if (GoogleCloudMessaging.
                    MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
                sendNotification("Send error: " + extras.toString());
            } else if (GoogleCloudMessaging.
                    MESSAGE_TYPE_DELETED.equals(messageType)) {
                sendNotification("Deleted messages on server: " +
                        extras.toString());
                // If it's a regular GCM message, do some work.
            } else if (GoogleCloudMessaging.
                    MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                // This loop represents the service doing some work.
                /*for (int i=0; i<5; i++) {
                    Log.i(TAG, "Working... " + (i + 1)
                            + "/5 @ " + SystemClock.elapsedRealtime());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) ;{
                    }
                }*/
                // Log.i(TAG, "Completed work @ " + SystemClock.elapsedRealtime());
            	
            	// Storing the messsage first.
                SharedPreferences settings = this.getSharedPreferences(MainActivity.class.getSimpleName(), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                // Get the list
                Set<String> notifications = settings.getStringSet("Notifications", null);
                Set<String> newNotifications = new HashSet<String>();
                String newNotice = "Title : " + extras.getString("title") + "\nMessage : " + extras.getString("message");
                if(newNotice != "") {
                    if(notifications != null) {
                        for(String notice: notifications) {
                            newNotifications.add(notice);
                        }
                    }
                    newNotifications.add(newNotice);
                    editor.putStringSet("Notifications", newNotifications);
                    editor.apply();
                }
            	
                // Post notification of received message.
                sendNotification("Title : " + extras.getString("title") + "\nMessage : " + extras.getString("message"));
                // sendNotification("Received: " + extras.toString());
                Log.i(TAG, "Received: " + extras.toString());
            }
        }
        // Release the wake lock provided by the WakefulBroadcastReceiver.
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    // Put the message into a notification and post it.
    // This is just one simple example of what you might choose to do with
    // a GCM message.
    private void sendNotification(String msg) {
        mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);
        // Have to change this to make the notifications go to MainActivity
        Intent goingIntent = new Intent(this, FacebookLoginActivity.class);
        Bundle noticeInfo = new Bundle();
        noticeInfo.putString("newNotices", "YES");
        goingIntent.putExtras(noticeInfo);

        goingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        // PendingIntent contentIntent = PendingIntent.getActivity(this, 0, goingIntent, 0);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, goingIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("GCM Notification")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}