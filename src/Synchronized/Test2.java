package Synchronized;

/*
Этот код является примером многопоточной программы на Java, в которой используется синхронизация для безопасного доступа к общим ресурсам из нескольких потоков.

Класс Worker содержит два метода addToList1() и addToList2(), которые добавляют случайное число в два списка list1 и list2 соответственно.
Каждый метод защищен блоком synchronized с использованием разных объектов блокировки lock1 и lock2. Это гарантирует,
что только один поток может изменять каждый список в любой момент времени.

Метод work() вызывает каждый из методов addToList1() и addToList2() 1000 раз, чтобы добавить 1000 случайных чисел в каждый список.

В методе main() создаются два потока thread1 и thread2, каждый из которых запускает метод work() в объекте Worker.
Затем потоки ожидают завершения выполнения друг друга с помощью метода join(). После завершения работы обоих потоков
измеряется время выполнения программы и выводятся размеры двух списков list1 и list2.

Таким образом, программа создает два потока, каждый из которых добавляет случайные числа в свой собственный список
с помощью синхронизации, чтобы гарантировать безопасность доступа к общим ресурсам в многопоточной среде.
В конце программы выводится количество элементов в каждом списке и время, за которое программа выполнялась.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

// класс Test2 содержит только метод main и создает объект Worker
public class Test2 {
    public static void main(String[] args) {
        // Создание нового объекта Worker и вызов его метода main()
        new Worker().main();
    }
}

// класс Worker содержит два объекта-блокировщика, два списка и методы для их заполнения
class Worker {
    // Создание объекта для генерации случайных чисел
    Random random = new Random();
    // Создание двух объектов-блокировщиков
    Object lock1 = new Object();
    Object lock2 = new Object();
    // Создание двух списков, доступных только из текущего объекта
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    // Метод для добавления случайного числа в первый список
    public void addToList1() {
        // Захват блокировщика lock1
        synchronized (lock1) {
            try {
                // Приостановление выполнения текущего потока на 1 мс
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Добавление случайного числа в первый список
            list1.add(random.nextInt(100));
        }
    }

    // Метод для добавления случайного числа во второй список
    public void addToList2() {
        // Захват блокировщика lock2
        synchronized (lock2) {
            try {
                // Приостановление выполнения текущего потока на 1 мс
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Добавление случайного числа во второй список
            list2.add(random.nextInt(100));
        }
    }

    // Метод для заполнения списков данными
    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    // Основной метод, запускающий выполнение потоков и выводящий результат работы программы на экран
    public void main() {
        // Запись текущего времени в миллисекундах
        long before = System.currentTimeMillis();

        // Создание и запуск двух потоков
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        // Запуск потоков
        thread1.start();
        thread2.start();

        // Ожидание завершения выполнения потоков
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Запись текущего времени в миллисекундах
        long after = System.currentTimeMillis();

        // Вывод на экран времени работы программы и размеров списков
        System.out.println("Program took " + (after - before) + " ms to run");
        System.out.println("List1 : " + list1.size());
        System.out.println("List2 : " + list2.size());
    }
}