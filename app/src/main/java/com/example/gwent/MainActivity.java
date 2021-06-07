package com.example.gwent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.gwent.Colods.Colods;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //@RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getSupportActionBar().hide;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    Button button = findViewById(R.id.game);
        button.setOnClickListener(this);
        Button button2 = findViewById(R.id.colods);
        button2.setOnClickListener(this);
        Button button1 = findViewById(R.id.fastGame);
        button1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        switch (btn.getId()) {
            case R.id.game:
                Intent intent = new Intent(this, NickNames.class);
                startActivity(intent);
                break;
            case R.id.fastGame:
                Intent intent2 = new Intent(this, FastGame.class);
                startActivity(intent2);
                break;
            case R.id.colods:
                 Intent intent1 = new Intent(this, Colods.class);
                 startActivity(intent1);
                 break;

        }
    }

}