/**
 *  FileName:       Word.java
 *  @auther         Sny
 *  @date           2018-04-13
 *  @version        1.00
 *  @description    
 */

public class Word {

    String chinese;
    String english;

    public Word(String ch, String en) {
        chinese = ch;
        english = en;
    }

    public String getChinese() {
        return chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setChinese(String ch) {
        chinese = ch;
    }

    public void setEnglish(String en) {
        english = en;
    }
}