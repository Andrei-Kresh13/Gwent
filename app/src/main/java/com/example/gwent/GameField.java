package com.example.gwent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameField extends AppCompatActivity{
    ImageView card1,card2,card3,card4,card5,card_opponent1,card_opponent2,card_opponent3,card_opponent4,card_opponent5;
    Button start_game;
    TextView points1,points2;

    ArrayList<Integer> cards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);

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

        start_game = findViewById(R.id.start_game);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);

        card_opponent1 = findViewById(R.id.card_opponent1);
        card_opponent2 = findViewById(R.id.card_opponent2);
        card_opponent3 = findViewById(R.id.card_opponent3);
        card_opponent4 = findViewById(R.id.card_opponent4);
        card_opponent5 = findViewById(R.id.card_opponent5);

        points1 = findViewById(R.id.points1);
        points2 = findViewById(R.id.points2);

        cards = new ArrayList<>();
        cards.add(100);
        cards.add(101);
        cards.add(102);
        cards.add(103);
        cards.add(104);
        cards.add(105);
        cards.add(107);
        cards.add(108);
        cards.add(109);
        cards.add(110);
        cards.add(111);
        cards.add(112);
        cards.add(113);
        cards.add(114);
        cards.add(115);

        cards.add(200);
        cards.add(201);
        cards.add(202);
        cards.add(203);
        cards.add(204);
        cards.add(205);
        cards.add(206);
        cards.add(207);
        cards.add(208);
        cards.add(209);
        cards.add(210);
        cards.add(211);
        cards.add(212);
        cards.add(213);
        cards.add(214);
        cards.add(215);

        cards.add(300);
        cards.add(301);
        cards.add(302);
        cards.add(303);
        cards.add(304);
        cards.add(305);
        cards.add(306);
        cards.add(307);
        cards.add(308);
        cards.add(309);
        cards.add(310);
        cards.add(311);
        cards.add(312);
        cards.add(313);
        cards.add(314);
        cards.add(315);

        start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(cards);

                assinImages(cards.get(0), card1);
                assinImages(cards.get(1), card2);
                assinImages(cards.get(2), card3);
                assinImages(cards.get(3), card4);
                assinImages(cards.get(4), card5);

                card1.setVisibility(View.VISIBLE);
                card2.setVisibility(View.VISIBLE);
                card3.setVisibility(View.VISIBLE);
                card4.setVisibility(View.VISIBLE);
                card5.setVisibility(View.VISIBLE);

                assinImages(cards.get(5), card_opponent1);
                assinImages(cards.get(6), card_opponent2);
                assinImages(cards.get(7), card_opponent3);
                assinImages(cards.get(8), card_opponent4);
                assinImages(cards.get(9), card_opponent5);

                card_opponent1.setVisibility(View.VISIBLE);
                card_opponent2.setVisibility(View.VISIBLE);
                card_opponent3.setVisibility(View.VISIBLE);
                card_opponent4.setVisibility(View.VISIBLE);
                card_opponent5.setVisibility(View.VISIBLE);
            }
        });
    }

    public void assinImages(int card, ImageView image){
        switch (card){
            case 100:
                image.setImageResource(R.drawable.cardhuman1);
                break;
            case 101:
                image.setImageResource(R.drawable.cardhuman2);
                break;
            case 102:
                image.setImageResource(R.drawable.cardhuman3);
                break;
            case 103:
                image.setImageResource(R.drawable.cardhuman4);
                break;
            case 104:
                image.setImageResource(R.drawable.cardhuman5);
                break;
            case 105:
                image.setImageResource(R.drawable.cardhuman6);
                break;
            case 200:
                image.setImageResource(R.drawable.cardnature1);
                break;
        }

    }


    public  class GameView extends View {
        ConstraintLayout layout =(ConstraintLayout) findViewById(R.id.c_layout);
        @SuppressLint("ResourceType")
        ImageView cardhuman1 = findViewById(R.drawable.cardhuman1);
        @SuppressLint("ResourceType")
        ImageView cardnature1 = findViewById(R.drawable.cardnature1);
        @SuppressLint("ResourceType")
        ImageView cardhuman2 = findViewById(R.drawable.cardhuman2);
        @SuppressLint("ResourceType")
        ImageView cardhuman3 = findViewById(R.drawable.cardhuman3);
        @SuppressLint("ResourceType")
        ImageView cardhuman4 = findViewById(R.drawable.cardhuman4);
        @SuppressLint("ResourceType")
        ImageView cardhuman5 = findViewById(R.drawable.cardhuman5);
        @SuppressLint("ResourceType")
        ImageView cardhuman6 = findViewById(R.drawable.cardhuman6);

       ImageView[] colods=new ImageView[]{cardhuman1, cardnature1,cardhuman2,cardhuman3,cardhuman4,cardhuman5,cardhuman6};
        Random random = new Random();



        public GameView(Context context) {
            super(context);
        }
        private int viewWidth,viewHeight;
        private int EnemyPoints = 0;
        private int MyPoints = 0;

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            viewWidth = w;
            viewHeight = h;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawARGB(250, 127, 199, 255); // заливаем цветом
            Paint p = new Paint();
            p.setAntiAlias(true);
            p.setTextSize(55.0f);
            p.setColor(Color.WHITE);
            canvas.drawText(EnemyPoints +"", viewWidth - 100, 70, p);
            canvas.drawText(MyPoints +"", viewWidth - 100, 700,p);
            //firstCard.draw(canvas);
        }


    }


}