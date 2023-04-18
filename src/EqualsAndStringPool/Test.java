package EqualsAndStringPool;

public class Test {
    public static void main(String[] args) {

        // при создании двух одинаковых String, указатель указывает на один и тот же объект. Благодаря StringPool
        String string1 = "Hello"; // string1 -> {"Hello"}
        String string2 = "Hello"; // string2

        System.out.println(string1 == string2); // тут true

        String string3 = new String("Hello"); // string3 -> {"Hello"}
        String string4 = new String("Hello"); // string4 -> {"Hello"}

        System.out.println(string3 == string4); // тут false так как в этом случае будет две разные ссылки на объекты


        // при создании объектов указатель указывает на разные объекты, в разных частях памяти
        Animal animal1 = new Animal(1); // animal1 -> {id 1}
        Animal animal2 = new Animal(1); // animal2 -> {id 1}

        System.out.println(animal1 == animal2); // тут false, потому что сравниваются указатели.
    }
}
class Animal {
    private int id;

    public Animal(int id) {
        this.id = id;
    }
    public boolean equals(Object obj){ // переопределение метода проверки объектов, проверка не указателей, а содержимого
        Animal otherAnimal = (Animal) obj;
        return this.id == otherAnimal.id;
    }
}