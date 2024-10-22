//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Class designed to create cards along with the action associated with the card
// Course:   CS 300 Fall 2024
//
// Author:   Harsh Singh
// Email:    hvsingh@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// 
// Partner Name:    Mohnish Nanthakumar
// Partner Email:   mnanthakumar@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE

/**
 * The ActionCard class represents a card that has an associated action.
 */
public class ActionCard extends BaseCard {
  
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
   * @throws IllegalArgumentException if actionType isn't "peek", "spy", or "switch" (added by us) 
   */
  public ActionCard(int rank, String suit, String actionType) {
    // Call BaseCard constructor, so other variables are initialized (for example faceUp)
    super(rank, suit);
    
    // Initialize actionType if String is "peek", "spy", or "switch"
    if (actionType.equalsIgnoreCase("peek") || actionType.equalsIgnoreCase("spy") 
        || actionType.equalsIgnoreCase("switch")) {
      this.actionType = actionType;
    } else {
      throw new IllegalArgumentException("Make sure that action type is peek, spy, or switch.");
    }
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
