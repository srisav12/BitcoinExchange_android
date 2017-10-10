package com.bitcoinexchange.splash_screen.splash_screen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bitcoinexchange.R;
import com.bitcoinexchange.splash_screen.utils.Utilities;
import com.bitcoinexchange.splash_screen.welcome_screen.WelcomeScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utilities.setStatusBarGradiant(SplashScreen.this);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, WelcomeScreen.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
