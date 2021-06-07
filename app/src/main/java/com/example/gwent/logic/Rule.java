package com.example.gwent.logic;


public class Rule {

    private String rank;
    private int value;



    public Rule() {

    }


    public Rule(String rank) {
        this.rank = rank;
        this.value = value;
    }


    public int getValueFromRank(String rank) {
        switch(rank) {
            case "ONE":
                value = 1;
                break;
            case "TWO":
                value = 2;
                break;
            case "THREE":
                value = 3;
                break;
            case "FOUR":
                value = 4;
                break;
            case "FIVE":
                value = 5;
                break;
            case "SIX":
                value = 6;
                break;
            case "SEVEN":
                value = 7;
                break;
        }
        return value;
    }

    public String getResult(int player1HandNewValue, int player2HandNewValue) {
        if (player1HandNewValue > player2HandNewValue) {
            return "Player1";
        } else if (player2HandNewValue > player1HandNewValue) {
            return "Player2";
        } else {
            return "Game Drawn";
        }
    }

}