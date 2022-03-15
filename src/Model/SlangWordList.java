package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SlangWordList {
    List<SlangWord> list;

    public SlangWordList() {
        list=new ArrayList<>();
    }

    public boolean findSlang(String word){
        for (SlangWord sl:list) {
            if (sl.getWord().equals(word)){
                sl.printSlangWord();
                return true;
            }
        }
        return false;
    }
    public boolean isExist(String word){
        if (findSlang(word)){
            return true;
        }
        return false;
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
    private SlangWord splitToSlangWord(String st)
    {
        String[] line = st.split("`");
        SlangWord slangword = new SlangWord(line[0],line[1]);
        return slangword;
    }
}
