/**
 * The ActionCard class represents a card that has an associated action.
 */
public class ActionCard extends BaseCard {
  // TODO: Whole class
  
  /**
   * The type of action associated with this card: "peek", "spy", or "switch".
   */
  private String actionType;
  
  /**
   * Constructs an ActionCard with the specified rank, suit, and action type.
   * 
   * @param rank the rank of the card (e.g., 1 for Ace, 13 for King).
   * @param suit the suit of the card (e.g., "Hearts", "Diamonds").
   * @param actionType the type of action associated with this card: "peek", "spy", or "switch"
   */
  public ActionCard(int rank, String suit, String actionType) {
    
  }
  
  /**
   * Gets the type of action associated with this card.
   * 
   * @return the action type as a String: "peek", "spy", or "switch".
   */
  public String getActionType() {
    return actionType;
  }
  
}
