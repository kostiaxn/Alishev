package ThreadPool;

/*
Данный код создает пул из двух потоков с помощью ExecutorService, затем запускает 5 задач с помощью метода submit().
Каждая задача представляет объект типа Work, реализующий интерфейс Runnable.

Класс Work имеет одно поле id и переопределенный метод run(), который вызывается при запуске каждой задачи.
Метод run() делает задержку в 5 секунд с помощью Thread.sleep(5000), затем выводит сообщение о завершении работы в консоль.

После того, как все задачи были отправлены на выполнение, метод shutdown() вызывается для завершения всех потоков в пуле.
Затем вызывается метод awaitTermination(), который блокирует выполнение программы до тех пор, пока все задачи не будут выполнены
или не произойдет прерывание потока. В данном случае он устанавливает максимальное время ожидания в 1 день.
В конце программы выводится сообщение "All tasks submitted".
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        // Создаем пул из двух потоков с помощью Executors.newFixedThreadPool()
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Добавляем 5 задач в пул потоков с помощью executorService.submit()
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));
        }

        // Вызываем метод shutdown() для завершения всех потоков в пуле. Метод говорит о том что мы перестаем принимать новые задания и выполняем переданные
        executorService.shutdown();

        // Выводим сообщение в консоль, что все задачи были отправлены на выполнение
        System.out.println("All tasks submitted");

        // Вызываем метод awaitTermination(), который блокирует выполнение программы
        // до тех пор, пока все задачи не будут выполнены или не произойдет прерывание потока
        // В данном случае он устанавливает максимальное время ожидания в 1 день
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

// Класс Work реализует интерфейс Runnable
class Work implements Runnable {
    private int id;

    // Конструктор класса Work, принимающий один параметр
    public Work(int id) {
        this.id = id;
    }

    // Реализация метода run() интерфейса Runnable
    @Override
    public void run() {
        try {
            // Задержка в 5 секунд
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Если возникло прерывание потока, выбрасываем исключение RuntimeException с переданным исключением e
            throw new RuntimeException(e);
        }
        // Выводим сообщение в консоль о завершении работы
        System.out.println("Work " + id + " was completed");
    }
}
