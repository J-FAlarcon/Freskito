import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BlackJack {

    private static Scanner keybd;

    public static void play() throws InterruptedException {

        // initialize the Scanner
        keybd = new Scanner(System.in);

        // create a shuffled deck
        Deck baseDeck = new Deck();
        baseDeck.shuffle();

        ArrayList<Card> deck = baseDeck.getDeck();

        // discards the first 6 cards
        deck.subList(0, 6).clear();

        // deals 4 cards, 1 for the player, another one for himself, and so on
        Card p1 = deck.get(0);
        deck.remove(0);

        Card d1 = deck.get(0);
        deck.remove(0);

        Card p2 = deck.get(0);
        deck.remove(0);

        Card d2 = deck.get(0);
        deck.remove(0);

        // Display the cards dealt
        String[][] table = new String[4][2];
        table[0] = new String[] {"Your cards:", "Dealer's cards:"};
        table[1] = new String[] {"---------------", "---------------"};
        table[2] = new String[] {p1.getValue() + " of " + p1.getSuit(), d1.getValue() + " of " + d1.getSuit()};
        table[3] = new String[] {p2.getValue() + " of " + p2.getSuit(), "Unknown"};

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.format("%-15s\t\t\t", table[i][j]);
                if (i > 1) { Thread.sleep(1000); }
            }
            System.out.println();
        }
    }
}
