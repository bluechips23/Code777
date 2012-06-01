
package edu.sxm5750;
/**
 * Tile.java
 * @author Sudipan Mishra
 * @version 1.0
 */
/**
 * My most basic Tile class.
 */
public class Tile {
	
	// Each tile will have a number
	int number = 0;
	
	// Each tile will have a color
	String color = "";

	/**
	 * Setter for the tile's number
	 * @param number that needs to be set
	 */
	public void setNumber(int num) {
		this.number = num;
	}
	
	/**
	 * Setter for the color
	 * @param the color that needs to be set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Getter for the number
	 * @return the number of the tile
	 */
	public int getNumber() {
		return this.number;
	}
	
	/**
	 * Getter for the color
	 * @return the color of the tile
	 */
	public String getColor() {
		return this.color;
	}

}