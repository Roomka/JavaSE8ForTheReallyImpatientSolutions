package chapter2;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C2E2 {
    /** Verify that asking for the first five long words does not call the filter method
     once the fifth long word has been found. Simply log each method call.
     * @param args
     */
    public static void main(String[] args) {
        Chapter2Utils utils = new Chapter2Utils();
        List<String> words = utils.generateRandomStrings(1000);

        List<String> longWords = words.stream().limit(5).filter(w ->{
            System.out.println("Filter word " + w);
            return w.length() > 12;
        }).collect(Collectors.toList());
    }
}
