package Question1;
/*
create a file story.txt and put some text into it. read that file and find the frequency of each word in the file in the
and print it
Ex:
story.txt
life is full of fun life is full of fun life is full of fun life
O/P:
life appear 4 times is appear 3 times
.....
......

 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FrequencyOfWord {
    public static void main(String[] args) {

        HashMap<String, Integer> wordMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("story.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                // Insert this in to the HashMap
                for (String word : words) {
                    if (word != null) {
                        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                    }
                }
                //Print the key Value pair in map
                for (String key : wordMap.keySet()) {
                    System.out.println(key + " appear " + wordMap.get(key) + " times");
                }
                //Print the frequency of each word
//                for (String word : words) {
//                    int count = 0;
//                    for (String w : words) {
//                        if (word.equalsIgnoreCase(w)) {
//                            count++;
//                        }
//                    }
//                    System.out.println(word + " appear " + count + " times");
//                }
            }
        }
//        catch(FileNotFoundException e){
//            System.out.println(e);
//        }
        catch ( IOException e) {
            System.out.println(e);
                    }


    }
}
