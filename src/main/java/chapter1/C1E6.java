package chapter1;

import java.util.concurrent.Callable;

public class C1E6 {

    /** Didn’t you always hate it that you had to deal with checked exceptions in a
     Runnable? Write a method uncheck that catches all checked exceptions and turns
     them into unchecked exceptions.
     For example,
     new Thread(uncheck(
     () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
     // Look, no catch (InterruptedException)!
     Hint: Define an interface RunnableEx whose run method may throw any exceptions.
     Then implement public static Runnable uncheck(RunnableEx runner). Use a
     lambda expression inside the uncheck function.

     Why can’t you just use Callable<Void> instead of RunnableEx?
     Callable<Void> requires a return type, it could be used but the Run lambda implementation would require
     a return method call.


     * @param args
     */
    public static void main(String[] args) {
        new Thread(
                uncheck(
                    () -> {
                        System.out.println("ZZZ");
                        Thread.sleep(1000);
                        }
                    )
        ).start();
    }

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try{
                runner.run();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        };
    }

    public static Runnable uncheckCallable(Callable<Void> callable) {
        return () -> {
            try{
                callable.call();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        };
    }
}

@FunctionalInterface
interface RunnableEx {

    void run() throws Exception;
}