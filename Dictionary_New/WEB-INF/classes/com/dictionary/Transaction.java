/**
 * FileName:	Transaction.java
 * Copyright:   all by yourself
 */

package com.dictionary;

/**
 * A logical layer to operate database.
 * @author		Sny
 * @since		2018-04-19
 * @version		1.20
 */
public class Transaction {
	// Privaate variable.
	private Database db;

	/**
	 * Constuctor: Create a database.
	 * @return	none
	 */
	public Transaction() {
		db = new Database();
		db.readData("data.txt");
	}

	/**
	 * Insert a new word into the database.
	 * @param	newWord
	 * @return	none
	 */
	public void insert(Word newWord) {
		newWord.setEnglish(newWord.getEnglish().toLowerCase());
		db.insert(newWord);
		db.writeData("data.txt");
	}

	/**
	 * Find the word in the database.
	 * @param	findWord
	 * @return	none
	 */
	public boolean search(Word findWord) {
		findWord.setEnglish(findWord.getEnglish().toLowerCase());
		return db.search(findWord);
	}

	/**
	 * Get the word by index.
	 * @param	index	Index of the word.
	 * @return	Word:	Return the element of linkedlist.
	 */
	public Word reciteWord(int index) {
		Word curWord = db.getWord(index);
		curWord.setTimes(curWord.getTimes() + 1);
		db.writeData("data.txt");
		return curWord;
	}

	/**
	 * Get the size of database.
	 * @return	int:	Return the size of database.
	 */
	public int getSize() {
		return db.size();
	}
}