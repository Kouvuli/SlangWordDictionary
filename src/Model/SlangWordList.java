package Model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class SlangWordList {
    List<SlangWord> list;

    HistoryList historyList;

    public SlangWordList() {
        list=new ArrayList<>();
        historyList=new HistoryList();
    }

    public HistoryList getHistoryList() {
        return historyList;
    }
    public List<SlangWord>getSlangWordList(){
        return list;
    }
    public SlangWord findBySlangWord (String keyword){
        for (SlangWord sw : list) {
            if (sw.getWord().equals(keyword)) {
                historyList.addHistory(sw);
                return sw;
            }
        }
        return null;
    }
    public void findByDefinition(String keyword) {
        for (SlangWord sw : list) {
            if (sw.getDefinition().contains(keyword)) {
                sw.printSlangWord();
            }
        }
    }
    public void readFile(String file_name)  {
        try{
            File fin=new File(file_name);
            FileReader fr=new FileReader(fin);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null){

                SlangWord sl=this.splitToSlangWord(line);
                list.add(sl);
            }
            fr.close();
            br.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateSlangWord(String keyword){
        SlangWord sw = null;
        do{
            try{
                sw=this.findBySlangWord(keyword);
                if (this.findBySlangWord(keyword)!=null){
                    System.out.println("Keyword da ton tai!");
                }
                System.out.println("Nhap slang word moi:");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                keyword=br.readLine();
            }catch (IOException e){

                e.printStackTrace();
            }
        }while(sw!=null);
        Scanner newScanner=new Scanner(System.in);
        System.out.println("Nhap nghia moi:");
        sw.setWord(keyword);
        sw.setDefinition(newScanner.nextLine());
    }
    private SlangWord splitToSlangWord(String st)
    {
        String[] line = st.split("`");
        SlangWord slangword = new SlangWord(line[0],line[1]);
        return slangword;
    }
}