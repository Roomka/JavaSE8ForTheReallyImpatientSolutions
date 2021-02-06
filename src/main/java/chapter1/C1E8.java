package chapter1;

import java.util.ArrayList;
import java.util.List;

public class C1E8 {

    /** What happens when a lambda expression captures values in an enhanced
     for loop such as this one?
     String[] names = { "Peter", "Paul", "Mary" };
     List<Runnable> runners = new ArrayList<>();
     for (String name : names)
     runners.add(() -> System.out.println(name));
     Is it legal? Does each lambda expression capture a different value, or do they
     all get the last value? What happens if you use a traditional loop for (int i = 0;
     i < names.length; i++)?
     Answer question 1: this is perfectly legal as can be seen by executing the method, it will capture the valuse of names.
     Answer question 2: this is not legal, as in the tradition for loop i index is not final.
     * @param args
     */
    public static void main(String[] args) {
        String[] names = { "Peter", "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();
        for (String name : names)
            runners.add(() -> System.out.println(name));

        runners.forEach(runner -> runner.run());
    }
}
