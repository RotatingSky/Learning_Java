/**
 * FileName:    Word.java
 * Copyright:   all by yourself
 */

package com.dictionary;

/**
 * Word type for element data.
 * @author      Sny
 * @since       2018-04-13
 * @version     1.00
 */
public class Word {
    // Private variables.
    String chinese;
    String english;

    /**
     * Constructor: Create a new word.
     * @param   ch  Chinese string
     * @param   en  English string
     * @return  none
     */
    public Word(String ch, String en) {
        chinese = ch;
        english = en;
    }

    /**
     * Get Chinese string of the word.
     * @return  Chinese string
     */
    public String getChinese() {
        return chinese;
    }

    /**
     * Get English string of the word.
     * @return  English string
     */
    public String getEnglish() {
        return english;
    }

    /**
     * Set Chinese string of the word.
     * @param   ch  Chinese string
     * @return  none
     */
    public void setChinese(String ch) {
        chinese = ch;
    }

    /**
     * Set English string of the word.
     * @param   en  English string
     * @return  none
     */
    public void setEnglish(String en) {
        english = en;
    }
}