import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void testAddCard() {
        Player player = new Player("Sam");
        player.addCard("S5");
        Assertions.assertEquals(5, player.getScore());
        player.addCard("CA");
        Assertions.assertEquals(16, player.getScore());
        player.addCard("HK");
        Assertions.assertEquals(26, player.getScore());
    }
}
