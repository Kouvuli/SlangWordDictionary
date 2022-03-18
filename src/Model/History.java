package Model;

import java.time.LocalDateTime;
import java.util.Date;

public class History {
    String word;
    String dateTime;

    public History(String word, String dateTime) {
        this.word = word;
        this.dateTime = dateTime;
    }

    public void printHistory(){
        System.out.println(word+" ("+dateTime+")");
    }
}
