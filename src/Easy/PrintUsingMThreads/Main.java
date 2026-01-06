package Easy.PrintUsingMThreads;

public class Main {
    public static void main(String[] args) {

        SharedCounter sharedCounter = new SharedCounter(20);

        int totalThreads = 3; // You can change this to any number of threads

        for (int i = 0; i < totalThreads; i++) {
            Thread thread = new Thread(new Printer(sharedCounter, i, totalThreads), "Thread-" + i);
            thread.start();
        }
    }
}
