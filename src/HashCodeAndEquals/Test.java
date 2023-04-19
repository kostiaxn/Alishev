package HashCodeAndEquals;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<Person, String > map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(1, "Mike");

        set.add(person1);
        set.add(person2);

        System.out.println(set);

    }
}
class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;

    }


    @Override
    public boolean equals(Object o) {
        // Проверяем, равен ли объект this объекту o по ссылке
        if (this == o) return true;
        // Проверяем, не является ли объект o null и не совпадает ли класс объекта o с классом текущего объекта
        if (o == null || getClass() != o.getClass()) return false;

        // Приводим объект o к типу Person
        Person person = (Person) o;

        // Сравниваем поля id текущего объекта и объекта person
        if (id != person.id) return false;
        // Используем метод Objects.equals для сравнения полей name текущего объекта и объекта person
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        // Инициализируем переменную result значением поля id
        int result = id;
        // Вычисляем хеш-код поля name, используя тернарный оператор, и прибавляем его к result, умноженному на 31
        result = 31 * result + (name != null ? name.hashCode() : 0);
        // Возвращаем вычисленный хеш-код
        return result;
    }
    /*
    Контракт hashcode() equals()
    1) У двух проверяемых объектов вызываем метод hashcode()
    если хэши разные -> два объекта точно разные.

    2) если хэши одинаковые -> вызываем метод equals()

    3) equals() -> выдает ответ
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


