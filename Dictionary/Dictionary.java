/**
 *  FileName:       Dictionary.java
 *  @auther         Sny
 *  @date           2018-04-13
 *  @version        1.00
 *  @see            ActionListener
 *  @description    Realize dictionary
 */

import java.awt.*;
import java.awt.event.*;

public class Dictionary implements ActionListener {

    private Database dbDictionary;
    private Frame insertFrame;
    private Frame searchFrame;
    private Label insertChLabel;
	private Label insertEnLabel;
	private TextField insertChTF;
	private TextField insertEnTF;
    private Button insertBtn;
    private Label searchChLabel;
	private Label searchEnLabel;
    private TextField searchChTF;
	private TextField searchEnTF;
	private Button searchBtn;

    /**
     *
     */
    public Dictionary() {
        // Create 2 frames.
        insertChLabel = new Label("Chinese");
        insertEnLabel = new Label("English");
        insertChTF = new TextField(15);
		insertEnTF = new TextField(15);
        insertBtn = new Button("Insert");
        insertFrame = new Frame("Distionary-Insert");
        insertFrame.setLayout(new FlowLayout());
        insertFrame.setSize(500, 100);
        insertFrame.setVisible(true);
        insertFrame.add(insertChLabel);
        insertFrame.add(insertChTF);
        insertFrame.add(insertEnLabel);
        insertFrame.add(insertEnTF);
        insertFrame.add(insertBtn);
        searchChLabel = new Label("Chinese");
        searchEnLabel = new Label("English");
        searchChTF = new TextField(15);
		searchEnTF = new TextField(15);
		searchBtn = new Button("Search");
        searchFrame = new Frame("Distionary-Search");
        searchFrame.setLayout(new FlowLayout());
        searchFrame.setSize(500, 100);
        searchFrame.setVisible(true);
        searchFrame.add(searchChLabel);
        searchFrame.add(searchChTF);
        searchFrame.add(searchEnLabel);
        searchFrame.add(searchEnTF);
        searchFrame.add(searchBtn);
        // Add button action listeners.
        insertBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        // Add exit function.
        insertFrame.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        searchFrame.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        // Create database.
        dbDictionary = new Database();
    }

    public void displayWord(Word result) {
        searchChTF.setText(result.getChinese());
        searchEnTF.setText(result.getEnglish());
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == insertBtn) {
            Word newWord = new Word(insertChTF.getText(), insertEnTF.getText());
            dbDictionary.insert(newWord);
            dbDictionary.writeData();
        }
        else if(e.getSource() == searchBtn) {
            Word findWord = new Word(searchChTF.getText(), searchEnTF.getText());
            if(dbDictionary.search(findWord)) {
                displayWord(findWord);
            }
        }
    }

    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
    }
}