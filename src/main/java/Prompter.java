import java.io.*;

public class Prompter {
  
  private int numItems;
  private int maxItems;
  private int currentGuess;
  private int guessCount = 0;
  private String itemName;
  
  // Create a reader object to accept user input
  BufferedReader input = new BufferedReader(new InputStreamReader((System.in)));
  
  /**
    The getMaxItems method returns the maximum number of items in the jar.
    @return Maximum number of items stored in the jar.
  */
  
  public int getMaxItems() {
    
    return maxItems;
  }
  
  
  /**
    The getItemName method returns the name of the item in the jar as a String.
    @return Name of item stored in the jar.
  */
    
  public String getItemName() {
    
    return itemName;
  }
  
  /**
    The adminPrompt method accepts input from the administrator to set up the game.
  */  
  
  public void adminPrompt() {
    
    boolean isInt = false;
    char theChar = ' ';
    
    System.out.println("ADMINISTRATOR SETUP");
    System.out.println("====================");
        
    try {
      System.out.print("Enter the name of the items to be held in the jar: ");
      itemName = input.readLine();            
    } catch (IOException|NumberFormatException e) {
          System.err.println("Caught Exception: " + e.getMessage());
     }
    do {    
      try { 
        System.out.printf("Enter the maximum number of %s which can be held in the jar: ", itemName);
        maxItems = Integer.parseInt(input.readLine());
      } catch (IOException|NumberFormatException e) {
          System.err.println("Caught Exception: " + e.getMessage());
          continue;
        }
      if (maxItems > 0) {
        isInt = true;
      }
    } while(!isInt);
  }
  
  
  /**
    The playerPrompt method informs the player of the object of the game.
  */
  public void playerPrompt() {
    
    System.out.println("");
    System.out.println("PLAYER");
    System.out.println("==========");
    System.out.printf("Your goal is to guess how many %s are in the jar. Your guess should be a number between 1 and %d.%n",
                     itemName, maxItems);
    System.out.println("");
  }
  
  
  /**
    The guessPrompt method accepts an integer number as a guess. It takes one argument: the number of items in the jar.
    @param numItems The number of items in the jar.
  */
  
  public void guessPrompt(int numItems) {
    
    do {
       try {
          System.out.print("Enter your guess: ");
          currentGuess = Integer.parseInt(input.readLine());
        } catch (IOException|NumberFormatException e) {
            System.err.println("Caught Exception: " + e.getMessage());  
          }      
      if (currentGuess > maxItems) {
        System.out.printf("Your guess must be no more than %d.%n", maxItems);
        continue;
      }
      if (currentGuess < 1) {
        System.out.println("Your guess must be greater than 0.");
        continue;
      }
      if (currentGuess > numItems) {
        System.out.println("Your guess was too high.");  
      }
      else if (currentGuess < numItems) {
        System.out.println("Your guess was too low.");  
      }
      guessCount += 1;
    } while (currentGuess != numItems);  
    
    winOutput(numItems, itemName, guessCount);
 }
  
  
  /**
    The winOutput method takes three arguments: the number of items in the jar,
      the name of the items in the jar and the number of guesses needed to get the correct number
    @param num The number of items in the jar
    @param items The name of the items in the jar
    @param guesses The number of guesses needed by the player to guess the correct number of items
    
  */
  
  public void winOutput(int num, String items, int guesses) {
    
    System.out.printf("Congratulations -- you guessed that there are %d %s in the jar!" +
                      " It took you %d guess(es) to get it right.%n", num, items, guesses);
  }
}