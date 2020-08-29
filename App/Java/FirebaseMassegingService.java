package com.xploreict.simofferbd;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;


/**
 * Created by YoYo on 1/3/2017.
 */
public class FirebaseMassegingService extends FirebaseMessagingService {

    String message, title, message_ussd;


    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent = new Intent(this, MainActivity.class);
        if (remoteMessage.getData().size() > 0) {
            message = remoteMessage.getData().get("messages");
            title = remoteMessage.getData().get("title");
            message_ussd = remoteMessage.getData().get("message_ussd");
            Bundle bundle = new Bundle();
            bundle.putString("messages", message);
            bundle.putString("title", title);
            bundle.putString("message_ussd", message_ussd);
            intent.putExtras(bundle);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
            final NotificationCompat.Builder notificationCompact = new NotificationCompat.Builder(this);
            notificationCompact.setContentTitle("BD All Sim Offer");
            notificationCompact.setContentText(remoteMessage.getNotification().getBody());
            notificationCompact.setAutoCancel(true);
            notificationCompact.setSmallIcon(R.drawable.notificaton);
            notificationCompact.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
            notificationCompact.setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.app));
            notificationCompact.setSound(Uri.parse("uri://sadfasdfasdf.mp3"));
//            Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            notificationCompact.setSound(sound);
            notificationCompact.setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationCompact.build());
        }

    }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
    }

}
