package Model;
import java.io.*;
import java.util.*;

public class SlangWordList {
//    List<SlangWord> list;
    HashMap<String,SlangDefinition> dictionary;
    HistoryList historyList;

    public SlangWordList() {

        dictionary=new HashMap<String,SlangDefinition>();
        historyList=new HistoryList();
    }

    public HistoryList getHistoryList() {
        return historyList;
    }
    public HashMap<String,SlangDefinition>getDictionary(){
        return dictionary;
    }
    public void addNewSlangWord(String key,String definition){
        SlangDefinition definitions = new SlangDefinition();
        definitions.addDefinition(definition);
        dictionary.put(key,definitions);
    }
    public void removeSlangWord(String key){
        dictionary.remove(key);
    }
    public void overwriteSlangWord(String key,String def){
        SlangDefinition definitions=new SlangDefinition();
        definitions.addDefinition(def);
        dictionary.replace(key,definitions);
    }
    public Map.Entry<String,SlangDefinition> findBySlangWord (String keyword){
        for (Map.Entry<String, SlangDefinition> entry : dictionary.entrySet()) {
            if (entry.getKey().toLowerCase().trim().equals(keyword.toLowerCase().trim())){
                String str=entry.getValue().getListDefinitions();
                return entry;
            }
        }
        return null;
    }
    public void findByDefinition(String keyword) {
        List<String>keyList=new ArrayList<>();
        for (Map.Entry<String, SlangDefinition> entry : dictionary.entrySet()) {

            String key= entry.getKey();
            SlangDefinition value=entry.getValue();
            if(value.isContain(keyword)){
                keyList.add(key);
            }
        }
        System.out.println(String.join("| ",keyList));
        historyList.addDefHistory(keyword,keyList);
    }

    public void addDefinition(String keyword,String def){
        dictionary.get(keyword).addDefinition(def);

    }
    public void readFile(String file_name)  {
        try{
            File fin=new File(file_name);
            FileReader fr=new FileReader(fin);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null){
                String word = null;
                SlangDefinition def=new SlangDefinition();
                String[] str = line.split("`");
                word=str[0];
                for (String s:str[1].split("\\|")) {
                    def.addDefinition(s);
                }
                dictionary.put(word,def);
//                list.add(sl);
            }
            fr.close();
            br.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private List<String> splitToSlangWord(String st,String word,SlangDefinition sd)
//    {
//        String[] line = st.split("`");
//        word=line[0];
//        SlangWord slangword = new SlangWord(line[0],line[1]);
//        for (String s:line[1].split("|")) {
//            sd.addDefinitions(s);
//        }
//
//    }
}