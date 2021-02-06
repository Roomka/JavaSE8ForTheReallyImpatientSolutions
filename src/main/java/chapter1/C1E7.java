package chapter1;

public class C1E7 {

    public static Runnable andThen(Runnable r1, Runnable r2) {
        Runnable resultRunnable = () -> {
            r1.run();
            r2.run();
        };
        return resultRunnable;
    }

    /** Write a static method andThen that takes as parameters two Runnable instances
     and returns a Runnable that runs the first, then the second. In the main method,
     pass two lambda expressions into a call to andThen, and run the returned
     instance.
     * @param args
     */
    public static void main(String[] args) {
        C1E7.andThen(
                () -> System.out.println("This is the first runnable code."),
                () -> System.out.println("This is the second runnable code.")
        ).run();
    }
}


