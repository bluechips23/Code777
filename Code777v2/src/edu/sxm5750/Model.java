package edu.sxm5750;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Queue;
import java.util.Stack;

import android.util.Log;

/** model for the Code777 game. */
public class Model {

	/** what the observer must do. */
	public interface Observer {
		
		/** create a command to display a question with a count. */
		Runnable setQuestion (int resource, int qNumber, String answer, int player, int count);
				
		/** create a command to display players' tiles */
		Runnable setTileNum (int resource, int tiles, int tileColor, int count);
		
		/** create a command to set the start button text with a count. */
		Runnable set (int resource, int count);
		
		/** Command is called when user wins*/
		Runnable win(int count);
		
		/** Command is called when user loses*/
		Runnable fail(int count);
		
		/** create a command to play a note (might take time). */
		Runnable play (int resource);
		
		/** execute a list of commands. */
		void execute (Runnable... command);
	}
 
	
	/** Cards */
	protected Cards cards = new Cards();
	
	/**Tiles */
	protected Tile tiles = new Tile();
	
	/** Players */
	protected Player player1 = new Player();
	protected Player player2 = new Player();
	protected Player player3 = new Player();
	protected Player me = new Player();
	
	/** Questions Class*/
	protected Questions questions = new Questions();
	
	/** Actual Question Number */
	protected int qNum = 0;

	/** {@link #start()} should start with a new melody. */
	public static final int START_OVER = 0;

	/** the current state of {@link #start()}. */
	protected int state = START_OVER;

	/** next note which user must send to {@link #listen(int)}. */
	protected int nextTurn = 1;

	/** user interface. */
	protected Observer observer;
	
	/** Stack of cards */
	protected Stack<Tile> cardStack;
	
	/** Stack of questions */
	protected Queue<?> qStacks;
	
	/** Player1's cards */
	protected Tile player1Tile[];
	
	/** Player2's cards */
	protected Tile player2Tile[];
	
	/** Player3's cards */
	protected Tile player3Tile[];
	
	/** My cards */
	protected Tile myTile[];
	
	
	protected int count;
	
	/** Resource for my questions */
	protected int qResource;
	
	/** Which player wants to play next */
	protected int player;
	
	/** Resource for my colors */
	protected int colorResource;
	
	/** My answers */
	protected String answer;
	
	/** Stack for my players */
	protected Stack<Player> playerList;
	
	
	/** Set observer */
	public void setObserver(Observer observer) {
		this.observer = observer;
	}

	/** client presses start button.
	 *  Depending on {@link #state} this will start the game
	 */
	@SuppressWarnings("unchecked")
	public void start () {
		// Enable buttons and change start button's text
		observer.execute(
				observer.set(R.string.next, 0));
		
		// If nextTurn is 1, then it generates the cards, tiles and questions.
		// If nextTurn is more than 1, it just asks questions
		if(nextTurn == 1) {
			if(state == START_OVER) {
				cardStack = cards.createCards();
				cardStack = cards.shuffle(cardStack);
				Log.d("Code777", "Cards created");
			}
		
			
			
			// Initialize 4 players and give 3 cards to each player

			// Initialize player 1's cards
			player1Tile = player1.assignCards((new Tile[3]), cardStack);
			observer.execute(
					observer.setTileNum(R.id.Player1Tile1, player1Tile[0].getNumber(), 
							cards.findResourceColor(player1Tile[0].getColor()), 1),
					observer.setTileNum(R.id.Player1Tile2, player1Tile[1].getNumber(), 
							cards.findResourceColor(player1Tile[1].getColor()), 1),
					observer.setTileNum(R.id.Player1Tile3, player1Tile[2].getNumber(),
							cards.findResourceColor(player1Tile[2].getColor()), 1)
				);
			Log.d("Code777", "Player1: Tile1: "+ player1Tile[0].getNumber());
       		Log.d("Code777", "Player1: Tile1 Color: "+ player1Tile[0].getColor());
       		Log.d("Code777", "Player1: Tile2: "+ player1Tile[1].getNumber());
       		Log.d("Code777", "Player1: Tile2 Color: "+ player1Tile[1].getColor());
       		Log.d("Code777", "Player1: Tile2: "+ player1Tile[2].getNumber());
       		Log.d("Code777", "Player1: Tile2 Color: "+ player1Tile[2].getColor());
			
       		// Shuffle the tiles cards once player's cards are assigned
       		cardStack = cards.shuffle(cardStack);
			Log.d("Code777", "Player 1 Assigned");
			
			
			// Initialize player 2's cards
			player2Tile = player2.assignCards(new Tile[3], cardStack);
			observer.execute(
					observer.setTileNum(R.id.Player2Tile1, player2Tile[0].getNumber(),
							cards.findResourceColor(player2Tile[0].getColor()),1),
					observer.setTileNum(R.id.Player2Tile2, player2Tile[1].getNumber(),
							cards.findResourceColor(player2Tile[1].getColor()),1),
					observer.setTileNum(R.id.Player2Tile3, player2Tile[2].getNumber(),
							cards.findResourceColor(player2Tile[2].getColor()),1)
				);
			Log.d("Code777", "Player2: Tile1: "+ player2Tile[0].getNumber());
       		Log.d("Code777", "Player2: Tile1 Color: "+ player2Tile[0].getColor());
       		Log.d("Code777", "Player2: Tile2: "+ player2Tile[1].getNumber());
       		Log.d("Code777", "Player2: Tile2 Color: "+ player2Tile[1].getColor());
       		Log.d("Code777", "Player2: Tile2: "+ player2Tile[2].getNumber());
       		Log.d("Code777", "Player2: Tile2 Color: "+ player2Tile[2].getColor());
			
       		// Shuffle the tiles cards once player's cards are assigned
       		cardStack = cards.shuffle(cardStack);
			Log.d("Code777", "Player 2 Assigned");
	
			
			// Initialize player 3's cards
			player3Tile = player3.assignCards(new Tile[3], cardStack);
			observer.execute(
					observer.setTileNum(R.id.Player3Tile1, player3Tile[0].getNumber(),
							cards.findResourceColor(player3Tile[0].getColor()),1),
					observer.setTileNum(R.id.Player3Tile2, player3Tile[1].getNumber(),
							cards.findResourceColor(player3Tile[1].getColor()),1),
					observer.setTileNum(R.id.Player3Tile3, player3Tile[2].getNumber(),
							cards.findResourceColor(player3Tile[2].getColor()),1)
				);
			Log.d("Code777", "Player3: Tile1: "+ player3Tile[0].getNumber());
       		Log.d("Code777", "Player3: Tile1 Color: "+ player3Tile[0].getColor());
       		Log.d("Code777", "Player3: Tile2: "+ player3Tile[1].getNumber());
       		Log.d("Code777", "Player3: Tile2 Color: "+ player3Tile[1].getColor());
       		Log.d("Code777", "Player3: Tile2: "+ player3Tile[2].getNumber());
       		Log.d("Code777", "Player3: Tile2 Color: "+ player3Tile[2].getColor());
			
       		// Shuffle tile cards
       		cardStack = cards.shuffle(cardStack);
			Log.d("Code777", "Player 3 Assigned");
	
			
			// Initialize my cards
			myTile = me.assignCards(new Tile[3], cardStack);
			observer.execute(
					observer.setTileNum(R.id.MyTile1, myTile[0].getNumber(), 
								cards.findResourceColor("black"), 1),
					observer.setTileNum(R.id.MyTile2, myTile[1].getNumber(), 
								cards.findResourceColor("black"), 1),
					observer.setTileNum(R.id.MyTile3, myTile[2].getNumber(), 
								cards.findResourceColor("black"), 1)
				);
			Log.d("Code777", "Me: Tile1: "+ myTile[0].getNumber());
       		Log.d("Code777", "Me: Tile1 Color: "+ myTile[0].getColor());
       		Log.d("Code777", "Me: Tile2: "+ myTile[1].getNumber());
       		Log.d("Code777", "Me: Tile2 Color: "+ myTile[1].getColor());
       		Log.d("Code777", "Me: Tile3: "+ myTile[2].getNumber());
       		Log.d("Code777", "Me: Tile3 Color: "+ myTile[2].getColor());
			Log.d("Code777", "Me Assigned");
			
			Log.d("Code777", "----------Card Assignment Complete-------------");
			
			
			
			// Initialize questions
			count = 0;
			
			// Create questions
			qStacks = questions.createQuestions();
			
			// Shuffle questions
			qStacks = questions.shuffleQuestions((Queue<Integer>) qStacks);
			Log.d("Code777", "Initialized questions: ");
			
			Log.d("Code777", "-----------Initialized Questions-----------");
		}
		
		// Find which player's turn it is.
		int mod = nextTurn % 3;
		if(mod == 1) {
			playerList = new Stack<Player>();
			playerList.push(player1);
		} 
		else if(mod == 2) {
			playerList = new Stack<Player>();
			playerList.push(player2);
		}
		else if(mod == 0) {
			playerList = new Stack<Player>();
			playerList.push(player3);
		}
		
		listen(playerList, mod);
		nextTurn++;
				
		
	}

	/** Player's turn to ask questions
	 * @param Stack playerStack - stack of players
	 * @param which player's turn it is to ask question
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void listen (Stack<Player> playerStack, int playerTurn) {
		// Create three tile arrays to store information about the
		// three other players who are NOT asking questions
		Tile[] tile1 = new Tile[3];
		Tile[] tile2 = new Tile[3];
		Tile[] tile3 = new Tile[3];
		
		// Player1's turn to ask question, 
		// so three tile arrays assigned to other three players
		if(playerTurn == 1) {
			Log.d("Code777", "Player = " + playerTurn);
			tile1 = player2Tile;
			tile2 = player3Tile;
			tile3 = myTile;
		}
		
		// Player2's turn to ask question,
		// so three tile arrays assigned to other three players
		else if(playerTurn == 2) {
			Log.d("Code777", "Player = " + playerTurn);
			tile1 = player1Tile;
			tile2 = player3Tile;
			tile3 = myTile;
		} 
		
		// Player 3's turn to ask question,
		// so three tile arrays assigned to other three players
		else if(playerTurn == 0) {
			Log.d("Code777", "Player = " + playerTurn);
			tile1 = player1Tile;
			tile2 = player2Tile;
			tile3 = myTile;
		}
		
		Log.d("Code777", "Player now asks question");
		// This player will ask question
		Player currentPlayer = null;
		try {
			currentPlayer = (Player) playerStack.pop();
		} catch (EmptyStackException e) {
			Log.d("Code777", "ERROR - Model.java listen() playerStack.pop() ");
		}
		
		// Ask question
		qNum = currentPlayer.askQuestion((Queue<Integer>) qStacks);
		Log.d("Code777", "Question Number - qnum = " + qNum);

		// Answer question
		answer = currentPlayer.answerQuestions(qNum, tile1, tile2, tile3);
		qResource = questions.findResource(qNum);
		observer.execute(
				observer.setQuestion(qResource, qNum, answer, playerTurn, count++),
				observer.play(qResource)
			);

	}
	
	/**
	 * Guess method when the player wants to take a guess.
	 * @param String stringValue - the value player enters
	 * 
	 */
	public void guess(String stringValue){
		
		// Just want to find out what my numbers are, to verify guess
		Log.d("Code777", "My Tile 1 = " + myTile[0].getNumber());
		Log.d("Code777", "My Tile 2 = " + myTile[1].getNumber());
		Log.d("Code777", "My Tile 3 = " + myTile[2].getNumber());
		
		
		int count = 0;
		int[] realAnswer = new int[3];
		
		// Get the actual answer
		for(int i = 0; i < realAnswer.length; i++) {
			realAnswer[i] = myTile[i].getNumber();
		}
		Arrays.sort(realAnswer);
		
		// Get the guessed Answer
		int[] guessAnswer = new int[stringValue.length()];
		for(int i = 0; i < guessAnswer.length; i++) {
			guessAnswer[i] = Integer.parseInt(stringValue.substring(i, i+1));
			Log.d("Code777", "Guess Answer: " + guessAnswer[i]);
		}
		Arrays.sort(guessAnswer);
		
		// Check whether guess is right or wrong
		for(int i = 0; i < guessAnswer.length; i++) {
			if(realAnswer[i] == guessAnswer[i]) {
				count++;
			}
		}
		if(count == 3) {
			observer.execute(
					observer.win(count)
			);
			Log.d("Code777", "You win!");
			
		} else {
			observer.execute(
					observer.fail(count)
			);
			
			Log.d("Code777", "You lose!");
		}
			
	}
}
