import java.util.Arrays;

public class StringOps {
    // Тип - String
    // Відсортувати слова заданого тексту за зростанням кількості в них заданої літери.

    public static Word[] sortByGivenLetter(Text text, Letter letter) {
        Word[] words = text.getWords();
        Arrays.sort(words, (word1, word2) -> 
        countLetterEntries(word2, letter) - countLetterEntries(word1, letter));
        return words;
    }
    
    private static int countLetterEntries(Word word, Letter givenLetter) {
        int count = 0;
        for (Letter letter : word.getWord()) {
            if (letter.getLetter().equals(givenLetter.getLetter())) {
                count++;
            }
        }
        return count;
    }
}
