//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Class designed to create the deck to be used
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
import java.util.Collections;

/**
 * The Deck class represents a deck of playing cards for the game Cabo. It manages a collection of
 * cards, including shuffling, drawing, and adding cards.
 */
public class Deck {
  /**
   * The list of cards in the deck.
   */
  protected ArrayList<BaseCard> cardList;

  /**
   * The Processing environment used for drawing the deck
   */
  protected static processing.core.PApplet processing;

  /**
   * Constructs a new Deck based on the provided parameter.
   * 
   * @param deck the starting list of cards for this deck; should be either a full deck or an empty
   *             list.
   * @throws IllegalStateException if the Processing environment is not set before creating a deck
   */
  public Deck(ArrayList<BaseCard> deck) {
    if (processing == null) {
      throw new IllegalStateException();
    }
    cardList = deck;
  }

  /**
   * Sets the Processing environment to be used by the Deck class. This must be called before
   * creating a deck.
   * 
   * @param processing the Processing environment to be used for drawing and interaction.
   */
  public static void setProcessing(processing.core.PApplet processing) {
    Deck.processing = processing;
  }

  /**
   * Draws a card from the top (end) of the deck.
   * 
   * @return the top card from the deck, or null if the deck is empty.
   */
  public BaseCard drawCard() {
    if (size() == 0) {
      return null;
    }

    BaseCard drawnCard = cardList.get(size() - 1);

    cardList.remove(size() - 1);

    return drawnCard;
  }

  /**
   * Adds a card to the top (end) of the deck.
   * 
   * @param card the card to add to the deck.
   */
  public void addCard(BaseCard card) {
    cardList.add(card);
  }

  /**
   * Gets the current number of cards in the Deck.
   * 
   * @return the size of the deck.
   */
  public int size() {
    return cardList.size();
  }

  /**
   * Checks if the deck is empty.
   * 
   * @return true if the deck is empty, false otherwise.
   */
  public boolean isEmpty() {
    if (size() == 0) {
      return true;
    }
    return false;
  }

  /**
   * Sets up the deck with CABO cards, including action cards. Initializes the deck with all
   * necessary cards and shuffles them.
   * 
   * @return a shuffled list of the 52 cards for CABO, populated with NumberCards and ActionCards.
   */
  public static ArrayList<BaseCard> createDeck() {
    ArrayList<BaseCard> cardList = new ArrayList<>();

    // Define the suits
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    // Cards from 1 (Ace) to 13 (King)
    for (int rank = 1; rank <= 13; ++rank) {
      // Loop through each suit
      for (String suit : suits) {
        if (rank >= 7 && rank <= 12) {
          // Special action cards
          String actionType = "";
          if (rank == 7 || rank == 8) {
            actionType = "peek";
          } else if (rank == 9 || rank == 10) {
            actionType = "spy";
          } else {
            actionType = "switch";
          }
          cardList.add(new ActionCard(rank, suit, actionType)); // Add ActionCard to deck
        } else {
          cardList.add(new BaseCard(rank, suit)); // Add NumberCard to deck
        }
      }
    }
    Collections.shuffle(cardList);
    return cardList;
  }

  /**
   * Draws the top card of the deck onto the Processing canvas at the specified position. If the
   * deck is empty, draws a placeholder indicating the deck is empty.
   * 
   * @param x         the x-coordinate to draw the card.
   * @param y         the y-coordinate to draw the card.
   * @param isDiscard whether the deck is a discard pile, in which case the top card should be drawn
   *                  face-up. Otherwise, the top card should be face-down.
   */
  public void draw(int x, int y, boolean isDiscard) {
    if (isEmpty()) {
      processing.stroke(0);
      processing.fill(0);
      processing.rect(x, y, 50, 70, 7);
      processing.fill(255);
      processing.textSize(12);
      processing.textAlign(processing.CENTER, processing.CENTER);
      processing.text("Empty", x + 25, y + 35);
    } else {
      cardList.get(size() - 1).setFaceUp(isDiscard);
      cardList.get(size() - 1).draw(x, y);
    }
  }

}
