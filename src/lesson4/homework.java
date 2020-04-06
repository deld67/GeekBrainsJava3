package lesson4;

public class homework {

    public static void main(String[] args) {
        myThreadClass myClass = new myThreadClass();
        Thread t1 = new Thread(()->{myClass.printLetter('A','B');});
        Thread t2 = new Thread(()->{myClass.printLetter('B','C');});
        Thread t3 = new Thread(()->{myClass.printLetter('C','A');});
        t1.start();
        t2.start();
        t3.start();
    }
}
