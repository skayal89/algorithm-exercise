package coding.java8.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
Why should wait() always be called inside a loop?
You need not only to loop it but check your condition in the loop. Java does not guarantee that
your thread will be woken up only by a notify()/notifyAll() call or the right notify()/notifyAll()
call at all. Because of this property the loop-less version might work on your development
environment and fail on the production environment unexpectedly.
 */
public class ProducerConsumerSemaphore {
    static Queue<Integer> messageQueue;

    static class Producer implements Runnable{
        @Override
        public void run() {
            try {
                Random r=new Random(500);
                while (true){
                    synchronized (messageQueue) { // the object, on which wait-notify will be called, need to be synchronized
                        while (messageQueue.size() >= 2) {
                            System.out.println("Producer waiting..");
                            messageQueue.wait(); // wait-notify can be called on a object only
                        }
                        messageQueue.add(r.nextInt()%50);
                        System.out.println("Produced:" + messageQueue);
                        messageQueue.notifyAll();
                        Thread.sleep(800);
                    }
                }

            }
            catch (InterruptedException e){}
        }
    }

    static class Consumer implements Runnable{
        @Override
        public void run() {
            try {
                while(true) {
                    synchronized (messageQueue) {
                        while (messageQueue.size() == 0) {
                            System.out.println("Consumer waiting..");
                            messageQueue.wait();
                        }
                        System.out.println("Consumed:" + messageQueue.poll()+" "+messageQueue);
                        messageQueue.notifyAll();
                        Thread.sleep(1000);
                    }
                }
            }
            catch (InterruptedException e){}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        messageQueue=new LinkedList<>();
        Thread producer1=new Thread(new Producer());
        Thread producer2=new Thread(new Producer());
        Thread consumer=new Thread(new Consumer());
        producer1.start();
        producer2.start();
        consumer.start();

        producer1.join();
        producer2.join();
        consumer.join();
    }
}
