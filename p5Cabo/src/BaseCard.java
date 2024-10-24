//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Class designed to create cards to be used for Cabo Game
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

import java.io.File;

/**
 * The BaseCard class provides the foundation for a playing card in the game.
 */
public class BaseCard {

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
   *                               the card.
   */
  public BaseCard(int rank, String suit) {
    // Throw IllegalStateException error if processing variable is null
    if (processing == null) {
      throw new IllegalStateException("The Processing environment has not been set.");
    }

    // Assign rank and suit variables to the parameters present
    this.rank = rank;
    this.suit = suit;

    // Set card face down
    faceUp = false;

    // Initialize cardBack if the image is null (hasn't been initialized)
    if (cardBack == null) {
      cardBack = processing.loadImage("images" + File.separator + "back.png");
    }

    // Initialize cardImage based on rank and suit
    cardImage = processing
        .loadImage("images" + File.separator + rank + "_of_" + suit.toLowerCase() + ".png");
  }

  /**
   * Sets the Processing environment to be used for drawing and interacting with cards. This method
   * must be called before creating any BaseCard objects.
   * 
   * @param processing the Processing PApplet environment
   */
  public static void setProcessing(processing.core.PApplet processing) {
    BaseCard.processing = processing;
  }

  /**
   * Returns the rank of the card directly, or -1 if the card is the King of Diamonds
   * 
   * @return the rank of the card, or -1 for the King of Diamonds
   */
  public int getRank() {
    if (this.toString().equals("Diamonds 13")) {
      return -1;
    } else {
      return rank;
    }
  }

  /**
   * Sets the face-up status of the card.
   * 
   * @param faceUp if true, set the card face-up; if false, set it face-down.
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  /**
   * Returns a string representation of the card, showing its suit and rank.
   * 
   * @return a string in the format "Suit Rank" (e.g., "Hearts 10").
   */
  @Override
  public String toString() {
    return suit + " " + rank;
  }

  /**
   * Draws the card on the PApplet at the specified position. Before drawing a card's image, be sure
   * to draw a white rectangle for it to sit on:
   * 
   * processing.fill(255); processing.rect(xPosition, yPosition, WIDTH, HEIGHT);
   * 
   * @param xPosition the x-coordinate to draw the card.
   * @param yPosition the y-coordinate to draw the card.
   */
  public void draw(int xPosition, int yPosition) {
    // Assign xPosition and yPosition to x and y
    x = xPosition;
    y = yPosition;

    // Create white rectangle for card to sit on
    processing.fill(255);
    processing.rect(x, y, WIDTH, HEIGHT);

    // Draw image at specified position
    if (faceUp) {
      processing.image(cardImage, x, y, WIDTH, HEIGHT);
    } else {
      processing.image(cardBack, x, y, WIDTH, HEIGHT);
    }
  }

  /**
   * Checks if the mouse is currently over this card. Use PApplet's mouseX and mouseY fields to
   * determine where the mouse is; the (x,y) coordinates of this card's upper left corner were set
   * when it was last drawn.
   * 
   * @return true if the card is under the mouse's current position, false otherwise.
   */
  public boolean isMouseOver() {
    int mouseX = processing.mouseX;
    int mouseY = processing.mouseY;

    if (mouseX > x && mouseX < x + WIDTH && mouseY > y - HEIGHT && mouseY < y + HEIGHT) {
      return true;
    }

    return false;
  }
}
