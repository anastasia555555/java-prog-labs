import java.util.ArrayList;
import java.util.List;

public class Text {
    private Sentence[] text;

    public Text(Sentence[] text) {
        this.text = text;
    }

    public Text(String text) {
        String[] sentences = text.split("(?<=[?!\\.])");
        this.text = new Sentence[sentences.length];

        for(int i = 0; i < sentences.length; i++) {
            this.text[i] = new Sentence(sentences[i]);
        }
    }

    public Sentence[] getText() {
        return this.text;
    }

    public void setText(Sentence[] text) {
        this.text = text;
    }

    public String toString() {
        String s = "";
        for(Sentence sentence : text) {
            s += sentence.toString();
        }

        return s;
    }

    public Word[] getWords() {
        List<Word> words = new ArrayList<Word>();
        for(Sentence sentence : text) {
            for (Object obj : sentence.getSentence()) {
                if(obj instanceof Word) words.add((Word)obj);
            }
        }

        Word[] result = new Word[words.size()];
        int i = 0;
        for(Word word : words) {
            result[i] = word;
            i++;
        }
        
        return result;
    }
}
