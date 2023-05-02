package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int score = 0;
    List<Card> cardsInHand = new ArrayList<>();

    public void addCard(Card card){
        cardsInHand.add(card);
        score += card.getCardValue();
    }
    public static void printResult(String name, List<String> cardsInHand) {
        System.out.println(name + String.join(", ", cardsInHand));
    }
}
