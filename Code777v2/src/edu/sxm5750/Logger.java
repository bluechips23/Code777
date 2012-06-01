package edu.sxm5750;

/** Logger class
 * Logger.java
 * @author Sudipan Mishra
 * @version 1.0
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.ArrayList;

/** an observer which mostly carries out the commands from model.
 *  Uses package access to the activity.  */
public class Logger implements Model.Observer {
  /** for interaction. */
  protected final Code777 gui;
  
  /** My second activity */
  protected final QAViewActivity secondGui;
  

  protected ArrayList<Runnable> queue = new ArrayList<Runnable>();

  public Logger (Code777 gui, QAViewActivity secondGui) {
    this.gui = gui;
    this.secondGui = secondGui;
  }

  public Runnable say (final int resource, final int count) {
    return new Runnable() {
      public void run () {
        String s = MessageFormat.format(gui.getString(resource), count);
        Log.d("Code777", "say "+s);        
        
        //continuation();
        
      }
    };
  }

  /*
   * Used for setting the question
   * @see edu.sxm5750.Model.Observer#setQuestion(int, int, java.lang.String, int, int)
   */
  public Runnable setQuestion (final int resource, final int qNumber, 
		  								final String answer, final int player, final int count) {
	    return new Runnable() {
	      public void run () {
	    	String displayQuestion = "";
	        String s = MessageFormat.format(gui.getString(resource), count);
	        Log.d("Code777", "Question: "+s);
	        Log.d("Code777", "Answer: " + answer);
	        if(player == 1) {
	        	displayQuestion = "Player1 asks Q";
	        }
	        if(player == 2) {
	        	displayQuestion = "Player2 asks Q";
	        }
	        if (player == 0) {
	        	displayQuestion = "Player3 asks Q";
	        }
	        gui.question.setText(displayQuestion+s);
	        gui.answer.setText("Answer: " + answer);
	        
	        continuation();
	      }
	    };
  }
  

  /*
   * Used for setting the tile numbers, colors and animation
   * @see edu.sxm5750.Model.Observer#setTileNum(int, int, int, int)
   */
  public Runnable setTileNum (final int resource, final int tileNum, 
		  					final int tileColor, final int count) {
	  return new Runnable() {
	      public void run () {  
	    	  
	    	// Creating the animation
	    	Animation animation = AnimationUtils.loadAnimation(gui, R.anim.scale);
	    	 
	       	if (gui.player1Tile1.getId() == resource) {
	       		gui.player1Tile1.setVisibility(View.VISIBLE);
	       		gui.player1Tile1.setText(""+tileNum);
	       		gui.player1Tile1.setTextColor(tileColor);
	       		gui.player1Tile1.startAnimation(animation);
	       	}
	       	if (gui.player1Tile2.getId() == resource) {
	       		gui.player1Tile2.setVisibility(View.VISIBLE);
	       		gui.player1Tile2.setText(""+tileNum);
	       		gui.player1Tile2.setTextColor(tileColor);
	       		gui.player1Tile2.startAnimation(animation);
	       	}
	       	if (gui.player1Tile3.getId() == resource) {
	       		gui.player1Tile3.setVisibility(View.VISIBLE);
	       		gui.player1Tile3.setText(""+tileNum);
	       		gui.player1Tile3.setTextColor(tileColor);
	       		gui.player1Tile3.startAnimation(animation);
	       	}
	       	if (gui.player2Tile1.getId() == resource) {
	       		gui.player2Tile1.setVisibility(View.VISIBLE);
	       		gui.player2Tile1.setText(""+tileNum);
	       		gui.player2Tile1.setTextColor(tileColor);
	       		gui.player2Tile1.startAnimation(animation);
	       		
	       	}
	       	if (gui.player2Tile2.getId() == resource) {
	       		gui.player2Tile2.setVisibility(View.VISIBLE);
	       		gui.player2Tile2.setText(""+tileNum);
	       		gui.player2Tile2.setTextColor(tileColor);
	       		gui.player2Tile2.startAnimation(animation);
	       	}
	       	if (gui.player2Tile3.getId() == resource) {
	       		gui.player2Tile3.setVisibility(View.VISIBLE);
	       		gui.player2Tile3.setText(""+tileNum);
	       		gui.player2Tile3.setTextColor(tileColor);
	       		gui.player2Tile3.startAnimation(animation);
	       	}
	       	if (gui.player3Tile1.getId() == resource) {
	       		gui.player3Tile1.setVisibility(View.VISIBLE);
	       		gui.player3Tile1.setText(""+tileNum);
	       		gui.player3Tile1.setTextColor(tileColor);
	       		gui.player3Tile1.startAnimation(animation);
	       	}
	       	if (gui.player3Tile2.getId() == resource) {
	       		gui.player3Tile2.setVisibility(View.VISIBLE);
	       		gui.player3Tile2.setText(""+tileNum);
	       		gui.player3Tile2.setTextColor(tileColor);
	       		gui.player3Tile2.startAnimation(animation);
	       	}
	       	if (gui.player3Tile3.getId() == resource) {
	       		gui.player3Tile3.setVisibility(View.VISIBLE);
	       		gui.player3Tile3.setText(""+tileNum);
	       		gui.player3Tile3.setTextColor(tileColor);
	       		gui.player3Tile3.startAnimation(animation);
	       	}
	       	if (gui.myTile1.getId() == resource) {
	       		gui.myTile1.setVisibility(View.VISIBLE);
	       		gui.myTile1.setText("?");
	       		gui.myTile1.setTextColor(tileColor);
	       		gui.myTile1.startAnimation(animation);
	       		
	       	}
	       	if (gui.myTile2.getId() == resource) {
	       		gui.myTile2.setVisibility(View.VISIBLE);
	       		gui.myTile2.setText("?");
	       		gui.myTile2.setTextColor(tileColor);
	       		gui.myTile2.startAnimation(animation);
	       		
	       	}
	       	if (gui.myTile3.getId() == resource) {
	       		gui.myTile3.setVisibility(View.VISIBLE);
	       		gui.myTile3.setText("?");
	       		gui.myTile3.setTextColor(tileColor);
	       		gui.myTile3.startAnimation(animation);
	       		
	       	}
	       	
	        continuation();
	      }
	    };
  }

  
  /*
   * Changing the text of the start button once it's pressed
   * @see edu.sxm5750.Model.Observer#set(int, int)
   */
  public Runnable set (final int resource, final int count) {
    return new Runnable() {
      public void run () {
        String s = MessageFormat.format(gui.getString(resource), count);
        Log.d("Code777", "set "+s);
        gui.start.setText(s);
        gui.guess.setVisibility(View.VISIBLE);
        gui.qaView.setVisibility(View.VISIBLE);
        continuation();
      }
    };
  }
  
  /*
   * Command is called when player wins. Pops an alertDialog
   * Game ends after that
   * @see edu.sxm5750.Model.Observer#win(int)
   */
  public Runnable win(final int count) {
	  return new Runnable() {
		  public void run() {
			  
			  AlertDialog.Builder win = new AlertDialog.Builder(gui);
			  win.setTitle("Congratulations!");
			  win.setMessage("Your guess is right!");
			  win.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                gui.finish();
		           }
		       });
			  win.show();
			  continuation();
		  }
	  };
  }
  
  /*
   * Command is called when player loses
   * Game ends after that.
   * @see edu.sxm5750.Model.Observer#fail(int)
   */
  public Runnable fail(final int count) {
	  return new Runnable() {
		  public void run() {
			  AlertDialog.Builder fail = new AlertDialog.Builder(gui);
			  fail.setTitle("Sorry!");
			  fail.setMessage("Your guess is wrong!");
			  fail.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                gui.finish();
		           }
		       });
			  fail.show();
		  }
	  };
  }

  /*
   * Used to generate the questions and answers along with the animation
   * @see edu.sxm5750.Model.Observer#play(int)
   */
  public Runnable play (final int resource) {
	  
	  
	    return new Runnable() {
		    public void run(){
		    	TextView question;
		    	TextView answer;
		    	Animation animation = AnimationUtils.loadAnimation(gui, R.anim.alpha);
		    	question = gui.question;
		    	answer = gui.answer;
		    	question.startAnimation(animation);
		    	answer.startAnimation(animation);
		    	
		    	
		    	animation.setAnimationListener(new AnimationListener() {
					
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
						
					}
					
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						
						continuation();
						
					}
				});
		    	
		    	
		    }
		    };
	  
  }
 

  public void execute (Runnable... command) {
	  synchronized(queue){
			int i = 0;
	    for (Runnable r: command){
	    	  
	      queue.add(r);
	      i++;
	    }
	    if (queue.size()== i && !queue.isEmpty()){
	    	queue.get(0).run();
	    }
	  }
  }
  
  /** template method. */
  protected void continuation () { 
	  synchronized(queue){
			//if (queue.isEmpty()==false){
				
				if (queue.size()!=0){
					queue.get(0).run();
				}
				
			//}
			
		}
  }
}
