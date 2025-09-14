/**
 * This is my code! Its goal is to create and manipulate card objects in order to play the War game
 * CS 212 - Assignment 1
 * @author Sofia CB
 * @version 1 2/11/25
 */

public class Card {
    /**
     * Card's suit that corresponds to an actual card's suit like 'hearts'
     * Can be 0, 2, 3, or 4
     */
    private int suit;

    /**
     * Card's rank that determines which card wins
     * Can be 2, 3...14 max
     */
    private int numRank;

    /**
     * Card's hidden status determines whether it can be shown or not
     * Computer's card starts hidden always
     * True/false
     */
    private boolean hidden;

    /**
     * Constructor that creates a card object with random rank and suit
     * Sets computer's card to hidden at instantiation
     */
    Card(int player) {
        suit = (int) ((Math.random() * 100) % 4);

        numRank = 2 + (int) ((Math.random() * 100) % 13);

        //hidden if player is 2 (computer), not hidden if player is 1 (user)
        hidden = player == 2;

    }

    /**
     * Changes a card's hidden status from true to false so that its suit and rank can be displayed
     * @param computerCard the computer's card object
     */
    public static void changeStatus(Card computerCard) {
        computerCard.hidden = false;

    }

    /**
     * Makes card objects displayable by interpreting card's rank and suit as a string
     * @return A user-friendly output like "Five of Diamonds" or the string "Hidden" if card status is hidden
     */
    @Override
    public String toString() {
        if (!hidden) {

            String stringRank = switch (numRank) {
                case 2 -> "Two";
                case 3 -> "Three";
                case 4 -> "Four";
                case 5 -> "Five";
                case 6 -> "Six";
                case 7 -> "Seven";
                case 8 -> "Eight";
                case 9 -> "Nine";
                case 10 -> "Ten";
                case 11 -> "Jack";
                case 12 -> "Queen";
                case 13 -> "King";
                case 14 -> "Ace";
                default -> "";
            };

            String stringSuit = switch (suit) {
                case 0 -> "Spades";
                case 1 -> "Hearts";
                case 2 -> "Diamonds";
                case 3 -> "Clubs";
                default -> "";
            };


            return stringRank + " of " + stringSuit;

        } else {
            return "Hidden";
        }
    }

    /**
     * Compares the user and computers cards ranks to see who wins
     * @param playerCard the user's card object
     * @param computerCard the computer's card object
     * @return 1 if user's card wins, 2 if computer's card wins, 0 if their ranks are equal (tie)
     */
    public static int compareCards(Card playerCard, Card computerCard) {

        if (playerCard.numRank > computerCard.numRank) {
            return 1;
        } else if (playerCard.numRank < computerCard.numRank) {
            return 2;
        } else {
            return 3;
        }

    }
}