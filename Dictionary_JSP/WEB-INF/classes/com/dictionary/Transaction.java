/**
 * FileName:	Transaction.java
 * Copyright:   all by yourself
 */

package com.dictionary;

/**
 * A logical layer to operate database.
 * @author		Sny
 * @since		2018-04-19
 * @version		1.10
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
	}

	/**
	 * @param	newWord
	 * @return	none
	 */
	public void insert(Word newWord) {
		newWord.setEnglish(newWord.getEnglish().toLowerCase());
		db.insert(newWord);
		db.writeData();
	}

	/**
	 * @param	findWord
	 * @return	none
	 */
	public boolean search(Word findWord) {
		findWord.setEnglish(findWord.getEnglish().toLowerCase());
		return db.search(findWord);
	}
}