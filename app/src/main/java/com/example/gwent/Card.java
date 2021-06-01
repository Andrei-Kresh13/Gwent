package com.example.gwent;

public class Card {
    public Card(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }

    private String name;
    private int attack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' + "attack= " + attack+'\''+
                '}';
    }


}
