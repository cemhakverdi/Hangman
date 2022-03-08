/**
 * This is a class for the hangman game.
 * @author Cem Hakverdi
*/
public class Hangman
{
    // Properties
    public String secretWord;
    private int maxAllowedIncorrectTries;
    private int numberOfIncorrectTries;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private StringBuffer knownSoFar;
    
    // Constructors
    
    /**
     * default max 6 incorrect tries, English alphabet,
     * chooses secretWord from fixed list.
     * 
    */
    public Hangman()
    {
        
        this.secretWord = chooseSecretWord();
        this.maxAllowedIncorrectTries = 6;
        this.numberOfIncorrectTries = 0;
        this.allLetters = new StringBuffer( "abcdefghijklmnopqrstuvwxyz" );
        this.usedLetters = new StringBuffer();
        this.knownSoFar = new StringBuffer();
        for(int i = 0; i < secretWord.length(); i++)
        {
            knownSoFar.append("*");
        }
        
          
    }
    
    // Methods
    /**
     * Checks if a letter is in the secretWord and add it to usedLetters.
     * If it is in secretWord, update knownSoFar with the discovered letter.
     * @param letter the guessed letter
     * @return number of occurrences of letter in secretWord
     */
    public int tryThis(char letter) {
        int count;
        
        // A character that is not in allLetters is invalid.
        
        if (allLetters.indexOf(String.valueOf(letter)) == -1){
            return 0;
        }
        
        // It is assumed that the main method will prevent the user from trying
        // a used letter. However, if a letter was already used, the method
        // will not stop but it will not change any of the properties.
        
        if (usedLetters.indexOf(String.valueOf(letter)) == -1)
            usedLetters.append(letter);
        
        count = 0;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                // Replace the blank letters with the correct letter.
                // knownSoFar is assumed to have the same length as secretWord.
                knownSoFar.replace(i, i + 1, String.valueOf(letter));
                count++;
            }
        }
        
        if (count == 0)
            numberOfIncorrectTries++;
        
        return count;
    }
    
    
    /**
     * Chooses a random word from the list
     * @return the chosen word
     */
    public String chooseSecretWord()
    {
        String[] words = { "bird", "cat", "computer", "java", "davenport", "loser" }; // Some random words
        int index;
        String chosenWord;
        
        // Assigning a random index in the range of the array
        index = (int) ( Math.random() * words.length ) ;
        
        // Getting the word from the array at that index
        chosenWord = words[index];
        
        return chosenWord;
    }
    /**
     *
     * @return All letters in the alphabet
     */
    
    public String getAllLetters(){
        return allLetters.toString();
    }


    /**
     *
     * @return Letters that have been tried
     */
    
    public String getUsedLetters(){
        return usedLetters.toString();
    }

    /**
     *
     * @return Incorrect number of tries so far
     */
    public int getNumOfIncorrectTries(){
        return numberOfIncorrectTries;
    }

    /**
     *
     * @return Get the maximum allowed tries
     */
    public int getMaxAllowedIncorrectTries(){
        return maxAllowedIncorrectTries;
    }

    /**
     *
     * @return Get the letters that have been tested so far
     */
    public String getKnownSoFar(){
        return knownSoFar.toString();
    }

    /**
     *
     * @return Whether the game is over or not
     */
    public boolean isGameOver(){
        if( numberOfIncorrectTries == maxAllowedIncorrectTries || knownSoFar.toString().equals(secretWord.toString())){
            return true;
        }
        return false;
    }

    /**
     *
     * @return Whether the game is lost or won
     */
    public boolean hasLost(){
        return numberOfIncorrectTries == maxAllowedIncorrectTries;
    }


}
