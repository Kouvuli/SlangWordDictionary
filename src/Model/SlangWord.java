package Model;


import java.io.*;

public class SlangWord {
    String Word;
    String Definition;

    public SlangWord(String word, String definition) {
        Word = word;
        Definition = definition;
    }

    public String getWord() {
        return Word;
    }

    public String getDefinition() {
        return Definition;
    }

    public void setWord(String word) {
        Word = word;
    }

    public void setDefinition(String definition) {
        Definition = definition;
    }

    public void printSlangWord(){
        System.out.println(Word+":"+Definition);
    }
}
