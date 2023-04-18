package Interfaces;

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Animal(1);
        Person person1 = new Person("Bob");

        // обычные методы классов
        animal1.sleep();
        person1.sayHello();

        // методы интерфейса, реализованные в классах со своей реализацией
        animal1.showInfo();
        person1.showInfo();


        // такая реализация возможна только при реализации интерфейс Info
        // Это полиморфизм, мы ограничили все методы классов и расматриваем объекты как нечто, что реализует интерфейс
        InfoInterface info1 = new Animal(2); // переменная info1 ссылается на объект типа Animal
        InfoInterface info2 = new Person("Ben"); // переменная info2 ссылается на объект типа Person

        info1.showInfo();
        info2.showInfo();

        outputInfo(info1);
        outputInfo(info2);

        // Можно сразу поместить объекты классов Animal и Person в качестве аргументов
        outputInfo(animal1);
        outputInfo(person1);

    }
            public static void outputInfo(InfoInterface infoInterface){ // метод может действовать на любом объекте, который реализует интерфейс
        infoInterface.showInfo();
    }

}
