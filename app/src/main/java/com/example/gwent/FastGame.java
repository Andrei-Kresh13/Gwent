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

    private int player1HandNewValue;
    private ArrayList<Card> player1Hand;
    private ArrayList<String> hand1Details;
    private String player1CardDetails;
    private String player1EachIcon;
    private ArrayList<String> Player1AllIcons;

    private Suit player2DealtCardSuit;
    private Rank player2DealtCardRank;

    private int player2HandNewValue;
    private ArrayList<Card> player2Hand;
    private ArrayList<String> hand2Details;
    private String player2CardDetails;
    private String player2EachIcon;
    private ArrayList<String> Player2AllIcons;

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

        textResult = findViewById(R.id.textResult);
    }

    public void onFirstPlayerClick(View view){
        hand1Details = new ArrayList<>();
        Player1AllIcons = new ArrayList<>();

        ArrayList<ImageView> player1CardIconImageViews = new ArrayList<>();
        player1CardIconImageViews.add(player1CardImage);

        int imageViewIndex = 0;

        if(player1Hand != null && player1Hand.size() == 1) return;

        player1Hand = game.dealPlayer1Card();
        player1DealtCardRank = game.getplayer1DealtCardRank();
        player1DealtCardSuit = game.getplayer1DealtCardSuit();

        for (Card card:player1Hand) {
            Suit suit = card.getSuit();
            Rank rank = card.getRank();


            player1CardDetails = rank + " of " + suit;
            player1EachIcon = card.getCardIcon(player1CardDetails);

            setCardImage(player1EachIcon, player1CardIconImageViews.get(imageViewIndex));
            imageViewIndex++;

            Player1AllIcons.add(player1EachIcon);
            hand1Details.add(player1CardDetails);
        }
        for (String player1Card: hand1Details) {
            System.out.println("Player 1 card in hand is: "+player1Card);
        }

    }

    public void onSecondPlayerClick(View view){
        hand2Details = new ArrayList<String>();
        Player2AllIcons = new ArrayList<String>();

        ArrayList<ImageView> player2CardIconImageViews = new ArrayList<>();
        player2CardIconImageViews.add(player2CardImage);
        int ImageIndex = 0;

        if(player2Hand != null && player2Hand.size() == 4) return;

        player2Hand = game.dealPlayer2Card();
        player2DealtCardRank = game.getplayer2DealtCardRank();
        player2DealtCardSuit = game.getplayer2DealtCardSuit();

        for (Card card:player2Hand) {
            Suit suit = card.getSuit();
            Rank rank = card.getRank();

            player2CardDetails = rank + " of " + suit;
            player2EachIcon = card.getCardIcon(player2CardDetails);

            setCardImage(player2EachIcon, player2CardIconImageViews.get(ImageIndex));
            ImageIndex++;

            Player2AllIcons.add(player2EachIcon);
            hand2Details.add(player2CardDetails);
        }
    }

    public void onResultClick(View view){
        player1HandNewValue = game.getPlayer1HandNewValue();
        player2HandNewValue = game.getPlayer2HandNewValue();
        String outcome = game.getResult(player1HandNewValue, player2HandNewValue);
        textResult.setText(outcome);
    }

    public void setCardImage(String card, ImageView imageView) {
        int image = getResources().getIdentifier(card, "drawable", getPackageName());
        imageView.setImageResource(image);
    }
}