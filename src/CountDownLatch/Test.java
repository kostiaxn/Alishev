package CountDownLatch;

/**
 * Этот код демонстрирует использование класса CountDownLatch из библиотеки java.util.concurrent для синхронизации выполнения потоков.
 *
 * В методе main() создается объект CountDownLatch с начальным значением 3. Затем создается пул потоков с помощью Executors.newFixedThreadPool(), состоящий из 3 потоков, и для каждого потока создается объект Processor с идентификатором и объектом CountDownLatch. После этого вызывается метод shutdown() для пула потоков, чтобы он больше не принимал новые задачи.
 *
 * Далее в цикле вызывается метод countDown() у объекта CountDownLatch, что означает, что потоки могут продолжить свою работу, когда это метод будет вызван 3 раза (так как начальное значение счетчика было 3). Внутри каждого потока вызывается метод await() объекта CountDownLatch, который заставляет поток ждать, пока значение счетчика не станет равным нулю.
 *
 * Таким образом, программа запускает 3 потока, которые ждут выполнения метода countDown() 3 раза, после чего каждый из них завершает свою работу и выводит сообщение в консоль. Задержка в 3 секунды перед вызовом countDown() позволяет убедиться в том, что потоки действительно ожидают вызова метода countDown().
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3); // сколько раз должны вызвать метод countDown чтобы await больше не ждал
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(i, countDownLatch));
        }
        executorService.shutdown();

        for (int i = 0; i < 3; i++) {
            Thread.sleep(3000);
            countDownLatch.countDown();
        }


    }
}

class Processor implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;

    public Processor(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread with id " + id + " proceeded.");
    }


}
