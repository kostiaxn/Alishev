package Synchronized;


public class Test {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.doWork();
    }

    public void increment() {// synchronized может быть только в методе. Метод синхронизованный
        synchronized (this) {
            counter++;
        }
    }


    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
//                    counter = counter + 1; // counter++ операция не атомарна. Работает не в один такт.
            }
        });
        thread1.start();
        thread2.start();

        thread1.join(); // Waits for this thread to die.
        thread2.join();

        System.out.println(counter);
    }
}

