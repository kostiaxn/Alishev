package CallableAndFuture;

import java.util.Random;
import java.util.concurrent.*;

public class Test {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // когда поток закончит, результат будет в future
        Future<Integer> future = executorService.submit(() -> { // если мы что-то возвращаем, то лямда использует Callable,
            // если не возвращаем, то Runnable
            System.out.println("Starting");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Finished");
            Random random = new Random();
            int randomValue = random.nextInt();
            if(randomValue < 5)
                throw new Exception("Something bad happened");

            return random.nextInt(10);
        });

        executorService.shutdown();
        try {
            int result = future.get(); // get дожидается окончания выполнения потока
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}