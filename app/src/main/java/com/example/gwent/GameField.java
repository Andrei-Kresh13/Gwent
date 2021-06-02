package com.example.gwent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class GameField extends AppCompatActivity{
    ImageView card1_player, card2_player, card3_player, card4_player, card5_player,card_opponent1,card_opponent2,card_opponent3,card_opponent4,card_opponent5;
    Button start_game;
    TextView points1,points2;
    private TextView nickname1, nickname2;

        Card card1 = new Card("Колдун", 6);
        Card card2= new Card("Оборотень", 5);
        Card card3 = new Card("Пустынный червь", 7);
        Card card4 = new Card("Голем", 7);
        Card card5 = (new Card("Требушет", 6));
        Card card6 =(new Card("Всадник", 5));
        Card card7=(new Card("Арбалетчик", 3));
        Card card8 = (new Card("Нефтяной разведчик", 3));
        Card card9=(new Card("Друид старец", 5));
        Card card10=(new Card("Колдовской ворон", 4));
        Card card11=(new Card("Дух", 4));
        Card card12=(new Card("Эльф-Лучник", 4));
        Card card13=(new Card("Ящеролюд-воин", 5));
        Card card14=(new Card("Ассасин ордена", 4));
        Card card15=(new Card("Цветолиск", 7));
        Card card16=(new Card("Костяной лучник", 3));
        Card card17=(new Card("Гидра", 7));
        Card card18=(new Card("Костяной рекрут", 2));
        Card card19=(new Card("Темный пехотенец", 3));
        Card card20=(new Card("Скелет-маг", 6));
        Card card21=(new Card("Гаргулья", 4));

        Card[] cards = new Card[]{card1, card2, card3,card4,card5,card6,card7,card8,card9,card10,card11,card12,card13,card14,card15, card16,card17,card18,card19,card20,card21};



    int score1 = 0,score2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);

        nickname1 = findViewById(R.id.name1);
        nickname2 = findViewById(R.id.name2);
        nickname1.setText(getIntent().getStringExtra("nickname1"));
        nickname2.setText(getIntent().getStringExtra("nickname2"));



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

        card1_player = findViewById(R.id.card1);
        card2_player = findViewById(R.id.card2);
        card3_player = findViewById(R.id.card3);
        card4_player = findViewById(R.id.card4);
        card5_player = findViewById(R.id.card5);


        points1 =(TextView) findViewById(R.id.points1);
        points2 =(TextView) findViewById(R.id.points2);

        /*cards = new ArrayList<>();
        cards.add(100);
        cards.add(101);
        cards.add(102);
        cards.add(103);
        cards.add(104);


        cards.add(200);
        cards.add(201);
        cards.add(202);
        cards.add(203);
        cards.add(204);
        cards.add(205);
        cards.add(206);
        cards.add(207);

        cards.add(300);
        cards.add(301);
        cards.add(302);
        cards.add(303);
        cards.add(304);*/


        start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Collections.shuffle(cards);

                assinImages(cards.get(0), card1_player);
                assinImages(cards.get(1), card2_player);
                assinImages(cards.get(2), card3_player);
                assinImages(cards.get(3), card4_player);
                assinImages(cards.get(4), card5_player);*/

                card1_player.setVisibility(View.VISIBLE);
                card2_player.setVisibility(View.VISIBLE);
                card3_player.setVisibility(View.VISIBLE);
                card4_player.setVisibility(View.VISIBLE);
                card5_player.setVisibility(View.VISIBLE);

                /*assinImages(cards.get(5), card_opponent1);
                assinImages(cards.get(6), card_opponent2);
                assinImages(cards.get(7), card_opponent3);
                assinImages(cards.get(8), card_opponent4);
                assinImages(cards.get(9), card_opponent5);

                card_opponent1.setVisibility(View.VISIBLE);
                card_opponent2.setVisibility(View.VISIBLE);
                card_opponent3.setVisibility(View.VISIBLE);
                card_opponent4.setVisibility(View.VISIBLE);
                card_opponent5.setVisibility(View.VISIBLE);*/
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
            case 200:
                image.setImageResource(R.drawable.cardwildness1);
                break;
            case 201:
                image.setImageResource(R.drawable.cardwildness2);
                break;
            case 202:
                image.setImageResource(R.drawable.cardwildness3);
                break;
            case 203:
                image.setImageResource(R.drawable.cardwildness4);
                break;
            case 204:
                image.setImageResource(R.drawable.cardwildness5);
                break;
            case 205:
                image.setImageResource(R.drawable.cardwildness6);
                break;
            case 206:
                image.setImageResource(R.drawable.cardwildness7);
                break;
            case 300:
                image.setImageResource(R.drawable.carddeath);
                break;
            case 301:
                image.setImageResource(R.drawable.carddeath2);
                break;
            case 302:
                image.setImageResource(R.drawable.carddeath3);
                break;
            case 303:
                image.setImageResource(R.drawable.carddeath4);
                break;
            case 304:
                image.setImageResource(R.drawable.carddeath5);
                break;
        }

    }


}