package com.thepoosh.activityflags;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                Notification notification = new Notification.Builder(Main3Activity.this)
                                                    .setContentText("text")
                                                    .setContentIntent(
                                                            PendingIntent.getActivity(
                                                                    getApplicationContext(),
                                                                    42,
                                                                    intent,
                                                                    PendingIntent.FLAG_UPDATE_CURRENT)
                                                            )
                                                    .setContentTitle("title")
                                                    .setSmallIcon(R.mipmap.ic_launcher)
                                                    .build();

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(1234, notification);

            }
        });
    }
}
