package Model;

import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class HistoryList {
    List<History> list;

    public HistoryList() {
        this.list = new ArrayList<>();
    }
    public void addHistory(SlangWord sw){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        History history=new History(sw,now);
        list.add(history);
    }
    public void printHistoryList(){
        for (History his:list) {
            his.printHistory();
        }
    }
}