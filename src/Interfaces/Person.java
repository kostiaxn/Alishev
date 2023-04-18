package Interfaces;

public class Person implements InfoInterface{ // класс Person реализует методы из интерфейса Info
    public String name;

    public Person(String name) { // Конструктор для объекта с обязательным параметром name
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hello");
    }

    @Override //аннотация @Override обязывает имя метода быть таким же как и в интерфейсе
    public void showInfo() { // Метод реализует метод интерфейса
        System.out.println("Name is "+this.name);
    }
}
