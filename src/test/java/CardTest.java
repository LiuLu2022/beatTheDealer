import org.example.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CardTest {
    private Card card;

    @Test
    public void testGetCardValue() {
        // Test A
        Assertions.assertEquals(11, card.getCardValue("SA"));

        // Test 10
        Assertions.assertEquals(10, card.getCardValue("S10"));

        // Test J
        Assertions.assertEquals(10, card.getCardValue("SJ"));

        // Test Q
        Assertions.assertEquals(10, card.getCardValue("SQ"));

        // Test K
        Assertions.assertEquals(10, card.getCardValue("SK"));

        // Test 2-9
        Assertions.assertEquals(2, card.getCardValue("S2"));
        Assertions.assertEquals(3, card.getCardValue("S3"));
        Assertions.assertEquals(4, card.getCardValue("S4"));
        Assertions.assertEquals(5, card.getCardValue("S5"));
        Assertions.assertEquals(6, card.getCardValue("S6"));
        Assertions.assertEquals(7, card.getCardValue("S7"));
        Assertions.assertEquals(8, card.getCardValue("S8"));
        Assertions.assertEquals(9, card.getCardValue("S9"));
    }
}
