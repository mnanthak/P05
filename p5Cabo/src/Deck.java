import java.util.ArrayList;
import java.util.Collections;
import processing.core.PApplet;

/**
 * The Deck class represents a deck of playing cards for the game Cabo. It manages a collection of
 * cards, including shuffling, drawing, and adding cards.
 */
public class Deck {
  
  // TODO: add everything else
  
  /**
   * The list of cards in the deck.
   */
  protected ArrayList<BaseCard> cardList;
  
  /**
   * The Processing environment used for drawing the deck
   */
  protected static processing.core.PApplet processing;
  
  /**
   * Constructs a new Deck based on the provided parameter. To create a full deck, pass in the 
   * output of createDeck().
   * 
   * @param deck the starting list of cards for this deck; should be either a full deck or an empty 
   *        list.
   * @throws IllegalStateException if the Processing environment is not set before creating a deck.
   */
  public Deck(ArrayList<BaseCard> deck) {
    
  }
  
  /**
   * Draws a card from the top (end) of the deck.
   * 
   * @return the top card from the deck, or null if the deck is empty.
   */
  public BaseCard drawCard() {
    
  }
  
  /**
   * Adds a card to the top (end) of the deck.
   * 
   * @param card the card to add to the deck.
   */
  public void addCard(BaseCard card) {
    
  }
  
  /**
   * Gets the current number of cards in the Deck.
   * 
   * @return the size of the deck.
   */
  public int size() {
    
  }
  
  /**
   * Checks if the deck is empty.
   * 
   * @return true if the deck is empty, false otherwise.
   */
  public boolean isEmpty() {
    
  }
  
  /**
   * Draws the top card of the deck onto the Processing canvas at the specified position. If the 
   * deck is empty, draws a placeholder indicating the deck is empty.
   * 
   * @param x the x-coordinate to draw the card.
   * @param y the y-coordinate to draw the card.
   * @param isDiscard whether the deck is a discard pile, in which case the top card should be 
   *        drawn face-up. Otherwise, the top card should be face-down.
   */
  public void draw(int x, int y, boolean isDiscard) {
    
  }
  
  /**
   * Sets up the deck with CABO cards, including action cards. Initializes the deck with all
   * necessary cards and shuffles them.
   *
   * @return the completed ArrayList of CABO cards
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
          cardList.add(new ActionCard(rank, suit, actionType));  // Add ActionCard to deck
        } else {
          cardList.add(new BaseCard(rank, suit));  // Add NumberCard to deck
        }
      }
    }
    Collections.shuffle(cardList);
    return cardList;
  }

}
