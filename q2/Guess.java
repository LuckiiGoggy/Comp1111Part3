package q2;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Guess is a guessing game application that runs on options panes. It picks a
 * random number between 1 and 100(inclusive) then asks the user to guess the
 * number. The application notifies the user if their guess is too low or too
 * high. After correctly guessing the number, the user is informed of how many
 * guesses it took them to guess the answer, then the program asks if the player
 * wants to play again. If the user tries to input a random value as a guess or
 * a value that is out of bounds, they are informed that this is invalid.
 * @author George
 * @version 1.0
 *
 */
public class Guess {

    /**
     * Main method of the Guess class.
     * @param args - arguments from the command line.
     */
    public static void main(final String[] args) {
        final int maxNum = 100;
        Random rand = new Random();
        int guessMe;
        int playerGuess;
        int numOfGuesses;
        int restart;
        String playerInput;

        String welcomeMessage = "Welcome to the Hi-Lo guessing game. \nI'll"
                + " think of a random number between 1 and 100, \nand you'll"
                + " have to guess it!\n\n Ready? "
                + "\nPress cancel or guess 0 to quit.";
        do {
            numOfGuesses = 0;
            guessMe = rand.nextInt(maxNum) + 1;
            JOptionPane.showConfirmDialog(null, welcomeMessage, "Welcome",
                    JOptionPane.CLOSED_OPTION);
            do {
                playerInput = JOptionPane.showInputDialog(null,
                        "Guess the number I'm thinking of!",
                        "Guess It!", JOptionPane.QUESTION_MESSAGE);
                try {
                    playerGuess = Integer.parseInt(playerInput);
                    numOfGuesses++;
                    if (playerGuess == 0) {
                        playerInput = null;
                    } else if (playerGuess < 1 || playerGuess > maxNum) {
                        JOptionPane.showMessageDialog(null, "Choose a number "
                                + "between 1 and 100 please.");
                        //nullify the current guess
                        numOfGuesses--;
                    } else if (playerGuess > guessMe) {
                        JOptionPane.showMessageDialog(null, "Too high!");
                    } else if (playerGuess < guessMe) {
                        JOptionPane.showMessageDialog(null, "Too low!");
                    } else {
                        JOptionPane.showMessageDialog(null, "CORRECT!! It took"
                                + " you " + numOfGuesses + " guesses!");
                    }
                } catch (NumberFormatException e) {
                    if (playerInput != null) {
                        JOptionPane.showConfirmDialog(null,
                            "Please Input an Integer", "Welcome",
                            JOptionPane.CLOSED_OPTION);
                    }
                    playerGuess = 0;
                }
            } while(playerInput != null && playerGuess != guessMe);

            restart = JOptionPane.showConfirmDialog(
                    null, "Play Again?", "", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

        } while (restart == JOptionPane.YES_OPTION);

    }

}
