package edu.sxm5750;

/**
 * Questions.java
 * @author Sudipan Mishra
 * @version 1.0
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import android.util.Log;

/**
 * My Questions class
 */
public class Questions {
	
	// Linked list to hold my 23 questions
	Queue<Integer> queueQs = new LinkedList<Integer>();
	
	// Array of question numbers
	int[] question = new int[23];
		
	
	/**
	 * Creates all questions
	 * @return a queue of questions 
	 */
	public Queue<Integer> createQuestions() {
		for(int i = 1; i <= 23; i++) {
			try {
				queueQs.add(i);
			} catch (Exception e) {
				Log.d("Code777", "Questions.java createQuestions");
			}
		}
		return queueQs;
	}
	
	/**
	 * Shuffles the array of questions
	 */
	public void shuffleArray(int[] arrayOfQuestions) {
		int n = arrayOfQuestions.length;
		
		Random random = new Random();
		random.nextInt();
		for(int i = 0; i < n; i++) {
			int change = i + random.nextInt(n-i);
			swap(arrayOfQuestions, i, change);
		}
	}
	
	/**
	 *  Another method needed to shuffle questions
	 */
	public void swap(int[] arrayOfQuestions, int i, int change) {
		int temp = arrayOfQuestions[i];
		arrayOfQuestions[i] = arrayOfQuestions[change];
		arrayOfQuestions[change] = temp;
	}
	
	/**
	 * Method to shuffle questions and return the shuffled questions.
	 * @param Queue questions - takes the questions queue to shuffle
	 * @return the shuffled queue of questions
	 * 
	 */
	public Queue<Integer> shuffleQuestions(Queue<Integer> questions) {
		int[] arrayOfQuestions = new int[23];
		
		for(int i = 0; i < 23; i++) {
			try {
				arrayOfQuestions[i] = (Integer) questions.remove();
			} catch (Exception e) {
				Log.d("Code777", "Questions.java shuffleQuestions");
			}
		}
		
		shuffleArray(arrayOfQuestions);
		
		for(int i = 0; i < arrayOfQuestions.length; i++) {
			try {
				questions.add(arrayOfQuestions[i]);
			} catch (Exception e) {
				Log.d("Code777", "Questions.java shuffleQuestions, try2");
			}
		}
		return questions;
	}	
	
	/**
	 * Compares every question number to its equivalent string
	 * so the question can be displayed.
	 * @param resourceNum - question number
	 * @return the resourceNumber of the string of question
	 * 
	 */
	public int findResource(int resourceNum) {
		int returnResNum = 0;
		if(resourceNum == 1) {
			returnResNum = R.string.q1;
		}
		else if (resourceNum == 2) {
			returnResNum = R.string.q2;
		}
		else if (resourceNum == 3) {
			returnResNum = R.string.q3;
		} 
		else if (resourceNum == 4) {
			returnResNum = R.string.q4;
		}
		else if (resourceNum == 5) {
			returnResNum = R.string.q5;
		}
		else if (resourceNum == 6) {
			returnResNum = R.string.q6;
		}
		else if (resourceNum == 7) {
			returnResNum = R.string.q7;
		} 
		else if (resourceNum == 8) {
			returnResNum = R.string.q8;
		}
		else if (resourceNum == 9) {
			returnResNum = R.string.q9;
		} 
		else if (resourceNum == 10) {
			returnResNum = R.string.q10;
		}
		else if (resourceNum == 11) {
			returnResNum = R.string.q11;
		}
		else if (resourceNum == 12) {
			returnResNum = R.string.q12;
		} 
		else if (resourceNum == 13) {
			returnResNum = R.string.q13;
		}
		else if (resourceNum == 14) {
			returnResNum = R.string.q14;
		}
		else if (resourceNum == 15) {
			returnResNum = R.string.q15;
		}
		else if (resourceNum == 16) {
			returnResNum = R.string.q16;
		}
		else if (resourceNum == 17) {
			returnResNum = R.string.q17;
		}
		else if (resourceNum == 18) {
			returnResNum = R.string.q18;
		}
		else if (resourceNum == 19) {
			returnResNum = R.string.q19;
		}
		else if (resourceNum == 20) {
			returnResNum = R.string.q20;
		}
		else if (resourceNum == 21) {
			returnResNum = R.string.q21;
		}
		else if (resourceNum == 22) {
			returnResNum = R.string.q22;
		}
		else if (resourceNum == 23) {
			returnResNum = R.string.q23;
		}
		return returnResNum;
	}
	
}

