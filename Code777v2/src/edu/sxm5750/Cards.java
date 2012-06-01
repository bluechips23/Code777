package edu.sxm5750;


/** Cards class - 1 card = 28 tiles
 * Cards.java
 * @author Sudipan Mishra
 * @version 1.0
 */
import java.util.*;

import android.graphics.Color;

/** Cards is a class for the stack of tiles. 28 tiles make one card stack.
 */
public class Cards {
	

	protected final int number = 0;
	
	// Stack of cards
	protected Stack<Tile> cards;
	
	
	/** 
	 * Create 28 tiles and add them to cards stack
	 * @return a stack of 28 tiles
	 */
	public Stack<Tile> createCards() {
		cards = new Stack<Tile>();
		 
		Tile t1a = new Tile();
		t1a.setNumber(1);
		t1a.setColor("green");
		cards.add(t1a);
		
		Tile t1b = new Tile();
		t1b.setNumber(6);
		t1b.setColor("green");
		cards.add(t1b);
		
		Tile t1c = new Tile();
		t1c.setNumber(6);
		t1c.setColor("green");
		cards.add(t1c);
		
		Tile t1d = new Tile();
		t1d.setNumber(6);
		t1d.setColor("green");
		cards.add(t1d);
		

		Tile t2a = new Tile();
		t2a.setNumber(2);
		t2a.setColor("yellow");
		cards.add(t2a);
		
		Tile t2b = new Tile();
		t2b.setNumber(2);
		t2b.setColor("yellow");
		cards.add(t2b);
		
		Tile t2c = new Tile();
		t2c.setNumber(7);
		t2c.setColor("yellow");
		cards.add(t2c);
		
		Tile t2d = new Tile();
		t2d.setNumber(7);
		t2d.setColor("yellow");
		cards.add(t2d);
	

		Tile t3a = new Tile();
		t3a.setNumber(3);
		t3a.setColor("black");
		cards.add(t3a);
		
		Tile t3b = new Tile();
		t3b.setNumber(3);
		t3b.setColor("black");
		cards.add(t3b);
		
		Tile t3c = new Tile();
		t3c.setNumber(3);
		t3c.setColor("black");
		cards.add(t3c);
		
		Tile t3d = new Tile();
		t3d.setNumber(5);
		t3d.setColor("black");
		cards.add(t3d);
	
		
		Tile t4a = new Tile();
		t4a.setNumber(4);
		t4a.setColor("brown");
		cards.add(t4a);
		
		Tile t4b = new Tile();
		t4b.setNumber(4);
		t4b.setColor("brown");
		cards.add(t4b);
		
		Tile t4c = new Tile();
		t4c.setNumber(4);
		t4c.setColor("brown");
		cards.add(t4c);
		
		Tile t4d = new Tile();
		t4d.setNumber(4);
		t4d.setColor("brown");
		cards.add(t4d);

		
		Tile t5a = new Tile();
		t5a.setNumber(5);
		t5a.setColor("orange");
		cards.add(t5a);
		
		Tile t5b = new Tile();
		t5b.setNumber(5);
		t5b.setColor("orange");
		cards.add(t5b);
		
		Tile t5c = new Tile();
		t5c.setNumber(5);
		t5c.setColor("orange");
		cards.add(t5c);
		
		Tile t5d = new Tile();
		t5d.setNumber(5);
		t5d.setColor("orange");
		cards.add(t5d);
		

		Tile t6a = new Tile();
		t6a.setNumber(6);
		t6a.setColor("red");
		cards.add(t6a);
		
		Tile t6b = new Tile();
		t6b.setNumber(6);
		t6b.setColor("red");
		cards.add(t6b);
		
		Tile t6c = new Tile();
		t6c.setNumber(6);
		t6c.setColor("red");
		cards.add(t6c);
		
		Tile t6d = new Tile();
		t6d.setNumber(7);
		t6d.setColor("red");
		cards.add(t6d);
		
		
		Tile t7a = new Tile();
		t7a.setNumber(7);
		t7a.setColor("blue");
		cards.add(t7a);
		
		Tile t7b = new Tile();
		t7b.setNumber(7);
		t7b.setColor("blue");
		cards.add(t7b);
		
		Tile t7c = new Tile();
		t7c.setNumber(7);
		t7c.setColor("blue");
		cards.add(t7c);
		
		Tile t7d = new Tile();
		t7d.setNumber(7);
		t7d.setColor("blue");
		cards.add(t7d);

		return cards;
	}
	
	/**
	 *  Method to shuffle the tiles
	 *  @return the stack of shuffled cardsC
	 *  
	 */
	public Stack<Tile> shuffle(Stack<Tile> cards) {
		Tile[] tileArray = new Tile[cards.size()];
		int i,j;
		Tile temp = new Tile();
		Random random = new Random(System.currentTimeMillis());
		
		for (i = 0; i < tileArray.length; i++) {
			tileArray[i] = (Tile) cards.pop();
		}
		
		for (i = 0; i < tileArray.length; i++) {
				j = (random.nextInt() & 0x7FFFFFFF) % tileArray.length;
				temp = tileArray[i];
				tileArray[i] = tileArray[j];
				tileArray[j] = temp;
				cards.push(tileArray[j]);
		}
		return cards;
	}
	
	/**
	 * Method to find the resource id for each color
	 * Necessary for setting the color
	 * @return color of the tile
	 * 
	 */
	public int findResourceColor(String color) {
		int returnResourceColor = 0;
		
		if(color.equals("green")) {
			returnResourceColor = Color.GREEN;
		}
		if(color.equals("yellow")) {
			returnResourceColor = Color.rgb(255,215,0);
		}
		if(color.equals("black")) {
			returnResourceColor = Color.BLACK;
		}
		if(color.equals("brown")) {
			returnResourceColor = Color.rgb(205, 133, 63);
		}
		if(color.equals("orange")) {
			returnResourceColor = Color.rgb(255, 165, 0);
		}
		if(color.equals("red")) {
			returnResourceColor = Color.RED;
		}
		if(color.equals("blue")) {
			returnResourceColor = Color.BLUE;
		}
		return returnResourceColor;
	}

}
