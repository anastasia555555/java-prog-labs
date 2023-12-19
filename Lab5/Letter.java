import Enums.Symbol;

public class Letter {

    private Symbol letter;

    public Letter(Symbol letter) {
        this.letter = letter;
    }

    public Letter(String letter) {
        this.letter = Symbol.valueOf(letter);
    }

    public Letter(char character) {
        this.letter = Symbol.valueOf(String.valueOf(character));
    }

    public Symbol getLetter() {
        return letter;
    }

    public void setLetter(Symbol letter) {
        this.letter = letter;
    }

    public void setLetter(String letter) {
        this.letter = Symbol.valueOf(letter);
    }

    @Override public String toString() {
        return this.letter.toString();
    }
}