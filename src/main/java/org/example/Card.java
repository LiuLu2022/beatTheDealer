package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Card {
    private static final String[] SUITS = {"C", "D", "H", "S"};
    private static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    ArrayList<String> deck;

    public void setDeck(ArrayList<String> deck) {
        this.deck = deck;
    }

    public ArrayList<String> getDeck() {
        return deck;
    }

    public ArrayList<String> readDeckFromFile(String filename) {
        deck = new ArrayList<>();

        try {
            Scanner scanner = filename != null ? new Scanner(new File(filename)) : null;
            scanner.useDelimiter(", ");
            while (scanner.hasNext()) {
                deck.add(scanner.next());
            }

            if (deck.size() != 52) {
                throw new IllegalArgumentException("Deck must contain exactly 52 cards");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            System.exit(1);
        }
        System.out.print(deck);
        System.out.print("\n");
        return deck;
    }

    public ArrayList<String> initialShuffledDeck() {
        deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String value : VALUES) {
                deck.add(suit + value);
            }
        }
        Collections.shuffle(deck);
        System.out.print(deck);
        System.out.print("\n");
        return deck;
    }

    public String removeCard(ArrayList<String> deck) {
        if (deck.isEmpty()) {
            throw new IllegalStateException("No more cards in the deck");
        }
        return deck.remove(0);
    }

    public static int getCardValue(String card) {
        char rank = card.charAt(1);
        if (rank == 'A') {
            return 11;
        } else if (rank == '1' || rank == 'J' || rank == 'Q' || rank == 'K') {
            return 10;
        } else {
            return Integer.parseInt(String.valueOf(rank));
        }
    }

}
