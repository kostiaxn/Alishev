package Comparator;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        Set<Animal> animalSet = new TreeSet<>();

        addElements(animalList);
        addElements(animalSet);



        System.out.println(animalList);
        System.out.println(animalSet);
    }
    private static void addElements(Collection collection){
        collection.add(new Animal(4,"Bob"));
        collection.add(new Animal(2,"Tom"));
        collection.add(new Animal(1,"Katy"));
        collection.add(new Animal(3,"George"));
    }
}

class Animal implements Comparable<Animal> {
    private int id;
    private String name;

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (id != animal.id) return false;
        return Objects.equals(name, animal.name);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Animal o) {
        if(this.name.length() > o.getName().length()){
            return 1;
        } else if (this.name.length() < o.getName().length()) {
            return -1;
        }else {
            return 0;
        }
    }
}