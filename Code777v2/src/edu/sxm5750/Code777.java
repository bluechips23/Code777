package edu.sxm5750;

/** Main activity class
 * Code777.java
 * @author Sudipan Mishra
 * @version 1.0
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/** Main activity class */
public class Code777 extends Activity {

	/** serious hack: content view resource. */
	protected int myContentView = R.layout.main2;
	
	/** Layout for my second activity screen */
	protected int questionsView = R.layout.tiles;
	
	/** Names of 4 players*/
	protected TextView player1, player2, player3, me;
	
	/** Tiles for players */
	protected TextView player1Tile1, player1Tile2, player1Tile3,
					player2Tile1, player2Tile2, player2Tile3,
					player3Tile1, player3Tile2, player3Tile3,
					myTile1, myTile2, myTile3;
	
	/** Questions and Answers */
	protected TextView question, answer;
		
	/** My animations */
	protected Animation alpha, scale;
	
	/** All three buttons. */
	protected Button start, guess, qaView;

	/** the model. */
	protected Model model;

	/** the observer. */
	protected Logger logger;
	
	/** My second Activity*/
	protected QAViewActivity secondGui;
		
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Don't want title
		requestWindowFeature(Window.FEATURE_NO_TITLE);		
		
		setContentView(myContentView);
		
		// Don't want top bar
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		Log.d("Code777","Hello!");		
		
		// reference the GUI
		// 4 Players
		player1 = (TextView)findViewById(R.id.player1);
		player2 = (TextView)findViewById(R.id.player2);
		player3 = (TextView)findViewById(R.id.player3);
		me = (TextView)findViewById(R.id.player4);
		
		// Player1 Tiles
		player1Tile1 = (TextView)findViewById(R.id.Player1Tile1);
		player1Tile2 = (TextView)findViewById(R.id.Player1Tile2);
		player1Tile3 = (TextView)findViewById(R.id.Player1Tile3);
				
		// Player2 Tiles
		player2Tile1 = (TextView)findViewById(R.id.Player2Tile1);
		player2Tile2 = (TextView)findViewById(R.id.Player2Tile2);
		player2Tile3 = (TextView)findViewById(R.id.Player2Tile3);
		
		// Player3 Tiles
		player3Tile1 = (TextView)findViewById(R.id.Player3Tile1);
		player3Tile2 = (TextView)findViewById(R.id.Player3Tile2);
		player3Tile3 = (TextView)findViewById(R.id.Player3Tile3);
		
		
		// My Tiles
		myTile1 = (TextView)findViewById(R.id.MyTile1);
		myTile2 = (TextView)findViewById(R.id.MyTile2);
		myTile3 = (TextView)findViewById(R.id.MyTile3);
		
		
		// Setting all tiles to invisible until cards are assigned
		player1Tile1.setVisibility(View.INVISIBLE);
		player1Tile2.setVisibility(View.INVISIBLE);
		player1Tile3.setVisibility(View.INVISIBLE);
		player2Tile1.setVisibility(View.INVISIBLE);
		player2Tile2.setVisibility(View.INVISIBLE);
		player2Tile3.setVisibility(View.INVISIBLE);
		player3Tile1.setVisibility(View.INVISIBLE);
		player3Tile2.setVisibility(View.INVISIBLE);
		player3Tile3.setVisibility(View.INVISIBLE);
		myTile1.setVisibility(View.INVISIBLE);
		myTile2.setVisibility(View.INVISIBLE);
		myTile3.setVisibility(View.INVISIBLE);
		
		//Question
		question = (TextView)findViewById(R.id.question);
		
		// Question Animation
		alpha=AnimationUtils.loadAnimation(this, R.anim.alpha);
		scale=AnimationUtils.loadAnimation(this, R.anim.scale);
		
		
		//Answer
		answer = (TextView)findViewById(R.id.answer);
		
		
		// Start button
		start = (Button)findViewById(R.id.start);

		
		// Done button
		guess = (Button)findViewById(R.id.guess);
		guess.setVisibility(View.INVISIBLE);
		
		// QA View Button sends user to 2nd Activity
		qaView = (Button)findViewById(R.id.questions);
		qaView.setVisibility(View.INVISIBLE);
		qaView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QAViewActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });
		
		// create the model
		model = new Model();
		
		model.setObserver(logger = new Logger(this, secondGui));
		
		// attach the start button controller 
		start.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.d("Code777", "Let's play");
				model.start();
			}
		});
	
		
		
		// Setting an onClickListener for my guess button
		guess.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.d("Code777", "Guessing...");
				
				// Creating an alertDialog to allow user to enter numbers
				AlertDialog.Builder alert = new AlertDialog.Builder(Code777.this);

				alert.setTitle("Guess");
				alert.setMessage("Enter your guess:");

				// EditText view to get user input, only numbers and up to 3 numbers
				final EditText input = new EditText(Code777.this);
				input.setInputType(InputType.TYPE_CLASS_PHONE);
				int maxLength = 3;
				InputFilter[] FilterArray = new InputFilter[1];
				FilterArray[0] = new InputFilter.LengthFilter(maxLength);
				input.setFilters(FilterArray);
				alert.setView(input);
				
				// User wants to continue guessing
				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					  Editable value = input.getText();
					  String stringValue = value.toString();
					  Log.d("Code777", "---Guess Value " + stringValue);
					  model.guess(stringValue);
					 }
				});
				
				// User doesn't want to guess and cancels.
				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				  public void onClick(DialogInterface dialog, int whichButton) {
				  }
				});
				alert.show();
			}
		});
		
	}


}