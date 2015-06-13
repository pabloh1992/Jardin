package com.pablohenao.jardin;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;


public class SplashScreen extends Activity {
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //     setContentView(R.layout.splash);
        setContentView(R.layout.activity_splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent i = new Intent("com.pablohenao.jardin.MAINACTIVITY");
                    startActivity(i);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
*/


    private static final long SPLASH_DELAY = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent().setClass(SplashScreen.this, ItemListActivity.class);
                startActivity(mainIntent);
                finish();
            }
        };

        Timer timer= new Timer();
        timer.schedule(task, SPLASH_DELAY);
    }


}
