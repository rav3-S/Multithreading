package Easy.OddEvenPrinter;

public class Printer implements Runnable{
    private SharedCounter sharedCounter;
    private int threadId;

    public Printer(SharedCounter sharedCounter, int threadId) {
        this.sharedCounter = sharedCounter;
        this.threadId = threadId;
    }

    @Override
    public void run(){
        while(true){
            synchronized (sharedCounter){
                if(sharedCounter.getCounter() %2 != threadId && sharedCounter.getCounter() <= sharedCounter.getMAX_VALUE()){
                    try {
                        sharedCounter.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(sharedCounter.getCounter() > sharedCounter.getMAX_VALUE()){
                    sharedCounter.notifyAll();
                    break;
                }
                sharedCounter.print();
                sharedCounter.notifyAll();
            }
        }
    }
}
