package PatternProducerConsumer;


/**
 Этот код демонстрирует пример использования многопоточности и синхронизации с помощью BlockingQueue в Java.
 Он создает два потока - производитель и потребитель, которые работают независимо друг от друга.

 В методе main() создаются два потока, один для производителя и другой для потребителя, и запускаются.
 Затем используется метод join(), чтобы главный поток ожидал, пока оба потока не завершат свою работу.

 Метод produce() генерирует случайные целые числа в бесконечном цикле и добавляет их в очередь,
 которая ограничена размером 10.

 Метод consumer() также работает в бесконечном цикле и ждет случайное время в 100 миллисекунд.
 Затем он проверяет случайным образом, должен ли он извлекать элемент из очереди. Если он решает извлечь элемент,
 он удаляет его из очереди и выводит его значение на консоль, а также выводит текущий размер очереди.

 Этот код демонстрирует, как многопоточность может быть использована для решения проблемы синхронизации при работе с общим ресурсом,
 таким как очередь, и как BlockingQueue может использоваться для обеспечения безопасности в многопоточной среде.
 */



import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
    // Создание очереди с ограниченным размером
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        // Создание потока производителя
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce(); // Запуск метода производителя
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        // Создание потока потребителя
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer(); // Запуск метода потребителя
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        // Запуск обоих потоков
        thread1.start();
        thread2.start();

        // Ждем завершения обоих потоков
        thread1.join();
        thread2.join();
    }

    // Метод производителя
    private static void produce() throws InterruptedException {
        Random random = new Random();
        while (true) {
            queue.put(random.nextInt(100)); // Генерация случайного числа и добавление его в очередь
        }
    }

    // Метод потребителя
    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100); // Ждем 100 миллисекунд
            if (random.nextInt(10) == 5) { // Случайным образом решаем, следует ли извлекать элемент из очереди
                System.out.println(queue.take()); // Извлекаем элемент из очереди и выводим его значение на консоль
                System.out.println("Queue size is " + queue.size()); // Выводим размер очереди на консоль
            }
        }
    }
}