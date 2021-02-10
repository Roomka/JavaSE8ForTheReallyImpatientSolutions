package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C2E6 {

    /** The characterStream method in Section 2.3, “The filter, map, and flatMap Methods,”
     on page 25, was a bit clumsy, first filling an array list and then turning it
     into a stream. Write a stream-based one-liner instead. One approach is to
     make a stream of integers from 0 to s.length() - 1 and map that with the
     s::charAt method reference.
     * @param args
     */
    public static void main(String[] args) {
        characterStreamOptimized("Test String")
                .forEach(System.out::println);

    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) result.add(c);
        return result.stream();
    }

    public static Stream<Character> characterStreamOptimized(String s) {
        return IntStream.range(0, s.length() - 1).mapToObj(s::charAt);
    }
}
