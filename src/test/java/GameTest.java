import org.example.Card;
import org.example.Player;
import org.example.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GameTest {
    private Player sam;
    private Player dealer;
    private Card card;

    private Game game;

    @BeforeEach
    public void setUp() {
        sam = new Player("Sam");
        dealer = new Player("Dealer");
        card = new Card();
        game = new Game();
    }

    @Test
    public void testDealInitialCards() {
        card.setDeck(card.initialShuffledDeck());
        game.dealInitialCards(sam, dealer, card);

        // check that each player has 2 cards
        Assertions.assertEquals(2, sam.getHand().size());
        Assertions.assertEquals(2, dealer.getHand().size());

        // check that the number of cards left in the deck is correct
        Assertions.assertEquals(48, card.getDeck().size());
    }

    @Test
    public void testCheckInitialCardsSamWins() {
        sam.addCard("S10");
        sam.addCard("CA");
        dealer.addCard("SA");
        dealer.addCard("DK");
        Assertions.assertEquals("Sam", game.checkInitialCards(sam, dealer));
    }

    @Test
    public void testCheckInitialCardsDealerWins() {
        sam.addCard("S8");
        sam.addCard("H4");
        dealer.addCard("CA");
        dealer.addCard("DK");
        Assertions.assertEquals("Dealer", game.checkInitialCards(sam, dealer));
    }

    @Test
    public void testCheckInitialCardsSamWins1() {
        sam.addCard("S8");
        sam.addCard("CA");
        dealer.addCard("HA");
        dealer.addCard("DA");
        Assertions.assertEquals("Sam", game.checkInitialCards(sam, dealer));
    }

    @Test
    public void testCheckInitialCardsDealerWins1() {
        sam.addCard("SA");
        sam.addCard("CA");
        dealer.addCard("HA");
        dealer.addCard("DA");
        Assertions.assertEquals("Dealer", game.checkInitialCards(sam, dealer));
    }

    @Test
    public void testCheckInitialCardsNoWinner() {
        sam.addCard("S5");
        sam.addCard("H8");
        dealer.addCard("C7");
        dealer.addCard("D2");
        Assertions.assertNull(game.checkInitialCards(sam, dealer));
    }

    @Test
    public void testSamTurnNoBust() {
        sam.addCard("S7");
        sam.addCard("HA");
        dealer.addCard("C10");
        dealer.addCard("D2");
        ArrayList<String> deck = new ArrayList<>(Arrays.asList("S5", "H8", "C7"));
        card.setDeck(deck);
        String winnerName = game.samTurn(sam, dealer, card);
        Assertions.assertNull(winnerName);
        Assertions.assertTrue(sam.getScore() >= 17);
    }

    @Test
    public void testSamTurnBust() {
        sam.addCard("S10");
        sam.addCard("C6");
        dealer.addCard("C10");
        dealer.addCard("D2");
        ArrayList<String> deck = new ArrayList<>(Arrays.asList("S9", "H8", "C7"));
        card.setDeck(deck);
        String winnerName = game.samTurn(sam, dealer, card);
        Assertions.assertEquals("Dealer", winnerName);
    }

    @Test
    public void testDealerTurnNoBust() {
        sam.addCard("S10");
        sam.addCard("H3");
        sam.addCard("C4");
        dealer.addCard("C7");
        dealer.addCard("D8");
        ArrayList<String> deck = new ArrayList<>(Arrays.asList("S6", "H8", "C2"));
        card.setDeck(deck);
        String winnerName = game.dealerTurn(sam, dealer, card);
        Assertions.assertEquals("Dealer", winnerName);
        Assertions.assertTrue(dealer.getScore() > sam.getScore());
    }

    @Test
    public void testDealerTurnBust() {
        sam.addCard("S10");
        sam.addCard("H3");
        sam.addCard("C4");
        dealer.addCard("C7");
        dealer.addCard("D8");
        ArrayList<String> deck = new ArrayList<>(Arrays.asList("SK", "H8", "C2"));
        card.setDeck(deck);
        String winnerName = game.dealerTurn(sam, dealer, card);
        Assertions.assertEquals("Sam", winnerName);
    }
}
