package Generics;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Создаем новый список, содержащий объекты класса Animal
        List<Animal> listOfAnimal = new ArrayList<>();

        // Добавляем два новых объекта класса Animal в список
        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));

        // Создаем новый список, содержащий объекты класса Dog
        List<Dog> listOfDogs = new ArrayList<>();

        // Добавляем два новых объекта класса Dog в список
        listOfDogs.add(new Dog());
        listOfDogs.add(new Dog());

        // Вызываем метод test с аргументом listOfAnimal, который содержит объекты Animal
        test(listOfAnimal);

        // Вызываем метод test с аргументом listOfDogs, который содержит объекты Dog (а Dog является подклассом Animal)
        test(listOfDogs);
    }

    // Создаем обобщенный метод test, который принимает список любых объектов, которые наследуются от Animal
    private static void test(List<? extends Animal> list) { // Конструкция List<? extends Animal> является wildcard-типом,
        // который означает, что List может содержать объекты любого класса, который наследуется от класса Animal.
        // Например, List<Dog> может быть передан в метод, который ожидает List<? extends Animal>, потому что класс
        // Dog наследуется от класса Animal. Такое ограничение не позволяет добавлять элементы в список, но позволяет безопасно читать элементы списка.

        // Проходим по списку и выводим информацию о каждом объекте
        for (Animal animal : list) {  //Конструкция for (Animal animal : list) является расширенной формой цикла for,
            // которая позволяет проходить по элементам коллекции. В данном случае мы проходим по списку объектов,
            // которые могут быть любого подкласса класса Animal, поэтому мы используем тип Animal для переменной,
            // которая будет использоваться для доступа к элементам списка. Внутри цикла мы выводим информацию о каждом животном в списке.
            System.out.println(animal);
            // здесь мы вызываем метод toString() у каждого объекта в списке и выводим результат в консоль
        }
    }
}