package chapter1;

public class C1E11 {

    static interface I {
        default void communicate() {
            System.out.println("Here it is an email message");
        }
    }

    static interface J {
        default void communicate() {
            System.out.println("Here it is a chat message");
        }
    }

    /**
     * Suppose you have a class that implements two interfaces I and J, each of
     * which has a method void f(). Exactly what happens if f is an abstract, default,
     * or static method of I and an abstract, default, or static method of J? Repeat
     * where a class extends a superclass S and implements an interface I, each
     * of which has a method void f().
     */
    static class S implements I, J {
        @Override
        public void communicate() {
            I.super.communicate();
        }
    }
}
