package ua.savelichev.textformater;


import ua.savelichev.textformater.Utils.TextFormatUtils;
import ua.savelichev.textformater.classes.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

      private static String inFilePath=
            "D:\\Java\\IdeaWorkspace\\TextFormater\\src\\ua\\savelichev\\textformater\\files\\inputFile.txt";
      private static String outFilePath =
            "D:\\Java\\IdeaWorkspace\\TextFormater\\src\\ua\\savelichev\\textformater\\files\\outPutFile.txt";

    public static void main(String[] args) throws IOException {

        String text= TextFormatUtils.readFile(inFilePath);
        System.out.println(text);

        String withoutSpacesAndTab = TextFormatUtils.removeExstraSpacesAndTab(text);
        System.out.println(withoutSpacesAndTab);



        TextFormatUtils.writeFile(outFilePath,withoutSpacesAndTab);

        System.out.println("_____________________________________________________");

        ArrayList<Word> maxPalindromes =TextFormatUtils.getMaxPalindrome(withoutSpacesAndTab);
        System.out.println("Longest palindromes in text: ");
        for (Word word: maxPalindromes){
            System.out.println(word.getWord());
        }









    }
}
