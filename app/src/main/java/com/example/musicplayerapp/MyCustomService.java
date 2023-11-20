package com.example.musicplayerapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MyCustomService extends Service {
    // Use Alt+enter on Service and implement class and then onBind()

    private MediaPlayer player; // This class will help to run Audio and Video
    //As per Service Lifecycle we first need to create onCreate() to start Service
    //But we can directly called from start
    //for that we use onCStart


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Default ringtone will bw played
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        // We have to play in loop
        player.setLooping(true);
        player.start();

        // We need to provide return type b/c of int
//        so we use start sticky

        return START_STICKY;
//        It return an integer that specify how system handle service after it has been started
//        it indicate that service should be started if terminated by system
//        Use this return type if service perform periodic task such as background data synchronization
//        Where u want to ensure that the service resume operation after being temporarily killed
    }


    @Override
    public void onDestroy() {

        player.stop();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
// It is a type of service which allows other components usually activities to bind to it and interact with it by obtaining an Binder Interface
//  IBinder interface is used to establish a communication channel between component and service .
    }

}
