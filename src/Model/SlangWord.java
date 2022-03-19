package Model;


import java.io.*;
import java.util.Map;

public class SlangWord {
    Map.Entry<String,SlangDefinition> slangWord;

    public SlangWord(Map.Entry<String, SlangDefinition> slangWord) {
        this.slangWord = slangWord;
    }

    public Map.Entry<String, SlangDefinition> getSlangWord() {
        return slangWord;
    }
    public SlangDefinition getVal(){
        return slangWord.getValue();
    }
    public void setSlangWord(Map.Entry<String, SlangDefinition> slangWord) {
        this.slangWord = slangWord;
    }
}
