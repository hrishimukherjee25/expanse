import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        
        File file;
        Scanner reader;

        ArrayList<String> allText = new ArrayList<String>();

        System.out.println(allText);
        
        try {
            file = new File("src/text.txt");
            System.out.println("File created.");
            reader = new Scanner(file);
            System.out.println("Reader created.");
            while(reader.hasNextLine()) {
                String data = reader.nextLine();
                allText.add(data);
                System.out.println("Extracted text.");
            }
            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println("The file was not found.");
            e.printStackTrace();
        }

        for(String text: allText) {
            System.out.print(text);
        }

        ArrayList<String> allWords = new ArrayList<String>();

        System.out.println();
        System.out.println(allWords);

        // O(n^2)
        for(String text: allText) {
            List<String> words = Arrays.asList(text.split(" "));

            for(String word: words) {
                allWords.add(word);
            }
        }

        System.out.println(allWords);

        // Put in distinct HashMap
        HashMap<String, Integer> distinct = new HashMap<String, Integer>();

        System.out.println(distinct);

        for(String word: allWords) {
            System.out.println(distinct.containsKey(word));
            if(distinct.containsKey(word)) {
                int val = distinct.get(word);
                val++;
                distinct.put(word, val);
            } else {
                distinct.put(word, 0);
            }
        }

        //System.out.println(distinct);

        for(Map.Entry<String, Integer> entry : distinct.entrySet()) {
            String word = entry.getKey();
            Integer count = entry.getValue();

            System.out.println(word + " : " + count);
        }
        
        System.out.println("Fin.");
    }
}