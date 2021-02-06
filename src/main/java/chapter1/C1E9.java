package chapter1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C1E9 {

    private interface Collection2<T> extends Collection<T> {

        default void forEachIf(Consumer<T> action, Predicate<T> filter) {
            forEach(e -> {
                if (filter.test(e))
                    action.accept(e);
            });
        }
    }

    static class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {

    }

    /** Form a subclass Collection2 from Collection and add a default method void
     forEachIf(Consumer<T> action, Predicate<T> filter) that applies action to each
     element for which filter returns true. How could you use it?
     * @param args
     */
    public static void main(String[] args) {
        Collection2<Integer> numbers = new ArrayList2<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        List<Integer> evenNumbers = new ArrayList<>();
        numbers.forEachIf(evenNumbers::add, e -> e % 2 == 0);

        evenNumbers.forEach(e -> System.out.println(e));
    }
}
