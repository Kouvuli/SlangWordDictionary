package Model;


import java.io.*;

public class SlangWord {
    String Word;
    String Defination;

    public SlangWord(String word, String defination) {
        Word=word;
        Defination=defination;
    }

    public void setWord(String word) {
        Word = word;
    }

    public void setDefination(String defination) {
        Defination = defination;
    }

    public String getWord() {
        return Word;
    }

    public String getDefination() {
        return Defination;
    }
    public void printSlangWord(){
        System.out.println(Word+" "+Defination);
    }
}
