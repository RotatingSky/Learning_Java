/**
 * FileName:    Dictionary.java
 * Copyright:   all by yourself
 */

import java.awt.*;
import java.awt.event.*;

/**
 * Realize a dictionary which has insert and search functions.
 * @author      Sny
 * @since       2018-04-13
 * @version     1.00
 * @see         ActionListener
 */
public class Dictionary implements ActionListener {
    // Private variables.
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
     * Constructor: Create 2 frames and a database.
     * @return  none
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

    /**
     * @param   result Word to show
     * @return  none
     */
    public void insertDisplay(Word result) {
        insertChTF.setText(result.getChinese());
        insertEnTF.setText(result.getEnglish());
    }

    /**
     * @param   result  Word to show
     * @return  none
     */
    public void searchDisplay(Word result) {
        searchChTF.setText(result.getChinese());
        searchEnTF.setText(result.getEnglish());
    }

    /**
     * Realize insert and search functions.
     * @param   e   Button action event
     * @return  none
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == insertBtn) {
            Word newWord = new Word(insertChTF.getText(), insertEnTF.getText());
            dbDictionary.insert(newWord);
            dbDictionary.writeData();
        }
        else if(e.getSource() == searchBtn) {
            Word findWord = new Word(searchChTF.getText(), searchEnTF.getText());
            if(dbDictionary.search(findWord)) {
                searchDisplay(findWord);
            }
        }
    }

    /**
     * Create a Dictionary and show some information.
     * @param   args    System parameters
     * @return  none
     */
    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        Word prompt = new Word("(中文)", "(English)");
        dict.insertDisplay(prompt);
        dict.searchDisplay(prompt);
    }
}