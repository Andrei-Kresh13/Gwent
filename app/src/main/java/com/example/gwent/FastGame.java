package com.example.gwent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gwent.logic.Card;
import com.example.gwent.logic.Game;
import com.example.gwent.logic.Hand;
import com.example.gwent.logic.Player;
import com.example.gwent.logic.Rank;
import com.example.gwent.logic.Suit;

import java.util.ArrayList;

public class FastGame extends AppCompatActivity {
    Hand hand1 = new Hand();
    Hand hand2 = new Hand();

    Player player1 = new Player("Player1", hand1);
    Player player2 = new Player("Player2", hand2);

    Game game = new Game(player1, player2);

    private Suit player1DealtCardSuit;
    private Rank player1DealtCardRank;

    private int player1HandValue;
    private ArrayList<Card> player1Hand;
    private ArrayList<String> hand1Details;
    private String player1CardDetails;
    private String player1EveryImage;
    private ArrayList<String> Player1AllImages;

    private Suit player2DealtCardSuit;
    private Rank player2DealtCardRank;

    private int player2HandValue;
    private ArrayList<Card> player2Hand;
    private ArrayList<String> hand2Details;
    private String player2CardDetails;
    private String player2EachImage;
    private ArrayList<String> Player2AllImages;

    TextView textResult;

    ImageView player1CardImage;
    ImageView player2CardImage;

    Button btnFirst;
    Button btnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_game);

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

        player1CardImage = findViewById(R.id.player1Card);
        player2CardImage = findViewById(R.id.player2Card);

        btnFirst = findViewById(R.id.firstPlayer);
        btnSecond = findViewById(R.id.secondPlayer);

        textResult = findViewById(R.id.textResultOfFastGame);
    }

    public void onPlayer1Click(View view){
        hand1Details = new ArrayList<>();
        Player1AllImages = new ArrayList<>();

        ArrayList<ImageView> player1CardIconImageViews = new ArrayList<>();
        player1CardIconImageViews.add(player1CardImage);

        int Index = 0;

        if(player1Hand != null && player1Hand.size() == 1) return;

        player1Hand = game.generatePlayer1Card();
        player1DealtCardRank = game.getplayer1DealtCardRank();
        player1DealtCardSuit = game.getplayer1DealtCardSuit();

        for (Card card:player1Hand) {
            Suit suit = card.getSuit();
            Rank rank = card.getRank();


            player1CardDetails = rank + " of " + suit;
            player1EveryImage = card.getCardImage(player1CardDetails);

            setCardImage(player1EveryImage, player1CardIconImageViews.get(Index));
            Index++;

            Player1AllImages.add(player1EveryImage);
            hand1Details.add(player1CardDetails);
        }
        for (String player1Card: hand1Details) {
            System.out.println("Player 1 card in hand is: "+player1Card);
        }

    }

    public void onPlayer2Click(View view){
        hand2Details = new ArrayList<>();
        Player2AllImages = new ArrayList<>();

        ArrayList<ImageView> player2CardIconImageViews = new ArrayList<>();
        player2CardIconImageViews.add(player2CardImage);
        int Index = 0;

        if(player2Hand != null && player2Hand.size() == 1) return;

        player2Hand = game.generatePlayer2Card();
        player2DealtCardRank = game.getplayer2DealtCardRank();
        player2DealtCardSuit = game.getplayer2DealtCardSuit();

        for (Card card:player2Hand) {
            Suit suit = card.getSuit();
            Rank rank = card.getRank();

            player2CardDetails = rank + " of " + suit;
            player2EachImage = card.getCardImage(player2CardDetails);

            setCardImage(player2EachImage, player2CardIconImageViews.get(Index));
            Index++;

            Player2AllImages.add(player2EachImage);
            hand2Details.add(player2CardDetails);
        }
    }

    public void onResClick(View view){
        player1HandValue = game.getPlayer1HandValue();
        player2HandValue = game.getPlayer2HandValue();
        String outcome = game.getResult(player1HandValue, player2HandValue);
        textResult.setText(outcome);
    }

    public void setCardImage(String card, ImageView imageView) {
        int image = getResources().getIdentifier(card, "drawable", getPackageName());
        imageView.setImageResource(image);
    }
}