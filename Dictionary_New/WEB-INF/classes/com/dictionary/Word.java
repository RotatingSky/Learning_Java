/**
 * FileName:    Word.java
 * Copyright:   all by yourself
 */

package com.dictionary;

/**
 * Word type for element data.
 * @author      Sny
 * @since       2018-04-13
 * @version     1.20
 */
public class Word {
    // Private variables.
    private String chinese;
    private String english;
    private int times;

    /**
     * Constructor: Create a new word.
     * @param   ch  Chinese string
     * @param   en  English string
     * @return  none
     */
    public Word(String ch, String en) {
        this.chinese = ch;
        this.english = en;
        this.times = 0;
    }

    /**
     * Get Chinese string of the word.
     * @return  Chinese string
     */
    public String getChinese() {
        return this.chinese;
    }

    /**
     * Get English string of the word.
     * @return  English string
     */
    public String getEnglish() {
        return this.english;
    }

    /**
     * Set Chinese string of the word.
     * @param   ch  Chinese string
     * @return  none
     */
    public void setChinese(String ch) {
        this.chinese = ch;
    }

    /**
     * Set English string of the word.
     * @param   en  English string
     * @return  none
     */
    public void setEnglish(String en) {
        this.english = en;
    }

    /**
     * Convert Word to a String.
     * @return  String of this word.
     */
    public String toString() {
        return (this.chinese + " " + this.english + " " + this.times);
    }

    /**
     * Check whether 2 words are equivalent.
     * @param   obj     Another word.
     * @return  A boolean value of flag.
     */
    public boolean equals(Object obj) {
        if(obj instanceof Word) {
            Word curWord = (Word)obj;
            return (curWord.getChinese().equals(this.chinese) 
            || curWord.getEnglish().equals(this.english));
        }
        return false;
    }

	/**
     * Get the times of reciting the word.
	 * @return  The times
	 */
	public int getTimes() {
		return this.times;
	}

	/**
     * Set the times of reciting the word.
	 * @param   times   The times to set
     * @return  none
	 */
	public void setTimes(int times) {
		this.times = times;
    }
}