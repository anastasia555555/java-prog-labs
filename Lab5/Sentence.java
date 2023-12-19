import Enums.Symbol;
import java.util.ArrayList;
import java.util.List;

import Enums.Mark;

public class Sentence {

    private List<Object> sentence;
    
    public Sentence(List<Object> sentence) {
        for(Object obj : sentence){
            if(!(obj instanceof Word) || !(obj instanceof Punctuation)) {
                this.sentence = null;
                return;
            }
            this.sentence = sentence;
        }
    }

    public Sentence(String sentence) {
        this.sentence = new ArrayList<Object>();
        String currentWord = "";
        Mark currentMark;
        int markCounter = 0;

        for(int i = 0; i < sentence.length(); i++){
            if (Symbol.valueOfOrNull(sentence.charAt(i)) != null) {
                currentWord += Symbol.valueOfOrNull(sentence.charAt(i));
                continue;
            }

            if (Mark.valueOfOrNull(sentence.charAt(i)) != null) {
                currentMark = Mark.valueOfOrNull(sentence.charAt(i));
                
                if(!currentWord.isEmpty()) {
                    this.sentence.add(new Word(currentWord));
                    currentWord = "";
                    markCounter = 0;
                }
                
                if (currentMark != Mark.EMPTY_SPACE || markCounter == 0) {
                    this.sentence.add(new Punctuation(currentMark));
                    markCounter = 0;
                }
                
                if (currentMark == Mark.EMPTY_SPACE) {
                    markCounter++;
                }
            }
        }
    }

    @Override public String toString() {
        String s = "";
        for(Object obj : sentence) {
            s += obj.toString();
        }
        return s;
    }

    public List<Object> getSentence() {
        return this.sentence;
    }

    public void setSentence(List<Object> sentence) {
        for(Object obj : sentence){
            if(!(obj instanceof Word) || !(obj instanceof Punctuation)) {
                this.sentence = null;
                return;
            }
        }
        this.sentence = sentence;
    }
}