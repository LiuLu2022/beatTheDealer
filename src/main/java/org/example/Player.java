package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private int score;
    private List<String> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        score = 0;
    }

    public void addCard(String card) {
        hand.add(card);
        score += Card.getCardValue(card);
    }

    public String getName() {
        return name;
    }

    public List<String> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }
}
