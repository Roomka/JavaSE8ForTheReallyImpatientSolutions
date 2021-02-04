package chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class C1E1Test {

    // Is the comparator code in the Arrays.sort method called in the same thread
    // as the call to sort or in a different thread?
    // Based on the following print out logic, it is called in the same thread.

    @Test
    public void testThread() {
        final long currentThreadId = Thread.currentThread().getId();
        String[] words = C1E1.getWords();
        System.out.println("Current thread before the sort: " + currentThreadId);
        C1E1.sortArrayByWordLength(words);
    }
}