package coding.java8.multithreading;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/*
 * executorService.submit(Runnable/Callable) -> Non Blocking
 * executorService.invokeAll(Collection) -> Blocking until all tasks completed
 */
public class ExecutorTest {
    public static void main(String[] args) {
        new ExecutorTest().test();
    }

    public void test(){
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(3);

            Future<Integer> future = executorService.submit(new FactorialTask(5)); // NOT Blocking
            System.out.println("Executing single task");
            System.out.println(future.get());

            System.out.println("--------------");
            for (int i = 1; i < 15; i++) {
                executorService.submit(new FactorialTask(i)); // Non Blocking
            }
            System.out.println("all tasks submitted");

            System.out.println("---------------");
            System.out.println("Invoking tasks");
            Set<Callable<Integer>> callableSet = new HashSet<>();
            for (int i = 1; i < 15; i++) {
                callableSet.add(new FactorialTask(i));
            }

            List<Future<Integer>> futureList = executorService.invokeAll(callableSet); // BLOCKING: Executes the given tasks, returning a list of Futures holding their status and results when all complete.
            System.out.println("all tasks invoked");
            for (Future<Integer> integerFuture : futureList){
                System.out.println(integerFuture.get());
            }
            executorService.shutdown();
            System.out.println(executorService.isShutdown());
        }
        catch (InterruptedException | ExecutionException e){

        }
    }

    class FactorialTask implements Callable<Integer>{
        private int num;

        FactorialTask(int num){
            this.num=num;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            int n = factorial(num);
            System.out.println(num+" -> "+n+" "+Thread.currentThread().getName());
            return n;
        }

        private int factorial(int n){
            if(n==0 || n==1)    return n;
            return n * factorial(n-1);
        }
    }
}
