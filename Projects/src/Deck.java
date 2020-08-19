import java.util.ArrayList;

public class Deck {

    private static ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();

        int num = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                deck.add( new Card(i, j) );
                num++;
            }
        }
    }

    public void shuffle() {

        int random = (int) (Math.random() * 100) + 52;
        for (int n = random; n > 0; n--) {
            // take two different cards from the deck
            int pos1 = (int) (deck.size() * Math.random());
            int pos2 = (int) (deck.size() * Math.random());

            while (pos2 == pos1) {
                pos2 = (int) (deck.size() * Math.random());
            }

            // switch their positions inside the deck
            Card temp = deck.get(pos1);
            deck.remove(temp);
            deck.add(pos2, temp);
        }

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
