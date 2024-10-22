/**
 * This class models a CABO player for use in the CS300 P05 CABO project. A Player can be either a 
 * human or a computer player; to use a fully-featured AI player, see the AIPlayer derived class.
 */
public class Player {
  /**
   * The collection of Cards that this Player is holding at any given time in the game
   */
  private Hand hand;
  
  /**
   * An indicator of whether this is a human or computer player
   */
  private boolean isComputer;
  
  /**
   * This player's label for running the game (for this project, 0-3)
   */
  private int label;
  
  /**
   * The identifier associated with this Player
   */
  private String name;
  
  /**
   * Accesses the name of this Player
   * 
   * @return this player's identifier
   */
  public String getName() {
    
  }
  
  /**
   * Accesses the label (0-3) of this Player
   * 
   * @return this player's label
   */
  public int getLabel() {
    
  }
  
  /**
   * Accesses a shallow-copy reference of this player's hand
   * 
   * @return a reference to this player's hand
   */
  public Hand getHand() {
    
  }
  
  /**
   * Reports whether this is a computer player
   * 
   * @return true if this is a computer player, false if this is a human
   */
  public boolean isComputer() {
    
  }
  
  /**
   * Adds a card to this player's hand
   * 
   * @param card the card to add to this player's hand
   */
  public void addCardToHand(BaseCard card) {
    
  }
}