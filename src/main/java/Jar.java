import java.util.Random;

public class Jar {
  
  private int numItems;
  private int maxItems;
  private String itemName;
  
  /**
    Constructor for Jar class which sets:
    name of the item and maximum number of items to be stored.
    @param itemName The name of the item which will fill the jar.
    @param maxItems The maximum number of items in the jar.
   */
  
  public Jar(String name, int max) {
    
    itemName = name;
    maxItems = max;    
  }

  
  /**
    The getNumItems method returns the number of items in the jar.
    @return Number of items stored in the jar.
  */
  
  public int getNumItems() {
    
    return numItems;
  }
 
  
  /**
    The fill method fills the jar object with:
    the items to be stored and a randomly determined number of items to be stored
    subject to the limitation of the maximum number of items as determined by administrator.
  */
  
  public int fill() {
    
    try {
      Random random = new Random();
      numItems = (random.nextInt(maxItems) + 1);  
    } catch (IllegalArgumentException e) {
        System.err.println("Caught Exception: " + e.getMessage());
      }
    return numItems; 
  }
}