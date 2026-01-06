package Easy.PrintUsingMThreads;

public class Printer implements Runnable{
    private SharedCounter sharedCounter;
    private int threadId;
    private int totalThreads;

    public Printer(SharedCounter sharedCounter, int threadId, int totalThreads) {
        this.sharedCounter = sharedCounter;
        this.threadId = threadId;
        this.totalThreads = totalThreads;
    }

    @Override
    public void run(){
        while(true){
            synchronized (sharedCounter){
                while((sharedCounter.getCounter()-1) %totalThreads != threadId && sharedCounter.getCounter() <= sharedCounter.getMAX_VALUE()){
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

