package Interfaces;

public class Animal implements InfoInterface{ // класс Animal реализует методы из интерфейса Info
    public int id;

    public Animal(int id) { // Конструктор для объекта с обязательным параметром id
        this.id = id;
    }

    public void sleep(){
        System.out.println("I am sleeping");
    }

    @Override // аннотация @Override обязывает имя метода быть таким же как и в интерфейсе
    public void showInfo() { // Метод реализует метод интерфейса
        System.out.println("Id is "+this.id);
    }
}
