import java.util.Arrays;

class StringOperations{
    public static void main(String[] args){

        // Тип - String
        // Відсортувати слова заданого тексту за зростанням кількості в них заданої літери.

        String input = "Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or another type of compatible computer.";
        char givenLetter = 't';
        String delimiter = "\\s+";
        String  punctuation = "[,._?!/\\]";
        
        try{
            String[] words = input.replaceAll(punctuation, "").split(delimiter);
            Arrays.sort(words, (word1, word2) -> countLetterEntries(word1, givenLetter) - countLetterEntries(word2, givenLetter));
            System.out.println("Sorted text: ");
            printStringArray(words); 
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
       
    }
    

    private static int countLetterEntries(String word, char givenLetter) {
        int count = 0;
        for (char letter : word.toCharArray()) {
            if (letter == givenLetter) {
                count++;
            }
        }
        return count;
    }

    private static void printStringArray(String[] array) {
        for (String element : array) {
            System.out.println(element);
        }
    }

}
