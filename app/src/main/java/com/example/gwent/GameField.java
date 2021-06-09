package com.example.gwent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gwent.logic.Card;
import com.example.gwent.logic.Game;
import com.example.gwent.logic.Hand;
import com.example.gwent.logic.Player;
import com.example.gwent.logic.Rank;
import com.example.gwent.logic.Suit;

import java.util.ArrayList;

public class GameField extends AppCompatActivity {
    private TextView nickname1, nickname2;
    private TextView if1, if2;
    Hand hand1 = new Hand();
    Hand hand2 = new Hand();
    Player player1 = new Player("Player1", hand1);
    Player player2 = new Player("Player2", hand2);

    Game game = new Game(player1, player2);

    private Suit player1Dealtcard;
    private Rank player1Dealtcardrank;

    private int player1Handnewvalue;
    private ArrayList<Card> player1Hand;
    private ArrayList<String> hand1Det;
    private String player1CardsDet;
    private String player1EveryImage;
    private ArrayList<String> Player1AllImages;

    private Suit player2DealtCardSuit;
    private Rank player2DealtCardRank;

    private int player2Handnewvalue;
    private ArrayList<Card> player2Hand;
    private ArrayList<String> hands2details;
    private String player2cardsdetails;
    private String player2EveryImages;
    private ArrayList<String> Player2AllImages;

    TextView textPlayer1LatestCard;
    TextView textPlayer2LatestCard;
    TextView textResOfGame;


    ImageView player1CardOneImage;
    ImageView player1CardTwoImage;
    ImageView player1CardThreeImage;
    ImageView player1CardFourImage;

    ImageView player2CardOneImage;
    ImageView player2CardTwoImage;
    ImageView player2CardThreeImage;
    ImageView player2CardFourImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);

        nickname1 = findViewById(R.id.name1);
        nickname2 = findViewById(R.id.name2);
        nickname1.setText(getIntent().getStringExtra("nickname1"));
        nickname2.setText(getIntent().getStringExtra("nickname2"));

        if1 = findViewById(R.id.ifPlayer1);
        if2 = findViewById(R.id.ifPlayer2);
        if1.setText(getIntent().getStringExtra("if1"));
        if2.setText(getIntent().getStringExtra("if2"));


        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
        player1CardOneImage = (ImageView) findViewById(R.id.player1FirstCard);
        player1CardTwoImage = (ImageView) findViewById(R.id.player1SecondCard);
        player1CardThreeImage = (ImageView) findViewById(R.id.player1ThirdCard);
        player1CardFourImage = (ImageView) findViewById(R.id.player1FourthCard);


        player2CardOneImage = (ImageView) findViewById(R.id.player2FirstCard);
        player2CardTwoImage = (ImageView) findViewById(R.id.player2SecondCard);
        player2CardThreeImage = (ImageView) findViewById(R.id.player2ThirdCard);
        player2CardFourImage = (ImageView) findViewById(R.id.player2FourthCard);

        textResOfGame = (TextView) findViewById(R.id.textResult);
    }


    public void onPlayerclick(View view) {
        hand1Det = new ArrayList<>();
        Player1AllImages = new ArrayList<>();

        ArrayList<ImageView> player1CardImages = new ArrayList<>();
        player1CardImages.add(player1CardOneImage);
        player1CardImages.add(player1CardTwoImage);
        player1CardImages.add(player1CardThreeImage);
        player1CardImages.add(player1CardFourImage);

        int index = 0;

        if(player1Hand != null && player1Hand.size() == 4) return;

        player1Hand = game.generatePlayer1Card();
        player1Dealtcardrank = game.getplayer1DealtCardRank();
        player1Dealtcard = game.getplayer1DealtCardSuit();

        for (Card card:player1Hand) {
            Suit suit = card.getSuit();
            Rank rank = card.getRank();


            player1CardsDet = rank + " of " + suit;
            player1EveryImage = card.getCardImage(player1CardsDet);

            setcardimage(player1EveryImage, player1CardImages.get(index));
            index++;

            Player1AllImages.add(player1EveryImage);
            hand1Det.add(player1CardsDet);
        }
        for (String player1Card: hand1Det) {
            System.out.println("Player 1 card in hand is: "+ player1Card);
        }
    }

    public void onPlayer2Click(View view) {
        hands2details = new ArrayList<String>();
        Player2AllImages = new ArrayList<String>();

        ArrayList<ImageView> player2CardImages = new ArrayList<>();
        player2CardImages.add(player2CardOneImage);
        player2CardImages.add(player2CardTwoImage);
        player2CardImages.add(player2CardThreeImage);
        player2CardImages.add(player2CardFourImage);

        int index = 0;

        if(player2Hand != null && player2Hand.size() == 4) return;

        player2Hand = game.generatePlayer2Card();
        player2DealtCardRank = game.getplayer2DealtCardRank();
        player2DealtCardSuit = game.getplayer2DealtCardSuit();

        for (Card card:player2Hand) {
            Suit suit = card.getSuit();
            Rank rank = card.getRank();

            player2cardsdetails = rank + " of " + suit;
            player2EveryImages = card.getCardImage(player2cardsdetails);

            setcardimage(player2EveryImages, player2CardImages.get(index));
            index++;

            Player2AllImages.add(player2EveryImages);
            hands2details.add(player2cardsdetails);
        }
    }

    public void onResultClick(View view) {
        player1Handnewvalue = game.getPlayer1HandValue();
        player2Handnewvalue = game.getPlayer2HandValue();
        String result = game.getResult(player1Handnewvalue, player2Handnewvalue);
        textResOfGame.setText(result);

    }

    public void setcardimage(String card, ImageView imageView) {
        int image = getResources().getIdentifier(card, "drawable", getPackageName());
        imageView.setImageResource(image);
    }
}


