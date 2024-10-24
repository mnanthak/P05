//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Class designed to account for buttons that are being pressed
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

import processing.core.PApplet;

/**
 * The Button class represents a simple interactive button in the Processing environment.
 */
public class Button {
  // TODO: Whole class

  /**
   * The Processing environment used for drawing the button
   */
  protected static processing.core.PApplet processing;

  /**
   * The text label displayed on the button
   */
  private String label;

  /**
   * The active state of the button (true if active)
   */
  private boolean active;

  /**
   * The x-coordinate of the top-left corner of the button
   */
  private int x;

  /**
   * The y-coordinate of the top-left corner of the button
   */
  private int y;

  /**
   * The width of the button
   */
  private int width;

  /**
   * The height of the button
   */
  private int height;

  /**
   * Constructs a Button with the specified label and position, which is inactive by default. Throws
   * an IllegalStateException if the Processing environment has not been initialized.
   * 
   * @param label  the text label displayed on the button.
   * @param x      the x-coordinate of the top-left corner of the button.
   * @param y      the y-coordinate of the top-left corner of the button.
   * @param width  the width of the button.
   * @param height the height of the button.
   * @throws if the Processing environment is not set before creating a button.
   */
  public Button(String label, int x, int y, int width, int height) {
    if (processing == null) {
      throw new IllegalStateException();
    }
    this.label = label;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Sets the Processing environment to be used by the Button class. This must be called before
   * creating any buttons.
   * 
   * @param processing the Processing environment to be used for drawing and interaction.
   */
  public static void setProcessing(processing.core.PApplet processing) {
    Button.processing = processing;
  }

  /**
   * Returns the label of this button
   * 
   * @return this button's current label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Changes the label of this button
   * 
   * @param label the new label for this button
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * Returns whether the button is currently active.
   * 
   * @return true if the button is active, false otherwise.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets the active state of the button. If true, the button will be rendered as active. If false,
   * it will be rendered as inactive.
   * 
   * @param active the new active state of the button.
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * Renders the button on the Processing canvas. The button changes color based on its isActive
   * parameter and whether the mouse is currently over it
   */
  public void draw() {
    ;
    if (active) {
      if (isMouseOver()) {
        processing.fill(150);
      } else {
        processing.fill(200);
      }
    } else {
      processing.fill(255, 51, 51);
    }
    processing.rect(x, y, width, height, 5);
    processing.fill(0);
    processing.textSize(14);
    processing.textAlign(PApplet.CENTER, PApplet.CENTER);
    processing.text(label, x + width / 2, y + height / 2);
  }

  /**
   * Checks if the mouse is currently over this button. Use PApplet's mouseX and mouseY fields to
   * determine where the mouse is.
   * 
   * @return true if the button is under the mouse's current position, false otherwise.
   */
  public boolean isMouseOver() {
    int mouseX = processing.mouseX;
    int mouseY = processing.mouseY;

    if (mouseX > x && mouseX < x + width && mouseY > y - height && mouseY < y + height) {
      return true;
    }

    return false;
  }
}
