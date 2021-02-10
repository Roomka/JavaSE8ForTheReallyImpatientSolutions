package chapter2;

import org.junit.Test;

import java.util.Iterator;
import java.util.stream.Stream;

public class C2E8 {

    /** Write a method public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
     that alternates elements from the streams first and second, stopping when
     one of them runs out of elements.
     * @param args
     */
    public static void main(String[] args) {
        Stream<String> stream = zip(Stream.of("1", "2", "3"), Stream.of("a", "b"));

        stream.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> secondIterator = second.iterator();
        Stream.Builder<T> builder = Stream.builder();
        first.forEach(e -> {
            if (secondIterator.hasNext()) {
                builder.accept(e);
                builder.accept(secondIterator.next());
            } else {
                first.close();
            }
        });
        return builder.build();
    }
}
