import Enums.Mark;

public class Punctuation {
    
    private Mark mark;

    public Punctuation(Mark mark) {
        this.mark = mark;
    }

    public Punctuation(String mark) {
        this.mark = Mark.valueOf(mark);
    }

    public Punctuation(char mark) {
        this.mark = Mark.valueOf(String.valueOf(mark));
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public void setMark(String mark) {
        this.mark = Mark.valueOf(mark);
    }

    @Override public String toString() {
        return this.mark.toString();
    }
}
