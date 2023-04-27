package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = arr[i] * 2;
//            list.set(i, list.get(i) * 2);
//        }

        // map method

        // Преобразование элементов массива, умножая каждый элемент на 2 и сохраняя результат в новый массив
        arr = Arrays.stream(arr)     // создание потока элементов массива
                .map(a -> a * 2)  // применение функции умножения каждого элемента на 2
                .toArray();       // преобразование потока обратно в массив

        // Преобразование элементов списка, умножая каждый элемент на 2 и сохраняя результат в новый список
        list = list.stream()                // создание потока элементов списка
                .map(a -> a * 2)         // применение функции умножения каждого элемента на 2
                .collect(Collectors.toList()); // преобразование потока обратно в список

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        // filter method

        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(Arrays.toString(arr2));
        System.out.println(list2);

        // forEach method
        Arrays.stream(arr2).forEach(System.out::println);
        list2.stream().forEach(System.out::println);


        //reduce
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillArr(arr3);
        fillList(list3);

        // acc - временная переменая, каждый раз обновляется. b - текущий элемент
        int sum1 = Arrays.stream(arr3).reduce((acc, b) -> acc + b).getAsInt();
        int sum2 = list3.stream().reduce((acc,  b) -> acc * b).get();

        int sum3 = Arrays.stream(arr3).reduce(Integer::sum).getAsInt(); // использует статический метод Integer::sum
        // в качестве операции сведения. Он также берет два аргумента a и b, складывает их и возвращает результат.

        System.out.println(sum1);
        System.out.println(sum2);

    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++)
            list.add(i + 1);
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++)
            arr[i] = i + 1;
    }
}
