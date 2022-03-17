package Model;

import java.time.LocalDateTime;
import java.util.Date;

public class History {
    SlangWord word;
    LocalDateTime dateTime;

    public void setWord(SlangWord word) {
        this.word = word;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public SlangWord getWord() {
        return word;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public History(SlangWord word, LocalDateTime dateTime) {
        this.word = word;
        this.dateTime = dateTime;
    }
    public void printHistory(){
        System.out.println(word.getWord()+"-"+word.getDefinition()+"-"+dateTime);
    }
}
