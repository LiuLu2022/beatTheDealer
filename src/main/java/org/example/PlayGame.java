package org.example;

public class PlayGame {
    public static void main(String[] args) {

        //Prepare Deck
        Card card = new Card();
        if (args.length > 0) {
            card.setDeck(card.readDeckFromFile(args[0]));
        } else {
            card.setDeck(card.initialShuffledDeck());
        }

        Player sam = new Player("Sam");
        Player dealer = new Player("Dealer");
        Game game = new Game();
        String winnerName;

        //Step 1: start to assign initial cards.
        game.dealInitialCards(sam, dealer, card);

        //Step 2: check if any player win with initial cards.
        winnerName = game.checkInitialCards(sam, dealer);
        if (winnerName != null) {
            game.printResult(winnerName, sam, dealer);
            return;
        }

        //Step 3: Sam's turn to draw cards.
        winnerName = game.samTurn(sam, dealer, card);
        if (winnerName != null) {
            game.printResult(winnerName, sam, dealer);
            return;
        }

        //Step 4: Dealer's turn to draw cards.
        winnerName = game.dealerTurn(sam, dealer, card);
        game.printResult(winnerName, sam, dealer);
    }

}