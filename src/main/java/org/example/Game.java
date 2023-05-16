package org.example;

public class Game {
    private static final int BLACKJACK = 21;
    private static final int MIN_SCORE = 17;

    public void dealInitialCards(Player sam, Player dealer, Card card) {
        Player currentPlayer;
        for (int i = 0; i < 4; i++) {
            currentPlayer = i % 2 == 0 ? sam : dealer;
            currentPlayer.addCard(card.removeCard(card.getDeck()));
        }
    }

    public String checkInitialCards(Player sam, Player dealer) {
        if (sam.getScore() == BLACKJACK) {
            //If Sam gets 21, whatever dealer gets, it is Sam win.
            return sam.getName();
        } else if (dealer.getScore() == BLACKJACK || sam.getScore() > BLACKJACK) {
            //If Sam gets 22,whatever dealer gets,dealer wins; or only dealer gets 21, dealer wins.
            return dealer.getName();
        } else if (dealer.getScore() > BLACKJACK) {
            //If only Dealer gets 22,Sam wins.
            return sam.getName();
        }
        return null;
    }

    public String samTurn(Player sam, Player dealer, Card card) {
        while (sam.getScore() < MIN_SCORE) {
            sam.addCard(card.removeCard(card.getDeck()));
            if (sam.getScore() > BLACKJACK) {
                return dealer.getName();
            }
        }
        return null;
    }

    public String dealerTurn(Player sam, Player dealer, Card card) {
        while (dealer.getScore() <= sam.getScore()) {
            dealer.addCard(card.removeCard(card.getDeck()));
            if (dealer.getScore() > BLACKJACK) {
                return sam.getName();
            }
        }
        return dealer.getName();
    }


    public void printResult(String winnerName, Player sam, Player dealer) {
        System.out.println(winnerName);
        System.out.println(sam.getName() + ": " + String.join(", ", sam.getHand()));
        System.out.println(dealer.getName() + ": " + String.join(", ", dealer.getHand()));
    }
}
