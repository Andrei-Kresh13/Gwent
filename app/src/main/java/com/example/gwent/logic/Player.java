package com.example.gwent.logic;


public class Player {

    private String name;
    private Hand hand;


    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return this.name;
    }


}