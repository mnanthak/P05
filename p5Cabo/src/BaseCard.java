/**
 * The BaseCard class provides the foundation for a playing card in the game.
 */
public class BaseCard {
  // TODO: Whole class
  
  /**
   * The image representing the back of the card, shared by all cards
   */
  private static processing.core.PImage cardBack;
  
  /**
   * The image representing the front of the card
   */
  private processing.core.PImage cardImage;
  
  /**
   * Whether the card is face-up (true) or face-down (false)
   */
  protected boolean faceUp;
  
  /**
   * The height of the card, set to 70
   */
  private final int HEIGHT = 70;
  
  /**
   * The PApplet environment, used for drawing this card to the game window
   */
  protected static processing.core.PApplet processing;
  
  /**
   * The rank of the card (1 for Ace, 13 for King, etc.)
   */
  protected int rank;
  
  /**
   * The suit of the card (e.g., "Hearts", "Diamonds")
   */
  protected String suit;
  
  /**
   * The width of the card, set to 50
   */
  private final int WIDTH = 50;
  
  /**
   * The x and y coordinates for drawing the card
   */
  private int x;
  
  /**
   * The x and y coordinates for drawing the card
   */
  private int y;

  /**
   * Constructs a new BaseCard with the specified rank and suit. The card is initialized to be face 
   * down by default. You may assume that the provided rank and suit are valid. This method should 
   * also initialize the cardImage, and initialize cardBack if that has not yet been done by any 
   * other constructor call.
   * 
   * @param rank the rank of the card (e.g., 1 for Ace, 13 for King).
   * @param suit the suit of the card (e.g., "Hearts", "Diamonds").
   * @throws IllegalStateException if the Processing environment has not been set before creating 
   *         the card.
   */
  public BaseCard(int rank, String suit) {
    
  }
  
  /**
   * Sets the Processing environment to be used for drawing and interacting with cards. This method 
   * must be called before creating any BaseCard objects.
   * 
   * @param processing the Processing PApplet environment
   */
  public static void setProcessing(processing.core.PApplet processing) {
  
  }
  
  /**
   * Returns the rank of the card directly, or -1 if the card is the King of Diamonds
   * 
   * @return the rank of the card, or -1 for the King of Diamonds
   */
  public int getRank() {
    
  }
  
  /**
   * Sets the face-up status of the card.
   * 
   * @param faceUp if true, set the card face-up; if false, set it face-down.
   */
  public void setFaceUp(boolean faceUp) {
    
  }
  
  /**
   * Returns a string representation of the card, showing its suit and rank.
   * 
   * @return a string in the format "Suit Rank" (e.g., "Hearts 10").
   */
  @Override
  public String toString() {
  
  }
  
  /**
   * Draws the card on the PApplet at the specified position.
   * Before drawing a card's image, be sure to draw a white rectangle for it to sit on:
   * 
   *   processing.fill(255);
   *   processing.rect(xPosition, yPosition, WIDTH, HEIGHT);
   * 
   * @param xPosition the x-coordinate to draw the card.
   * @param yPosition the y-coordinate to draw the card.
   */
  public void draw(int xPosition, int yPosition) {
    
  }
  
  /**
   * Checks if the mouse is currently over this card. Use PApplet's mouseX and mouseY fields to 
   * determine where the mouse is; the (x,y) coordinates of this card's upper left corner were set 
   * when it was last drawn.
   * 
   * @return true if the card is under the mouse's current position, false otherwise.
   */
  public boolean isMouseOver() {
    
  }
}
