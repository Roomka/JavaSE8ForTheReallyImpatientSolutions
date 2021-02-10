package chapter2;

import org.apache.commons.lang3.time.StopWatch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C2E3 {

    /** Measure the difference when counting long words with a parallelStream instead
     of a stream. Call System.currentTimeMillis before and after the call, and print the
     difference. Switch to a larger document (such as War and Peace) if you have
     a fast computer.
     * @param args
     */
    public static void main(String[] args) {
        Chapter2Utils utils = new Chapter2Utils();
        List<String> words = utils.getWordsAsList();

        System.out.println("Time required in parallel stream: " + getLongWords(words, true));
        System.out.println("Time required in sequential stream: " + getLongWords(words, false));
    }

    private static long getLongWords(List<String> words, boolean isParallel) {
        List<String> longWords;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        if (isParallel) {
            longWords = words.parallelStream()
                    .filter(w -> w.length() > 12)
                    .collect(Collectors.toList());
        } else {
            longWords = words.stream()
                    .filter(w -> w.length() > 12)
                    .collect(Collectors.toList());
        }
        stopWatch.stop();

        return stopWatch.getTime();
    }
}
