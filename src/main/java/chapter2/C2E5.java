package chapter2;

import java.util.stream.Stream;

public class C2E5 {

    /** Using Stream.iterate, make an infinite stream of random numbers—not by
     calling Math.random but by directly implementing a linear congruential generator.
     In such a generator, you start with x0 = seed and then produce xn + 1 =
     (a xn + c) % m, for appropriate values of a, c, and m. You should implement a
     method with parameters a, c, m, and seed that yields a Stream<Long>. Try out a =
     25214903917, c = 11, and m = 248.
     * @param args
     */
    public static void main(String[] args) {
        randomStream(
                System.currentTimeMillis(), 25214903917l, 11,
                (long) Math.pow(2, 48))
                .limit(100)
                .forEach(System.out::println);
    }

    private static Stream<Long> randomStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, e -> (a * e + c) % m);
    }
}
