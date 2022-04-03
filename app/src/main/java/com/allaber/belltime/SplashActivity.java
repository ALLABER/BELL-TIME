package com.allaber.belltime;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.startActivity(getIntentActivity());
        this.finishAffinity();
    }

    private Intent getIntentActivity() {
        return new Intent(this, MainActivity.class);
    }
}