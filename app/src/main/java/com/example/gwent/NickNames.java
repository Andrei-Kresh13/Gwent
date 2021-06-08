package com.example.gwent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NickNames extends AppCompatActivity implements View.OnClickListener{
    private TextView name1;
    private TextView name2;

    private TextView if1;
    private TextView if2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick_names);

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
    }

    @Override
    public void onClick(View view){
        name1 = findViewById(R.id.nickname1);
        name2 = findViewById(R.id.nickname2);

        if1 = findViewById(R.id.setIfPlayer1);
        if2 = findViewById(R.id.setIfPlayer2);

        String nickname1 = name1.getText().toString();
        String nickname2 = name2.getText().toString();

        String ifwinner1 = if1.getText().toString();
        String ifwinner2 = if2.getText().toString();

        Intent intent = new Intent(this, GameField.class);
        intent.putExtra("nickname1", nickname1);
        intent.putExtra("nickname2", nickname2);
        intent.putExtra("if1", ifwinner1);
        intent.putExtra("if2", ifwinner2);

        startActivity(intent);

        }
    }
