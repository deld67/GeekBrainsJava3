package lesson4;

public class myThreadClass {
    private final Object mon = new Object();
    private final static int COUNT_PRINT = 5;
    private volatile char curLetter = 'A';

    public void printLetter(char myLetter, char nextLetter){
        synchronized (mon){
            try{
                for (int i = 0; i < COUNT_PRINT; i++) {
                    while (curLetter != myLetter) {
                        mon.wait();
                    }
                    System.out.print(myLetter);
                    curLetter = nextLetter;
                    mon.notifyAll();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
