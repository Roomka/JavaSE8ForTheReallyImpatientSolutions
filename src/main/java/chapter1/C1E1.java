package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1E1 {

    public static String[] getWords() {
        return new String[]{"Programming", "Java", "Functional"};
    }

    public static void sortArrayByWordLength(String[] words) {
        Arrays.sort(words, (first, second) -> {
            System.out.println("Thread during sort algorithm: "  +
                    Thread.currentThread().getId());
            return Integer.compare(first.length(), second.length()) ;
        });
    }
}
