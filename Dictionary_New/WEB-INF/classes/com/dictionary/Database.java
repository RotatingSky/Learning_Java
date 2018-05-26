/**
 * FileName:    Database.java
 * Copyright:   all by yourself
 */

package com.dictionary;
import java.io.*;

/**
 * A database with insert and search functions.
 * This database is a linear structure.
 * All datas can be saved in the "./data.txt" file.
 * @author      Sny
 * @since       2018-04-13
 * @version     1.20
 */
public class Database {
    // Private variables.
    private MyLinkedList<Word> words;

    /**
     * Constructor: Create a database by load datas.
     *              It can load datas from default file, which you can modify.
     *              Use linkedlist to save datas.
     * @return  none
     */
    public Database() {
        words = new MyLinkedList<Word>();
    }

    /**
     * Read datas from fileName;
     * When use web.jsp, data.txt is saved under:
     * ${CATALINA_HOME}/bin/
     * @param   fileName    File name of the data
     * @return  none
     */
    public void readData(String fileName) {
        File inFile = new File(fileName);
        if(inFile.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(inFile);
                InputStreamReader reader = new InputStreamReader(fileInputStream);
                BufferedReader bufferReader = new BufferedReader(reader);
                String line = null;
                while((line = bufferReader.readLine()) != null) {
                    String[] strArray = line.split(" ");
                    Word newWord = new Word(strArray[0], strArray[1]);
                    newWord.setTimes(Integer.valueOf(strArray[2]).intValue());
                    insert(newWord);
                }
                bufferReader.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Write datas into the data file.
     * @param fileName
     * @return none
     */
    public void writeData(String fileName) {
        try {
            File outFile = new File(fileName);
            if(!outFile.exists()) {
                outFile.createNewFile();
            }
            FileWriter writer = new FileWriter(outFile, false);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(words.toString());
            bufferWriter.flush();
            bufferWriter.close();
            writer.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert a new word into the database.
     * If the word is repeated, it will cover the previous word.
     * @param   newWord Word to insert
     * @return  none
     */
    public void insert(Word newWord) {
        boolean replaceFlag = false;
        for(int i = 0; i < words.size(); i++) {
            Word curWord = words.get(i);
            if(curWord.equals(newWord)) {
                words.set(i, newWord);
                replaceFlag = true;
                System.out.println("Replace Success!");
                break;
            }
        }
        if(!replaceFlag) {
            words.addLast(newWord);
        }
    }

    /**
     * Search the word in the database, and return whether it is success.
     * @param   findWord    Word to find
     * @return  boolean:    It has been found or not
     */
    public boolean search(Word findWord) {
        if(!findWord.getChinese().equals("")) {
            for(int i = 0; i <= words.size(); i++) {
                if(findWord.getChinese().equals(words.get(i).getChinese())) {
                    findWord.setEnglish(words.get(i).getEnglish());
                    return true;
                }
            }
        }
        if(!findWord.getEnglish().equals("")) {
            for(int i = 0; i <= words.size(); i++) {
                if(findWord.getEnglish().equals(words.get(i).getEnglish())) {
                    findWord.setChinese(words.get(i).getChinese());
                    return true;
                }
            }
        }
        // If it cannot be found.
        return false;
    }

    /**
     * Get the size of the database.
     * @return  int:    The size of the database, which is a linkedlist.
     */
    public int size() {
        return words.size();
    }

    /**
     * Get an element of database by index.
     * @param   index   Index of the word.
     * @return  Word:   Return the element of linkedlist.
     */
    public Word getWord(int index) {
        return words.get(index);
    }
}