package AnonymousClasses;

// Определяем интерфейс AbleToEat с единственным методом eat()
interface AbleToEat {
    public void eat();
}

// Определяем класс Test
public class Test {
    // Определяем метод main
    public static void main(String[] args) {
        // Создаем объект ableToEat с помощью анонимного класса, который реализует интерфейс AbleToEat
        AbleToEat ableToEat = new AbleToEat() {
            // Переопределяем метод eat интерфейса AbleToEat и выводим на консоль сообщение
            @Override
            public void eat() {
                System.out.println("Someone is eating...");
            }
        };
        // Вызываем метод eat на объекте ableToEat, который выводит сообщение на консоль
        ableToEat.eat();
    }
}
