public class App {
    public static void main(String[] args) {
        Text text = new Text("Text messages are used for personal, family, " +
        "business, and social purposes. Governmental and non-governmental " + 
        "organizations use text messaging for communication between colleagues.");
        
        System.out.println(text);

        Word[] sortedText = StringOps.sortByGivenLetter(text, new Letter("p"));

        for(Word word : sortedText) {
            System.out.println(word);
        }

    }
}
