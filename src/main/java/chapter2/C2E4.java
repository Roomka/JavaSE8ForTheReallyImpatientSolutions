package chapter2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C2E4 {

    /** Suppose you have an array int[] values = { 1, 4, 9, 16 }. What is
     Stream.of(values)? How do you get a stream of int instead?

     IntStream.of() returns an IntStream.
     IntStream has boxed value to transform a IntStream into a Stream<Integer>


     * @param args
     */
    public static void main(String[] args) {
        int[] values = { 1, 4, 9, 16 };

        IntStream stream = IntStream.of(values);
        Stream<Integer> integerStream = stream.boxed();
    }
}
