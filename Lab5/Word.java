public class Word {

    private Letter[] word;

    public Word(Letter[] letters){
        this.word = letters;
    }

    public Word(String letters){
        word = new Letter[letters.length()];
        for (int i = 0; i < letters.length(); i++) {
            word[i] = new Letter(letters.charAt(i));
        }
    }

    public Letter[] getWord() {
        return word;
    }

    public void setWord(Letter[] newWord) {
        this.word = newWord;
    }

    @Override public String toString() {
        String s = "";
        for(int i = 0; i < word.length; i++) {
            s += word[i].toString();
        }
        return s;
    }
}
