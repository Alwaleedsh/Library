
import java.util.Scanner;

import java.util.Random;

public class Hangman { 
	String[] words = { "program", "java", "csc111" };
	public Random r = new Random();
	char[] hiddenWord;
	char[] guessedWord;
	String u = pickWord();

	public Scanner input = new Scanner(System.in);

	Hangman() {
		hiddenWord = new char[u.length()];
		guessedWord = new char[u.length()];

	}

	char q;

	private int indexOf(char c) {
		for (int i = 0; i < hiddenWord.length; i++)
			if (hiddenWord[i] == c)
				return i;
		return -1;
	}

	private void setCharAt(int i, char c, char[] arr) {

		arr[i] = c;

	}

	private String pickWord() {

		return words[r.nextInt(words.length)];

	}

	private char[] copyStringToArray(String S) {

		return S.toCharArray();
	}

	private void printWord() {

		for (int i = 0; i < guessedWord.length; i++) {
			System.out.print(guessedWord[i]);
		}

	}

	private boolean isComplete() {

		for (int i = 0; i < guessedWord.length; i++) {

			if (guessedWord[i] == '*') {

				return false;
			}
		}
		return true;
	}

	private void playOneRound() {
		int f = 0;
		u = words[r.nextInt(words.length)];
		hiddenWord = copyStringToArray(u);
		guessedWord = copyStringToArray(u);

		for (int i = 0; i < guessedWord.length; i++) {

			guessedWord[i] = '*';

		}

		char q;
		do {
			int o = 0;
			System.out.print("(Guess) Enter a letter in word ");
			printWord();
			System.out.print(" > ");
			q = input.next().charAt(0);
			for (int i = 0; i < hiddenWord.length; i++) {
				if (guessedWord[i] == q) {
					o++;
					System.out.println("	" + q + " is alrady in the word");

					break;
				}

			}

			if (indexOf(q) != -1 || o == 1) {

				for (int h = 0; h < guessedWord.length; h++) {
					if (indexOf(q) != -1) {
						setCharAt(indexOf(q), q, guessedWord);
						setCharAt(indexOf(q), '$', hiddenWord);

					}
				}
			}

			else if (indexOf(q) == -1) {
				System.out.println("	" + q + " is not in the word");
				f++;

			}

			if (isComplete() == true) {
				System.out.print("The word is ");
				printWord();
				System.out.print(".");
				System.out.println(" You missed " + f + " time");

			}

		} while (isComplete() == false);

	}

	public void play() {
		System.out.println("Welcome to Hangman game. Are you ready? OK lets go!");
		String Done;
		boolean done=false;
		while(!done) {
			playOneRound();
			System.out.println("Do you want to guess another word? Enter y or n>");
			done=true; Done=input.next();
			if(Done.equalsIgnoreCase("y"))
				done=false; if(Done.equalsIgnoreCase("n"))
					                   done=true;
		}
		System.out.println("Goodbye!");
	}
	

	public String[] getWords() {
		return words;
	}

	public char[] getHiddenWord() {
		return hiddenWord;
	}


	public static void main(String[] args) {
		Hangman hm=new Hangman();
		hm.play();

	}

}
  
