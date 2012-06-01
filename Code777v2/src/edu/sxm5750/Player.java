package edu.sxm5750;

/**
 * Player.java
 * @author Sudipan Mishra
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import android.util.Log;

/** Player class for my players */
public class Player {
	
	// Cards the players will have.
	Cards cardObject = new Cards();
	
	// Players' questions
	Questions questions;
	
	// Question number to ask
	int askQuestion = 0;
	
	// Answer to reply back
	String answer = "Answer: ";

	/** 
	 * assignCards assigns three cards to each player
	 * @param Tile[] giveCards - cards to give to each player
	 * @param Stack playerCard - which player needs to be assigned cards
	 * @return A tile array with 3 cards per player
	 * 
	 */
	public Tile[] assignCards(Tile[] giveCards, Stack<?> playerCard) {
		for(int numCardsPerPlayer = 1; numCardsPerPlayer <= 3; numCardsPerPlayer++) {
			try {
				if (!playerCard.isEmpty()) {
					giveCards[numCardsPerPlayer-1] = (Tile) playerCard.pop();
				}
			} catch (Exception e) {
				Log.d("Code777","ERROR inside assignCards");
			}
		}
		return giveCards;
	}
	
	/**
	 * askQuestion asks the next question in the stack
	 * @param Queue qStack - Queue full of questions
	 * @return the question number that's asked
	 */
	public int askQuestion(Queue<Integer> qStack) {
		try {
			if (!qStack.isEmpty()) {
				askQuestion = (Integer) qStack.remove();
				qStack.add(askQuestion);
			}
		} catch (Exception e) {
			Log.d("Code777", "ERROR inside askQuestion "+qStack.size());
		}
		return askQuestion;
	}
	
	/**
	 * answerQuestions answers the question that is being asked
	 * @param int qNumber - question number that's asked
	 * @param Tile[] tile1, tile2, tile3 - cards of other three players that
	 * 						are not asking the question
	 * @return answer to the question
	 * 
	 */
	public String answerQuestions(int qNumber, Tile[] tile1, 
								Tile[] tile2, Tile[] tile3) {
		
		int sum = 0;
		int sumRack1 = 0;
		int sumRack2 = 0;
		int sumRack3 = 0;
		int answerSum = 0;
		String more = "";
		ArrayList<Tile> allCards = new ArrayList<Tile>();
		int ySevens = 0;
		int gSixes = 0;
		int rSixes = 0;
		int blues = 0;
		int oranges = 0;
		int browns = 0;
		int reds = 0;
		int blacks = 0;
		int greens = 0;
		int yellows = 0;
		
		// question number that's being asked
		switch(qNumber) {
		
		case 1:
			
			for(int i = 0; i < tile1.length; i++) {
				sumRack1 = sumRack1 + tile1[i].getNumber();
			}
			if(sumRack1 >= 18) {
				answerSum++;
			}
			
			for (int i = 0; i < tile2.length; i++) {
				sumRack2 = sumRack2 + tile2[i].getNumber();
			}
			if(sumRack2 >= 18) {
				answerSum++;
			}
			
			for (int i = 0; i < tile3.length; i++) {
				sumRack3 = sumRack3 + tile3[i].getNumber();
			}
			if(sumRack3 >= 18) {
				answerSum++;
			}
			answer = "On " + answerSum + " racks";
			break;
		
		case 2:
			
			for (int i = 0; i < tile1.length; i++) {
				sum = sum + tile1[i].getNumber();
			}
			if (sum <= 12) {
				answerSum++;
			}
			
			sum = 0;
			for (int i = 0; i < tile2.length; i++) {
				sum = sum + tile2[i].getNumber();
			}
			if (sum <= 12) {
				answerSum++;
			}
			
			sum = 0;
			for (int i = 0; i < tile2.length; i++) {
				sum = sum + tile2[i].getNumber();
			}
			if (sum <= 12) {
				answerSum++;
			}
			answer = "On " + answerSum + " racks";
			break;
		
		case 3:
			boolean sameNumDiffColors = false;
			int rackCount = 0;
			
			ArrayList<Tile> list1 = new ArrayList<Tile>();
			ArrayList<Tile> list2 = new ArrayList<Tile>();
			ArrayList<Tile> list3 = new ArrayList<Tile>();
			for(int i = 0; i < tile1.length; i++) {
				try {
					list1.add(tile1[i]);
				} catch (NullPointerException e) {
					Log.d("Code777", "ERROR - Player.java Case 3, tile1. ");
				}
			}
			try{
				if(((Tile) list1.get(0)).getNumber() == ((Tile) list1.get(1)).getNumber()) {
					if(((Tile) list1.get(0)).getColor() != ((Tile) list1.get(1)).getColor()) {
						sameNumDiffColors = true;
					}
				}
				if(((Tile) list1.get(0)).getNumber() == ((Tile) list1.get(2)).getNumber()) {
					if(((Tile) list1.get(0)).getColor() != ((Tile) list1.get(2)).getColor()) {
						sameNumDiffColors = true;
					}
				}
				if(((Tile) list1.get(2)).getNumber() == ((Tile) list1.get(1)).getNumber()) {
					if(((Tile) list1.get(2)).getColor() != ((Tile) list1.get(1)).getColor()) {
						sameNumDiffColors = true;
					}
				}
				if(sameNumDiffColors) {
					rackCount++;
				}
			} catch (Exception e) {
				Log.d("Code777", "Player.java Case 3, Tile1 sameNumDiffColors.");
			}
			
			sameNumDiffColors = false;
			for(int i = 0; i < tile2.length; i++) {
				try {
					list2.add(tile2[i]);
				} catch (NullPointerException e) {
					Log.d("Code777", "ERROR - Player.java Case 3, tile2. ");
				}
			}
			
			try{
				if(((Tile) list2.get(0)).getNumber() == ((Tile) list2.get(1)).getNumber()) {
					if(((Tile) list2.get(0)).getColor() != ((Tile) list2.get(1)).getColor()) {
						sameNumDiffColors = true;
					}
				}
				if(((Tile) list2.get(0)).getNumber() == ((Tile) list2.get(2)).getNumber()) {
					if(((Tile) list2.get(0)).getColor() != ((Tile) list2.get(2)).getColor()) {
						sameNumDiffColors = true;
					}
				}
				if(((Tile) list2.get(2)).getNumber() == ((Tile) list2.get(1)).getNumber()) {
					if(((Tile) list2.get(2)).getColor() != ((Tile) list2.get(1)).getColor()) {
						sameNumDiffColors = true;
					}
				}
				if(sameNumDiffColors) {
					rackCount++;
				}
			} catch (Exception e) {
				Log.d("Code777", "Player.java Case 3, Tile1 sameNumDiffColors.");
			}
			
			sameNumDiffColors = false;
			for(int i = 0; i < tile3.length; i++) {
				try {
					list3.add(tile3[i]);
				} catch (NullPointerException e) {
					Log.d("Code777", "ERROR - Player.java Case 3, tile3. ");
				}
			}
			try{
				if(((Tile) list3.get(0)).getNumber() == ((Tile) list3.get(1)).getNumber()) {
					if(((Tile) list3.get(0)).getColor() != ((Tile) list3.get(1)).getColor()) {
						sameNumDiffColors = true;
					}
				}
				if(((Tile) list3.get(0)).getNumber() == ((Tile) list3.get(2)).getNumber()) {
					if(((Tile) list3.get(0)).getColor() != ((Tile) list3.get(2)).getColor()) {
						sameNumDiffColors = true;
					}
				}
				if(((Tile) list3.get(2)).getNumber() == ((Tile) list3.get(1)).getNumber()) {
					if(((Tile) list3.get(2)).getColor() != ((Tile) list3.get(1)).getColor()) {
						sameNumDiffColors = true;
					}
				}
				if(sameNumDiffColors) {
					rackCount++;
				}
			} catch (Exception e) {
				Log.d("Code777", "Player.java Case 3, Tile1 sameNumDiffColors.");
			}
			answer = "On " + rackCount + " racks";
			break;
		
		case 4:
			rackCount = 0;
			String[] arrayTileColor = new String[3];
			try {
				arrayTileColor[0] = tile1[0].getColor();
				arrayTileColor[1] = tile1[1].getColor();
				arrayTileColor[2] = tile1[2].getColor();
			} catch (Exception e) {
				Log.d("Code777", "ERROR - Player.java Case 4 tile1");
			}
			if(!(arrayTileColor[0].equals(arrayTileColor[1])))
				if(!(arrayTileColor[0].equals(arrayTileColor[2])))
					if(!(arrayTileColor[1].equals(arrayTileColor[2])))
						rackCount++;
						
			try {
				arrayTileColor[0] = tile2[0].getColor();
				arrayTileColor[1] = tile2[1].getColor();
				arrayTileColor[2] = tile2[2].getColor();
			} catch (Exception e) {
				Log.d("Code777", "ERROR - Player.java Case 4 tile2");
			}
			if(!(arrayTileColor[0].equals(arrayTileColor[1])))
				if(!(arrayTileColor[0].equals(arrayTileColor[2])))
					if(!(arrayTileColor[1].equals(arrayTileColor[2])))
						rackCount++;
			
			try {
				arrayTileColor[0] = tile3[0].getColor();
				arrayTileColor[1] = tile3[1].getColor();
				arrayTileColor[2] = tile3[2].getColor();
			} catch (Exception e) {
				Log.d("Code777", "ERROR - Player.java Case 4 tile3");
			}
			if(!(arrayTileColor[0].equals(arrayTileColor[1])))
				if(!(arrayTileColor[0].equals(arrayTileColor[2])))
					if(!(arrayTileColor[1].equals(arrayTileColor[2])))
						rackCount++;
			
			answer = "On " + rackCount + " racks";
			break;

		
		case 5:
			Log.d("Code777", "---Answer Question 5: "+ qNumber);
			int[] modArray = new int[3];
			int numRacks = 0;
			for(int i = 0; i < tile1.length; i++) {
				modArray[i] = tile1[i].getNumber() % 2;
			}
			if((modArray[0] == modArray[1]) && (modArray[0] == modArray[2])) {
				numRacks++;
			}
			
			for(int i = 0; i < tile2.length; i++) {
				modArray[i] = tile2[i].getNumber() % 2;
			}
			if((modArray[0] == modArray[1]) && (modArray[0] == modArray[2])) {
				numRacks++;
			}
			
			for(int i = 0; i < tile3.length; i++) {
				modArray[i] = tile3[i].getNumber() % 2;
			}
			if((modArray[0] == modArray[1]) && (modArray[0] == modArray[2])) {
				numRacks++;
			}
			answer = "On " + numRacks + " racks";	
			break;

			
		case 6:
			int dupTiles = 0;
			try {
				if(((tile1[0].getNumber() == tile1[1].getNumber()) && 
						(tile1[0].getColor().equals(tile1[1].getColor()))
						|| ((tile1[0].getNumber() == tile1[2].getNumber()) 
								&& (tile1[0].getColor().equals(tile1[2].getColor())))
									|| ((tile1[1].getNumber() == tile1[2].getNumber()) 
											&& (tile1[1].getColor().equals(tile1[2].getColor())))))
													dupTiles++;
				
			} catch (Exception e) {
				Log.d("Code777", "ERROR - Player.java Case 6, tile1. ");
			}
			
			try {
				if(((tile2[0].getNumber() == tile2[1].getNumber()) && 
						(tile2[0].getColor().equals(tile2[1].getColor()))
						|| ((tile2[0].getNumber() == tile2[2].getNumber()) 
								&& (tile2[0].getColor().equals(tile2[2].getColor())))
								|| ((tile2[1].getNumber() == tile2[2].getNumber()) 
										&& (tile2[1].getColor().equals(tile2[2].getColor()))))) 
													dupTiles++;
				
			} catch (Exception e) {
				Log.d("Code777", "ERROR - Player.java Case 6, tile2. ");
			}
			
			try {
				if(((tile3[0].getNumber() == tile3[1].getNumber()) && 
						(tile3[0].getColor().equals(tile3[1].getColor()))
						|| ((tile3[0].getNumber() == tile3[2].getNumber()) 
								&& (tile3[0].getColor().equals(tile3[2].getColor())))
									|| ((tile3[1].getNumber() == tile3[2].getNumber()) 
										&& (tile3[1].getColor().equals(tile3[2].getColor())))))
													dupTiles++;
				
			} catch (Exception e) {
				Log.d("Code777", "ERROR - Player.java Case 9, tile3. ");
			}
			answer = "On " + dupTiles + " racks";
			break;

		
		case 7:
			int consecutive = 0;
			
			int[] numArray = new int[3];
			try {
				numArray[0] = tile1[0].getNumber();
				numArray[1] = tile1[1].getNumber();
				numArray[2] = tile1[2].getNumber();
			} catch (Exception e) {
				Log.d("Code777", "ERROR - Player.java Case 7, tile1. ");
			}
			
			Arrays.sort(numArray);
			if((numArray[2] - numArray[1]) == 1 )
				if((numArray[1] - numArray[0]) == 1)
					consecutive++;
			
			try {
				numArray[0] = tile2[0].getNumber();
				numArray[1] = tile2[1].getNumber();
				numArray[2] = tile2[2].getNumber();
			} catch (Exception e) {
				Log.d("Code777", "ERROR - Player.java Case 7, tile1. ");
			}
			Arrays.sort(numArray);
			if((numArray[2] - numArray[1]) == 1 )
				if( (numArray[1] - numArray[0]) == 1)
					consecutive++;
			
			try {
				numArray[0] = tile3[0].getNumber();
				numArray[1] = tile3[1].getNumber();
				numArray[2] = tile3[2].getNumber();
			} catch (Exception e) {
				Log.d("Code777", "ERROR - Player.java Case 7, tile1. ");
			}
			Arrays.sort(numArray);
			if((numArray[2] - numArray[1]) == 1) 
				if( (numArray[1] - numArray[0]) == 1)
					consecutive++;
		
			answer = "On " + consecutive + " racks";
			break;

		
		case 8:
			Set<String> tileList = new HashSet<String>();
			int uniqueColors = 0;
			for(int i = 0; i < tile1.length; i++) {
				try {
					tileList.add(tile1[i].getColor());
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 8, tile1. ");
				}
			}
			
			for(int i = 0; i < tile2.length; i++) {
				try {
					tileList.add(tile2[i].getColor());
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 9, tile2. ");
				}
			}
			
			for(int i = 0; i < tile3.length; i++) {
				try {
					tileList.add(tile3[i].getColor());
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 9, tile3. ");
				}
			}
			
			uniqueColors = tileList.size();
			answer = "I see " + uniqueColors + " colors";
			break;

			
		case 9:
			ArrayList<String> allColors = new ArrayList<String>();
			int greenCount = 0;
			int yellowCount = 0;
			int blackCount = 0;
			int brownCount = 0;
			int orangeCount = 0;
			int pinkCount = 0;
			int blueCount = 0;
			int count = 0;
			
			for(int i = 0; i < tile1.length; i++) {
				try {
					allColors.add(tile1[i].getColor());
				} catch (NullPointerException e) {
					Log.d("Code777", "ERROR - Player.java Case 9, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allColors.add(tile2[i].getColor());
				} catch (NullPointerException e) {
					Log.d("Code777", "ERROR - Player.java Case 9, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allColors.add(tile3[i].getColor());
				} catch (NullPointerException e) {
					Log.d("Code777", "ERROR - Player.java Case 9, tile3. ");
				}
			}
			
			for(int i = 0; i < allColors.size(); i++) {
				if(allColors.get(i).equals("green")) {
					greenCount++;
				}
				if(allColors.get(i).equals("yellow")) {
					yellowCount++;
				}
				if(allColors.get(i).equals("black")) {
					blackCount++;
				}
				if(allColors.get(i).equals("brown")) {
					brownCount++;
				}
				if(allColors.get(i).equals("orange")) {
					orangeCount++;
				}
				if(allColors.get(i).equals("red")) {
					pinkCount++;
				}
				if(allColors.get(i).equals("blue")) {
					blueCount++;
				}
			}
			if (greenCount >= 3) {
				count++;
			}
			if (yellowCount >= 3) {
				count++;
			}
			if (blackCount >= 3) {
				count++;
			}
			if (brownCount >= 3) {
				count++;
			}
			if (orangeCount >= 3) {
				count++;
			}
			if (pinkCount >= 3) {
				count++;
			}
			if (blueCount >= 3) {
				count++;
			}
			answer = "" + count + " colors";
			break;

		
		case 10:
			int totalNums = 7;
			int uniqueNumsPresent = 0;
			int numsMissing = 0;
			Set<Integer> presentNums = new HashSet<Integer>();
			for(int i = 0; i < tile1.length; i++) {
				try {
					presentNums.add(tile1[i].getNumber());
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 10, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					presentNums.add(tile2[i].getNumber());
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 10, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					presentNums.add(tile3[i].getNumber());
				} catch (Exception e ) {
					Log.d("Code777", "ERROR - Player.java Case 10, tile3. ");
				}
			}
			uniqueNumsPresent = presentNums.size();
			numsMissing = totalNums - uniqueNumsPresent;
			answer = "" + numsMissing + " numbers are missing";
			break;

		
		case 11:
			ArrayList<Tile> allTiles = new ArrayList<Tile>();
			int cardsISee = 0;
			
			for(int i = 0; i < tile1.length; i++) {
				try {
					allTiles.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 11, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allTiles.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 11, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allTiles.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 11, tile3. ");
				}
			}
			for(int i = 0; i < allTiles.size(); i++) {
				try {
					if((((Tile) allTiles.get(i)).getNumber() == 1) &&
							(((Tile)allTiles.get(i)).getColor().equals("green"))){
						cardsISee++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 11, tile1, getNumber(). ");
				}
				
				try {
					if((((Tile) allTiles.get(i)).getNumber() == 5) &&
							(((Tile)allTiles.get(i)).getColor().equals("black"))){
						cardsISee++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 11, tile2, getNumber(). ");
				}
				
				try {
					if((((Tile) allTiles.get(i)).getNumber() == 7) &&
							(((Tile)allTiles.get(i)).getColor().equals("red"))){
						cardsISee++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 11, tile3, getNumber() ");
				}
			}
			answer = "" + cardsISee;
			break;

			
		case 12:
			int threes = 0;
			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 12, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e ) {
					Log.d("Code777", "ERROR - Player.java Case 12, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 12, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if(((Tile) allCards.get(i)).getNumber() == 3){
						threes++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 12, getNumber()=3. ");
				}
				
				try {
					if((((Tile) allCards.get(i)).getNumber() == 6) &&
							(((Tile)allCards.get(i)).getColor().equals("red"))){
						rSixes++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 12, getNumber = 6. ");
				}
			}
			
			if(threes < rSixes) {
				more = "More Red 6s";
			}
			else if(threes > rSixes) {
				more = "More 3s";
			}
			else if(threes == rSixes) {
				more = "About the same";
			}
			answer = "" + more;
			break;

			
		case 13:

			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 13, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 13, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 13, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile) allCards.get(i)).getNumber() == 6) &&
							(((Tile)allCards.get(i)).getColor().equals("green"))){
						gSixes++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 13, getNumber = 6. ");
				}
				
				try {
					if((((Tile) allCards.get(i)).getNumber() == 7) &&
							(((Tile)allCards.get(i)).getColor().equals("yellow"))){
						ySevens++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 13, getNumber = 7 ");
				}
			}
			if(gSixes < ySevens) {
				more = "More Yellow 7s";
			}
			else if(gSixes > ySevens) {
				more = "More Green 6s";
			}
			else if(gSixes == ySevens) {
				more = "About the same";
			}
			answer = "" + more;
			break;

			
		case 14:
			int yTwos = 0;
			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 14, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 14, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 14, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile) allCards.get(i)).getNumber() == 2) &&
							(((Tile)allCards.get(i)).getColor().equals("yellow"))){
						yTwos++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 14, getNumber = 2. ");
				}
				
				try {
					if((((Tile) allCards.get(i)).getNumber() == 7) &&
							(((Tile)allCards.get(i)).getColor().equals("yellow"))){
						ySevens++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 14, getNumber = 7. ");
				}
			}
			if(yTwos < ySevens) {
				more = "More Yellow 7s";
			}
			else if(yTwos > ySevens) {
				more = "More Yellow 2s";
			}
			else if(yTwos == ySevens) {
				more = "About the same";
			}
			answer = "" + more;
			break;

			
		case 15:

			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 15, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 15, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 15, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile) allCards.get(i)).getNumber() == 6) &&
							(((Tile)allCards.get(i)).getColor().equals("green"))){
						gSixes++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 15, getColor = green. ");
				}
				
				try {
					if((((Tile) allCards.get(i)).getNumber() == 6) &&
							(((Tile)allCards.get(i)).getColor().equals("orange"))){
						rSixes++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 15, getColor = orange");
				}
			}
			if(gSixes < rSixes) {
				more = "More Orange 6s";
			}
			else if(gSixes > rSixes) {
				more = "More Green 6s";
			}
			else if(gSixes == rSixes) {
				more = "About the same";
			}
			answer = "" + more;
			break;

			
		case 16:
			int oSevens = 0;
			int bSevens = 0;
			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 16, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 16, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 17, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile) allCards.get(i)).getNumber() == 7) &&
							(((Tile)allCards.get(i)).getColor().equals("blue"))){
						bSevens++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 16, getNumber = blue. ");
				}
				
				try {
					if(!(((Tile) allCards.get(i)).getNumber() == 7) &&
							(((Tile)allCards.get(i)).getColor().equals("blue"))){
						oSevens++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 16, getNumber = not blue. ");
				}
			}
			if(bSevens < oSevens) {
				more = "More 7s of Other Colors";
			}
			else if(bSevens > oSevens) {
				more = "More Blue 7s";
			}
			else if(bSevens == oSevens) {
				more = "About the same";
			}
			answer = "" + more;
			break;

			
		case 17:
			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 17, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 17, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 18, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile)allCards.get(i)).getColor().equals("brown"))){
						browns++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 18, getColor=brown. ");
				}
				
				try {
					if((((Tile)allCards.get(i)).getColor().equals("blue"))){
						blues++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 18, getColor=blue. ");
				}
			}
			if(browns < blues) {
				more = "More Blue Numbers";
			}
			else if(browns > blues) {
				more = "More Brown Numbers";
			}
			else if(browns == blues) {
				more = "About the same";
			}
			answer = "" + more;
			break;

			
		case 18:
			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 18, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 18, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 18, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile)allCards.get(i)).getColor().equals("red"))){
						reds++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 18, getColor=red. ");
				}
				
				try {
					if((((Tile)allCards.get(i)).getColor().equals("orange"))){
						oranges++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 18, getColor=orange. ");
				}
			}
			if(reds < oranges) {
				more = "More Orange Numbers";
			}
			else if(reds > oranges) {
				more = "More Red Numbers";
			}
			else if(reds == oranges) {
				more = "About the same";
			}
			answer = "" + more;
			break;

			
		case 19:
			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 19, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 19, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 19, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile)allCards.get(i)).getColor().equals("green"))){
						greens++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 19, getColor=green. ");
				}
				
				try {
					if((((Tile)allCards.get(i)).getColor().equals("blue"))){
						blues++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 19, getColor=blue. ");
				}
			}
			if(greens < blues) {
				more = "More Blue Numbers";
			}
			else if(greens > blues) {
				more = "More Green Numbers";
			}
			else if(greens == blues) {
				more = "About the same";
			}
			answer = "" + more;
			break;

			
		case 20:
			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 20, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 20, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 20, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile)allCards.get(i)).getColor().equals("yellow"))){
						yellows++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 20, getColor=yellow. ");
				}
				
				try {
					if((((Tile)allCards.get(i)).getColor().equals("orange"))){
						oranges++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 20, getColor=orange. ");
				}
			}
			if(yellows < oranges) {
				more = "More Orange Numbers";
			}
			else if(yellows > oranges) {
				more = "More Yellow Numbers";
			}
			else if(yellows == oranges) {
				more = "About the same";
			}
			answer = "" + more;
			break;
			
		case 21:
			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 21, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 21, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 21, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile)allCards.get(i)).getColor().equals("black"))){
						blacks++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 21, getColor=black. ");
				}
				
				try {
					if((((Tile)allCards.get(i)).getColor().equals("brown"))){
						browns++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 21, getColor=brown. ");
				}
			}
			if(blacks < browns) {
				more = "More Brown Numbers";
			}
			else if(blacks > browns) {
				more = "More Black Numbers";
			}
			else if(blacks == browns) {
				more = "About the same";
			}
			answer = "" + more;
			break;

			
		case 22:
			allCards = new ArrayList<Tile>();
			reds = 0;
			blacks = 0;
			more = "";
			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 22, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 22, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 22, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile)allCards.get(i)).getColor().equals("red"))){
						reds++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 22, getColor=red. ");
				}
				
				try {
					if((((Tile)allCards.get(i)).getColor().equals("black"))){
						blacks++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 22, getColor=black. ");
				}
			}
			if(reds < blacks) {
				more = "More Black Numbers";
			}
			else if(reds > blacks) {
				more = "More Red Numbers";
			}
			else if(reds == blacks) {
				more = "About the same";
			}
			answer = "" + more;
			break;
			
		case 23:
			for(int i = 0; i < tile1.length; i++) {
				try {
					allCards.add(tile1[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 23, tile1. ");
				}
			}
			for(int i = 0; i < tile2.length; i++) {
				try {
					allCards.add(tile2[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 23, tile2. ");
				}
			}
			for(int i = 0; i < tile3.length; i++) {
				try {
					allCards.add(tile3[i]);
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 23, tile3. ");
				}
			}
			for(int i = 0; i < allCards.size(); i++) {
				try {
					if((((Tile)allCards.get(i)).getColor().equals("green"))){
						greens++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 23, getColor=green. ");
				}
				
				try {
					if((((Tile)allCards.get(i)).getColor().equals("yellow"))){
						yellows++;
					}
				} catch (Exception e) {
					Log.d("Code777", "ERROR - Player.java Case 23, getColor=yellow. ");
				}
			}
			if(greens < yellows) {
				more = "More Yellow Numbers";
			}
			else if(greens > yellows) {
				more = "More Green Numbers";
			}
			else if(greens == yellows) {
				more = "About the same";
			}
			answer = "" + more;
			break;
			
		}
		return answer;
	}
		
}