package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    private static final String[] SUITS = {"C", "D", "H", "S"};
    private static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private static ArrayList<String> readDeckFromFile(String filename) {
        ArrayList<String> deck = new ArrayList<String>();

        try {
            Scanner scanner = filename != null ? new Scanner(new File(filename)) : null;
            scanner.useDelimiter(", ");
            while (scanner != null && scanner.hasNext()) {
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

    public static ArrayList<String> initialShuffledDeck() {
        ArrayList<String> deck = new ArrayList<String>();
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

     public Card dealCard(){
         if (cards.isEmpty()) {
             throw new IllegalStateException("No more cards in the deck");
         }
         return cards.remove(0);
     }

    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
