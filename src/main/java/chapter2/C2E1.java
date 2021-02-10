package chapter2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class C2E1 {

    private static long countConcurrentWithoutStreams() {
        try {
            Chapter2Utils utils = new Chapter2Utils();
            List<String> words = utils.generateRandomStrings(1000);

            int cores = Runtime.getRuntime().availableProcessors();
            int chunkSize = words.size() / cores;

            List<List<String>> chunks = new LinkedList<>();
            for (int i = 0; i < words.size(); i += chunkSize) {
                chunks.add(words.subList(i, i + Math.min(chunkSize, words.size() - i)));
            }

            ExecutorService pool = Executors.newFixedThreadPool(cores);
            Set<Future<Long>> set = new HashSet<>();

            for (List<String> strings : chunks) {
                Callable<Long> callable = () -> {
                    long chunkCount = 0;
                    for (String string : strings) {
                        if (string.length() > 12) chunkCount++;
                    }
                    return chunkCount;
                };
                Future<Long> future = pool.submit(callable);
                set.add(future);
            }

            long count = 0;
            for (Future<Long> future : set) {
                count += future.get();
            }
            pool.shutdown();
            return count;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /** Write a parallel version of the for loop in Section 2.1, “From Iteration to
     Stream Operations,” on page 22. Obtain the number of processors. Make that
     many separate threads, each working on a segment of the list, and total up
     the results as they come in. (You don’t want the threads to update a single
     counter. Why?)
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(countConcurrentWithoutStreams());
    }
}
