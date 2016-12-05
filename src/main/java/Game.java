public class Game {
    public static void main(String[] args) {
      
      int numItems;
      
      // Create a new Prompter object to start the game      
      Prompter thePrompt = new Prompter();
      
      // Prompt the administrator to get the name of the item and maximum number of items
      thePrompt.adminPrompt();
      
      // Create a new Jar object and pass in the name and max number of items previously acquired
      Jar theJar = new Jar(thePrompt.getItemName(), thePrompt.getMaxItems());
        
      // Randomly determine the number of items stored in the jar up to the maximum number  
      numItems = theJar.fill();
      
      // Prompt the player to let them know the object of the game
      thePrompt.playerPrompt();
      
      // Prompt the player for a integer guess until he/she gets the correct number
      thePrompt.guessPrompt(numItems);
      
    }
}
