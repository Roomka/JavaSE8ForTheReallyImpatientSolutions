package chapter1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C1E5 {

    public static class HiMessage implements Runnable {

        @Override
        public void run() {
            System.out.println("Hi from thread " + Thread.currentThread().getId());
        }
    }

    public static void runnableLambda() {
        Runnable hiMessage = () -> System.out.println("Hi from thread " + Thread.currentThread().getId());;

        new Thread(hiMessage).start();
    }

    public static class ActionListenerExample implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }

    /** Take a file from one of your projects that contains a number of ActionListener,
     Runnable, or the like. Replace them with lambda expressions. How many lines
     did it save? Was the code easier to read? Were you able to use method
     references?
     * @param args
     */
    public static void main(String[] args) {
        // Runnable Java 7 Way
        Runnable hiMessage = new HiMessage();
        hiMessage.run();

        // Runnable Java 8 With Lambda
        C1E5.runnableLambda();

        // Action Listener Example Java 7 way
        ActionListener actionListener = new ActionListenerExample();
        int uniqueId = (int) System.currentTimeMillis();
        actionListener.actionPerformed(new ActionEvent(actionListener, uniqueId, "Java 7 Command"));

        // Action Listener Example Java 8 Lambda
        ActionListener customActionListener = (actionEvent) -> {
            System.out.println(actionEvent.getActionCommand());
        };
        customActionListener.actionPerformed(new ActionEvent(actionListener, uniqueId, "Java 8 Lambda"));
    }
}
