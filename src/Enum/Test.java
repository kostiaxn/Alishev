package Enum;

public class Test {
    public static void main(String[] args) {
//        Animal animal = Animal.DOG;
//        System.out.println(animal);
//        switch (animal) {
//            case CAT:
//                System.out.println("It's a cat!");
//                break;
//            case DOG:
//                System.out.println("It's a dog!");
//                break;
//            case FROG:
//                System.out.println("It's a frog!");
//                break;
//        }
        Season season = Season.SUMMER;
        System.out.println(season.getTemperature());
        // Object -> Enum -> Season
//        System.out.println(season instanceof Season);
//
//        switch (season) {
//            case SUMMER:
//                System.out.println("Тепло");
//                break;
//            case WINTER:
//                System.out.println("Холодно");
//                break;
//        }
    }
}
