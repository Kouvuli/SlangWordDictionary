package SlangWord;

import Model.SlangWordList;

public class Main {
    public static void main(String[] args) {
        SlangWordList dictionary=new SlangWordList();
        dictionary.readFile("slang.txt");
        dictionary.findSlang("(Y)");
    }
}
