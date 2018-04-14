/**
 * FileName:    Database.java
 * Copyright:   all by yourself
 */

import java.io.*;

/**
 * A database with insert and search functions.
 * This database is a linear structure.
 * It saves all datas in the "./data.txt" file.
 * @author      Sny
 * @since       2018-04-13
 * @version     1.00
 */
public class Database {
    // Private variables.
    private int top;
    private int dbSize;
    private int dbIncrement;
    private Word[] words;

    /**
     * Constructor: Create a database by load datas.
     *              It can load datas from default file.
     * @return  none
     */
    public Database() {
        top = -1;
        dbSize = 10;
        dbIncrement = 5;
        words = new Word[dbSize];
        readData();
    }

    /**
     * Constructor: Create a database by load datas.
     *              It can load datas from default file.
     *              It has 2 parameters to define the size of database.
     * @param   _size       Size of the array
     * @param   _increment  Increment of the array
     * @return  none
     */
    public Database(int _size, int _increment) {
        top = -1;
        dbSize = _size;
        dbIncrement = _increment;
        words = new Word[dbSize];
        readData();
    }

    /**
     * Read datas from "./data.txt".
     * @return  none
     */
    public void readData() {
        File fileName = new File("./data.txt");
        if(fileName.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                InputStreamReader reader = new InputStreamReader(fileInputStream);
                BufferedReader bufferReader = new BufferedReader(reader);
                String line = null;
                while((line = bufferReader.readLine()) != null) {
                    String[] strArray = line.split(" ");
                    Word newWord = new Word(strArray[0], strArray[1]);
                    insert(newWord);
                }
                bufferReader.close();
            }
            catch(Exception e) {
                // TODO: handle exception
            }
        }
    }

    /**
     * write datas into ./data.txt
     * @return none
     */
    public void writeData() {
        try {
            File fileName = new File("./data.txt");
            if(!fileName.exists()) {
                fileName.createNewFile();
            }
            FileWriter writer = new FileWriter(fileName, false);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for(int i = 0; i <= top; i++) {
                bufferWriter.write(words[i].getChinese() + " " + words[i].getEnglish() + "\n");
            }
            bufferWriter.flush();
            bufferWriter.close();
        }
        catch(Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * Insert a new word into the database.
     * If the word is repeated, it will cover the previous word.
     * @param   newWord Word to insert
     * @return  none
     */
    public void insert(Word newWord) {
        top++;
        if(top == dbSize) {
            dbSize += dbIncrement;
            Word[] temp = new Word[dbSize];
            for(int i = 0; i < top; i++) {
                temp[i] = words[i];
            }
            words = temp;
        }
        // Handle the repeat word.
        boolean replaceFlag = false;
        for(int i = 0; i < top; i++) {
            if(words[i].getChinese().equals(newWord.getChinese()) ||
            words[i].getEnglish().equals(newWord.getEnglish())) {
                words[i].setChinese(newWord.getChinese());
                words[i].setEnglish(newWord.getEnglish());
                System.out.println("Replace Success!");
                replaceFlag = true;
                break;
            }
        }
        if(!replaceFlag) {
            words[top] = newWord;
        }
    }

    /**
     * @param   findWord    Word to find
     * @return  boolean:    It has been found or not
     */
    public boolean search(Word findWord) {
        if(!findWord.getChinese().equals("")) {
            for(int i = 0; i <= top; i++) {
                if(findWord.getChinese().equals(words[i].getChinese())) {
                    findWord.setEnglish(words[i].getEnglish());
                    return true;
                }
            }
        }
        if(!findWord.getEnglish().equals("")) {
            for(int i = 0; i <= top; i++) {
                if(findWord.getEnglish().equals(words[i].getEnglish())) {
                    findWord.setChinese(words[i].getChinese());
                    return true;
                }
            }
        }
        // If it cannot be found.
        return false;
    }
}