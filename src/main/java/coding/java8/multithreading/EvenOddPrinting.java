package coding.java8.multithreading;

import java.util.concurrent.Semaphore;

public class EvenOddPrinting {

    public static void main(String[] args) throws InterruptedException {
        Semaphore evenSemaphore=new Semaphore(0);
        Semaphore oddSemaphore=new Semaphore(1);
        Thread evenThread=new Thread(new PrintUtil(evenSemaphore,oddSemaphore,PrintCriteria.EVEN));
        Thread oddThread=new Thread(new PrintUtil(evenSemaphore,oddSemaphore,PrintCriteria.ODD));
        evenThread.start();
        oddThread.start();
        evenThread.join();
        oddThread.join();
    }

    static class PrintUtil implements Runnable{

        Semaphore evenSemaphore;
        Semaphore oddSemaphore;
        PrintCriteria criteria;


        PrintUtil(Semaphore evenSemaphore, Semaphore oddSemaphore, PrintCriteria criteria){
            this.evenSemaphore=evenSemaphore;
            this.oddSemaphore=oddSemaphore;
            this.criteria=criteria;
        }

        @Override
        public void run() {
            try {
                if (criteria==PrintCriteria.EVEN) {
                    for (int i = 0; i < 100; i += 2) {
                        evenSemaphore.acquire();
                        System.out.println(i);
                        oddSemaphore.release();
                        Thread.sleep(1000);
                    }
                } else {
                    for (int i = 1; i < 100; i += 2) {
                        oddSemaphore.acquire();
                        System.out.println(i);
                        evenSemaphore.release();
                        Thread.sleep(1000);
                    }
                }
            }
            catch (InterruptedException e){

            }
        }
    }

    enum PrintCriteria{
        EVEN, ODD
    }
}
