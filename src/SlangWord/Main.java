package SlangWord;

import Model.SlangDefinition;
import Model.SlangWord;
import Model.SlangWordList;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            SlangWordList dictionary=new SlangWordList();
            dictionary.readFile("slang.txt");

            int selection;
            do {
                printMenu();
                System.out.println("Nhap lua chon cua ban:");
                Scanner sc=new Scanner(System.in);
                selection=sc.nextInt();

                switch (selection){
                    case 1:{
                        Scanner scanner=new Scanner(System.in);
                        System.out.println("Nhap slang word:");
                        String keyword=scanner.nextLine();
                        Map.Entry<String, SlangDefinition> entry = dictionary.findBySlangWord(keyword);
                        if (entry!=null){
                            System.out.println(keyword+":"+entry.getValue().getListDefinitions());
                            dictionary.getHistoryList().addWordHistory(entry.getKey());
                        }
                        else{
                            System.out.println("Khong tim thay tu can tim!");
                        }
                        break;
                    }
                    case 2:{
                        Scanner scanner=new Scanner(System.in);
                        System.out.println("Nhap keyword:");
                        String keyword=scanner.nextLine();
                        dictionary.findByDefinition(keyword);
                        break;
                    }
                    case 3:{
                        dictionary.getHistoryList().printHistoryList();
                        break;
                    }
//                    case 4:{
//                        Scanner scanner=new Scanner(System.in);
//                        System.out.println("Nhap keyword moi:");
//                        String keyword=scanner.nextLine();
//                        Map.Entry<String, SlangDefinition> sw=dictionary.findBySlangWord(keyword);
//                        if (sw!=null){
//                            int sel = 0;
//                            System.out.println("Tu da ton tai!");
//                            System.out.println("Chon 1 de ghi de");
//                            System.out.println("Chon 2 de ghi nghia moi");
//                            System.out.println("Nhap lua chon:");
//                            sel=scanner.nextInt();
//                            switch (sel){
//                                case 1:{
//
//                                    String newKeyword="";
//                                    do{
//                                        try{
//                                            System.out.println("Nhap Slang Word:");
//                                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                                            newKeyword=br.readLine();
//                                            if (dictionary.findBySlangWord(newKeyword)!=null){
//                                                System.out.println("Keyword da ton tai!");
//                                            }
//
//                                        }catch (IOException e){
//                                            e.printStackTrace();
//                                        }
//                                    }
//                                    while(dictionary.findBySlangWord(newKeyword)!=null);
//                                    Scanner newScanner=new Scanner(System.in);
//                                    System.out.println("Nhap nghia moi:");
//                                    dictionary.removeSlangWord(keyword);
//                                    dictionary.addNewSlangWord(newKeyword,newScanner.nextLine());
//                                    System.out.println("Nothing");
//                                    break;
//                                }
//                                case 2:{
//                                    System.out.println("Nhap nghia moi:");
//                                    Scanner newScanner=new Scanner(System.in);
//                                    String newDefinition=newScanner.nextLine();
//                                    sw.getValue().addDefinition(newDefinition);
//                                    break;
//                                }
//                                default:{
//                                    System.out.println("Nhap sai lua chon");
//                                    break;
//                                }
//                            }
//                        }
//                        else{
//                            System.out.println("Nhap nghia moi:");
//                            String newDefinition=scanner.nextLine();
//                            SlangDefinition newDefList=new SlangDefinition();
//                            newDefList.addDefinition(newDefinition);
//                            dictionary.getDictionary().put(keyword,newDefList);
//
//                        }
//                        System.out.println(dictionary.getDictionary().get("IOUU"));
//                        break;
//                    }
//                    case 5:{
//                        Scanner scanner=new Scanner(System.in);
//                        System.out.println("Nhap keyword:");
//                        String keyword=scanner.nextLine();
//                        dictionary.updateSlangWord(keyword);
//
//
//                    }
                }
            }while (selection<=10&&selection>=1);
        }
        public static void printMenu(){
            System.out.println("Chon 1 de tim kiem theo slang word");
            System.out.println("Chon 2 de tim kiem theo definition");
            System.out.println("Chon 3 de hien thi lich su tim kiem");
            System.out.println("Chon 4 de add 1 slang word moi");
            System.out.println("Chon 5 de edit 1 slang word");
            System.out.println("Chon 6 de delete 1 slang word");
            System.out.println("Chon 7 de reset ve danh sach slang word goc");
            System.out.println("Chon 8 de random 1 slang word");
            System.out.println("Chon 9 de thuc hien chuong trinh do slang word");
            System.out.println("Chon 10 de thuc hien chuong trinh do definition");
        }

    }