import javax.swing.*;
import java.awt.*;

public class Card {

    private String suit;
    private String value;

    public Card(int suit, int value) {

        // suit assigner
        if (suit == 0) { this.suit = "Hearts"; }
        else if (suit == 1) { this.suit = "Diamonds"; }
        else if (suit == 2) { this.suit = "Spades"; }
        else if (suit == 3) { this.suit = "Clubs"; }

        // value assigner
        if (value > 1 && value < 11) { this.value = Integer.toString(value); }
        else {
            if (value == 11) { this.value = "Jack"; }
            else if (value == 12) { this.value = "Queen"; }
            else if (value == 13) { this.value = "King"; }
            else { this.value = "Ace"; }
        }

    }

    public String getSuit() {
        return this.suit;
    }

    public String getValue() {
        return this.value;
    }

}
