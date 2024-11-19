package Day8.map_examples;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequencyApplication {

    public static void main(String[] args) {

        String[] words = {"a", "abc", "ab", "limit", "ab", "a", "ab", "1a", "limit", "a", "a", "a", "1a"}; // a - 5 раз, ab - 3 раза, limit - 2 раза

        printWordFrequency(words);


    }//end main

    private static void printWordFrequency(String[] words) {
        // Key - это слово, value - сколько раз оно попало в массив
        Map<String,Integer> resultMap = new HashMap<>();

        for (String word : words) {
            if(!resultMap.containsKey(word)){ // когда "значение ключа" попалось впервые
                resultMap.put(word,1);
            }else{ // когда ключ "значение ключа" уже есть
                resultMap.put(word,resultMap.get(word) + 1);
            }
        }//end for

        for (String word : resultMap.keySet()) {
            System.out.println("Word: " + word + ", frequency: " + resultMap.get(word));
        }

    }//end printWordFrequency


}//end class
