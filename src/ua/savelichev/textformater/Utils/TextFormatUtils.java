package ua.savelichev.textformater.Utils;

import ua.savelichev.textformater.classes.Sentence;
import ua.savelichev.textformater.classes.Word;

import java.io.*;
import java.util.*;

public class TextFormatUtils {

    private TextFormatUtils() {
    }

    public static ArrayList<Sentence> splitTextToSentences(String text){

        String text1 = text.replaceAll("\\n"," " );
        ArrayList<Sentence> sentences = new ArrayList<>();

        String[] sentenceArray = text1.toLowerCase().split("(\\.|!|\\?|\\;)\\s?");

        for (String s: sentenceArray){
            sentences.add(new Sentence(s));
        }

        return sentences;
    }

    public static ArrayList<Word> splitSentencesToWords(ArrayList<Sentence> sentences){

        ArrayList<Word> words = new ArrayList<>();

        for (Sentence sentence: sentences){
            String[] temp = sentence.getSentence().split("(\\W)\\s?");
            for (String s: temp) {
                words.add(new Word(s));
            }
        }

        return words;
    }

    public static String removeExstraSpacesAndTab(String input){

        return input.replaceAll(" +|\\t"," ");
    }


    public static ArrayList<Word> getMaxPalindrome(String text){

        ArrayList<Sentence> sentences = splitTextToSentences(text);

        ArrayList<Word> allWords = splitSentencesToWords(sentences);

        ArrayList<Word> allPalindromes = new ArrayList<Word>();

        for (Word word: allWords) {

            if(TextFormatUtils.isPalindrome(word)){
                allPalindromes.add(word);
            }
        }

        return getLongestWords(allPalindromes);
    }


    public static ArrayList<Word> getLongestWords(ArrayList<Word> words){

        ArrayList<Word> longestWordsList = new ArrayList<>();

        Collections.sort(words, lengthOrderer);

        for (Word word: words){
            if((word.getWord().length() == words.get(words.size()-1).getWord().length())){
                longestWordsList.add(word);
            }
        }

        return longestWordsList;
    }

    public static Boolean isPalindrome(Word word) {

        if (word.getWord().length()<2){
            return false;
        }
        return word.getWord().equals((new StringBuilder(word.getWord())).reverse().toString());
    }

    public static void writeFile(String outFilePath, String text){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFilePath));
            bw.write(text);
            bw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String readFile(String inFilePath){

        String output="";

        BufferedReader reader = null;
        String temp="";
        try {
            reader = new BufferedReader(new FileReader(inFilePath));

            StringBuffer str = new StringBuffer();


            while ((temp=reader.readLine())!=null){
                str.append(temp).append("\n");
            }
            reader.close();

            output=str.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;

    }


    public static Comparator<Word> lengthOrderer = new Comparator<Word>() {
        @Override
        public int compare(Word o1, Word o2) {

            if(o1.getWord().length()>o2.getWord().length()){
                return 1;
            }else if(o1.getWord().length()==o2.getWord().length()){
                return 0;
            }else return -1;
        }
    };
}
