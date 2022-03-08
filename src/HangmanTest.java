import java.util.Scanner;

/**
 * test for hangman game 
 * @author Cem Hakverdi
 * @version 15.02.2021
*/ 
public class HangmanTest {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// variables
		Hangman hangman;
		int occurrences;
		int numberOfIncorrectTries;
		int maxIncorrectTries;
		char input;
		String wordSoFar;
		String validLetters;
		String usedLetters;
		
		// Step 1: Start the game.
		hangman = new Hangman();
		validLetters = hangman.getAllLetters();
		usedLetters = "";
		maxIncorrectTries = hangman.getMaxAllowedIncorrectTries();
        System.out.println( "Welcome to Hangman Game!" );
        System.out.println(hangman.secretWord);
		
		// Step 2: Let the user guess letters until the game is over.
		while( !hangman.isGameOver() ) {
            System.out.println( "Valid letters: " + validLetters );
            System.out.println();
            
            System.out.println( "Used letters: " + usedLetters );
            System.out.println();
            
            System.out.print( "Please enter a letter: " );
            input = scan.nextLine().charAt( 0 );
            

			
			
			// If the character is not valid or it is a previously used letter,
			// Warn the user, and do not send this guess to Hangman class!
			if ( validLetters.indexOf( input ) != -1 &&
					usedLetters.indexOf( input ) == -1 ) {
				
				occurrences = hangman.tryThis( input );
				numberOfIncorrectTries = hangman.getNumOfIncorrectTries();
				wordSoFar = hangman.getKnownSoFar();
				usedLetters = hangman.getUsedLetters();
				
                System.out.println( "Found " + occurrences + " for " + input + "!" );
                System.out.println();
                
                System.out.print( "Number of incorrect tries: " );
                
                
                System.out.println( numberOfIncorrectTries + "/" + maxIncorrectTries );
                System.out.println();
                
                System.out.println( "Word so far: " + wordSoFar );
                System.out.println();
                
			} else {
				System.out.println( "Please enter an unused valid character!" );
			}
		}
		scan.close();
		
		// Step 3: Print out a game is over message followed by if the user has won.
		System.out.println( "Game is over!" );
        if ( hangman.hasLost() ) 
        {
			System.out.println( "You have lost!" );
			System.out.println("The secret word: " + hangman.secretWord);
        } 
        
        else 
        {
			System.out.println( "You have won!" );
		}
	}
}
