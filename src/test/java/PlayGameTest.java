import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CardTest {
    private Player sam;
    private Player dealer;
    private Card card;

    @BeforeEach
    public void setUp() {
        sam = new Player("Sam");
        dealer = new Player("Dealer");
        card = new Card();
    }

}
