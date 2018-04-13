/**
 *  FileName:       Database.java
 *  @auther         Sny
 *  @date           2018-04-13
 *  @version        1.00
 *  @description    
 */

import java.io.*;

public class Database {

    private int top;
    private int dbSize;
    private int dbIncrement;
    private Word[] words;

    public Database() {
        top = -1;
        dbSize = 10;
        dbIncrement = 5;
        words = new Word[dbSize];
        readData();
    }

    public Database(int _size, int _increment) {
        top = -1;
        dbSize = _size;
        dbIncrement = _increment;
        words = new Word[dbSize];
        readData();
    }

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
            }
            catch(Exception e) {
                // TODO: handle exception
            }
        }
    }

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
        words[top] = newWord;
    }

    public boolean search(Word findWord) {
        if(!findWord.getChinese().equals("")) {
            for(int i = 0; i <= top; i++) {
                if(findWord.getChinese().equals(words[i].getChinese())) {
                    findWord.setEnglish(words[i].getEnglish());
                    return true;
                }
            }
        }
        else if(!findWord.getEnglish().equals("")) {
            for(int i = 0; i <= top; i++) {
                if(findWord.getEnglish().equals(words[i].getEnglish())) {
                    findWord.setChinese(words[i].getChinese());
                    return true;
                }
            }
        }
        else {
            // TODO: nothing
        }
        return false;
    }
}