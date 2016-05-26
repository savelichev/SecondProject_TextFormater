package ua.savelichev.textformater.classes;

/**
 * Created by savel_000 on 30.04.2016.
 */
public class Sentence {

    String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "{"+sentence + "}"+"\n";
    }
}
