//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Class designed to create and play the Cabo Game
// Course: CS 300 Fall 2024
//
// Author: Harsh Singh
// Email: hvsingh@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Mohnish Nanthakumar
// Partner Email: mnanthakumar@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons: NONE
// Online Sources: NONE

import java.util.ArrayList;

/**
 * This class models a mini-Deck that each player holds - their "hand" of cards.
 */
public class Hand extends Deck {

  /**
   * The maximum number of cards that each player's hand may contain
   */
  private final int HAND_SIZE = 4;

  /**
   * Creates a new empty deck for this hand
   */
  public Hand() {
    super(new ArrayList<BaseCard>());
  }

  /**
   * Overrides Deck's addCard() method to prevent this player being dealt more than HAND_SIZE cards
   * 
   * @param card the card to add to this hand
   * @throws IllegalStateException if the player is already holding the maximum number of cards
   */
  @Override
  public void addCard(BaseCard card) {
    if (super.size() == 4) {
      throw new IllegalStateException();
    } else {
      super.addCard(card);
    }
  }

  /**
   * Replaces the card at the given index (assumed to be between 0 and (HAND_SIZE-1)) with the
   * provided card, and returns the card that was previously at that index.
   * 
   * @param newCard the card to swap into this hand
   * @param index   the index to place the new card at
   * @return the card that was previously at that index
   */
  public BaseCard swap(BaseCard newCard, int index) {
    BaseCard oldCard = super.cardList.get(index);
    super.cardList.set(index, newCard);
    return oldCard;
  }

  /**
   * Switches a card in this hand with a card in the other hand.
   * 
   * @param myIndex    the index of the card in this hand to switch
   * @param otherHand  the other hand to switch cards with
   * @param otherIndex the index of the card in the other hand to switch
   */
  public void switchCards(int myIndex, Hand otherHand, int otherIndex) {
    BaseCard myCard = super.cardList.get(myIndex);
    BaseCard otherCard = otherHand.swap(myCard, otherIndex);
    super.cardList.set(myIndex, otherCard);
  }

  /**
   * Changes the face-up value of the card at the given index to the provided value
   * 
   * @param index  the index of the card to change
   * @param faceUp true if this card should be face-up, false if it should be face-down
   */
  public void setFaceUp(int index, boolean faceUp) {
    super.cardList.get(index).setFaceUp(faceUp);
  }

  /**
   * Draws the entire hand at the given y-coordinate. To calculate the x-coordinate of each card,
   * use (50 + 60*index).
   * 
   * @param y the y-coordinate of the upper-left corner of all cards in this hand
   */
  public void draw(int y) {
    for (BaseCard card : super.cardList) {
      card.draw(50 + 60 * (super.cardList.indexOf(card)), y);
    }
  }

  /**
   * Checks if the mouse is currently over any of the cards in this hand, and returns the index of
   * any card which the mouse is over, or -1 if the mouse is not currently over any card in this
   * hand.
   * 
   * @return the index of a card in this hand which the mouse is over, or -1 if the mouse is not
   *         over any cards in this hand
   */
  public int indexOfMouseOver() {
    for (BaseCard card : super.cardList) {
      if (card.isMouseOver()) {
        return super.cardList.indexOf(card);
      }
    }
    return -1;
  }

  /**
   * Accesses the rank of a card at a given index
   * 
   * @param index the index of the card to access
   * @return the rank of the card at that index
   */
  public int getRankAtIndex(int index) {
    return super.cardList.get(index).rank;
  }

  /**
   * Determines the total value of the cards in this hand, as a sum of the ranks of each of the
   * cards
   * 
   * @return the total value of this Player's hand
   */
  public int calcHand() {
    int total = 0;
    for (BaseCard card : super.cardList) {
      total += card.rank;
    }
    return total;
  }
}
