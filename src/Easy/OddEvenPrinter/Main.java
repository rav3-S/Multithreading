package Easy.OddEvenPrinter;

public class Main {
    public static void main(String[] args) {

        SharedCounter sharedCounter = new SharedCounter(20);

        Printer evenPrinter = new Printer(sharedCounter, 0);
        Printer oddPrinter = new Printer(sharedCounter, 1);

        Thread oddThread = new Thread(oddPrinter, "Odd-Thread");
        Thread evenThread = new Thread(evenPrinter, "Even-Thread");

        oddThread.start();
        evenThread.start();
    }
}
