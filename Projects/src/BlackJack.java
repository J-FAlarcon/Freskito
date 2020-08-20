import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BlackJack {

    private static Scanner keybd;

    private static ArrayList<Card> deck;

    private static Player player;

    private static int bet;

    /**
     * Default constructor that will put the whole program together.
     *
     * @throws InterruptedException
     */

    public BlackJack() throws InterruptedException {
        // Initialize Scanner
        keybd = new Scanner(System.in);

        // Run intro
        intro();

        // Prepare the deck of cards for the game
        deckPrep();

        // Start the game
        play();
    }

    public static void intro() {

        // Player parameters
        System.out.print("Name:         ");
        String firstName = keybd.nextLine();

        System.out.print("Last name:    ");
        String lastName = keybd.nextLine();

        System.out.print("Budget:       ");
        int budget = keybd.nextInt();

        // Initialize Player
        player = new Player(firstName, lastName, budget);

        // INTRO
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("*********************************************");
        System.out.println("*************   BlackJackasso   *************");
        System.out.println("*********************************************");
        System.out.println();

        System.out.println("Welcome Mr. " + player.getLastName() + " to BlackJackasso!");

    }

    public static void deckPrep() {

        // create a shuffled deck
        Deck baseDeck = new Deck();
        baseDeck.shuffle();

        deck = baseDeck.getDeck();

        // burns the first card
        deck.remove(0);

    }

    public static void play() throws InterruptedException {

        // Check there are enough cards in the deck
        if (deck.size() < 20) {
            // If there aren't get a new deck
            deckPrep();
        }

        // Ask for the betting
        boolean flag = true;
        while (flag) {
            System.out.println("How much would you like to bet?");
            bet = keybd.nextInt();
            if (bet > player.getBudget()) {
                System.out.println("ERROR. Not enough budget, try again.");
                System.out.println();
            }
            else { flag = false; }
        }

        System.out.println();
        System.out.println("Currently betting: " + bet + "\nPossible Win: " + bet*2 );
        System.out.println();

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
        table[1] = new String[] {"-----------", "---------------"};
        table[2] = new String[] {p1.getValue() + " of " + p1.getSuit(), d1.getValue() + " of " + d1.getSuit()};
        table[3] = new String[] {p2.getValue() + " of " + p2.getSuit(), "Unknown"};

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if ( !(i == 3 && j == 2) ) {
                    System.out.format("%-15s\t\t\t", table[i][j]);
                }
                else {
                    System.out.print("\t\t\t" + table[i][j]);
                    if ( (d1.getValueNum() == 10 && d2.getValue().equals("Ace")) ||
                         (d1.getValue().equals("Ace") && d2.getValueNum() == 10) ) {

                        System.out.print("   =   " + d2.getValue() + " of " + d2.getSuit());
                    }
                }
                // if (i > 1) { Thread.sleep(1000); }
            }
            System.out.println();
        }
    }
}
