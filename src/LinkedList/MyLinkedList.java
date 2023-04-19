package LinkedList;

import java.util.Arrays;

public class MyLinkedList {
    private Node head; // голова списка (первый элемент)
    private int size; // размер списка

    // Метод добавления элемента в конец списка
    public void add(int value) {
        if (head == null) { // Если список пуст
            this.head = new Node(value); // Создаем новый узел и делаем его головой списка
        } else {
            Node temp = head; // Временная переменная для перемещения по списку
            while (temp.getNext() != null) { // Пока не найден последний элемент списка
                temp = temp.getNext(); // Перемещаемся на следующий узел
            }
            temp.setNext(new Node(value)); // Создаем новый узел и добавляем его в конец списка
        }
        size++; // Увеличиваем размер списка на 1
    }

    // Метод получения элемента по индексу
    public int get(int index) {
        int currentIndex = 0; // Текущий индекс узла
        Node temp = head; // Временная переменная для перемещения по списку
        while (temp != null) { // Пока не достигнут конец списка
            if (currentIndex == index) { // Если найден нужный индекс
                return temp.getValue(); // Возвращаем значение текущего узла
            } else {
                temp = temp.getNext(); // Перемещаемся на следующий узел
                currentIndex++; // Увеличиваем текущий индекс
            }
        }
        throw new IllegalArgumentException(); // Если элемент с таким индексом не найден, выбрасываем исключение
    }

    // Метод удаления элемента по индексу
    public void remove(int index) {
        if (index == 0) { // Если удаляемый элемент первый
            head = head.getNext(); // Делаем следующий элемент головой списка
            size--; // Уменьшаем размер списка на 1
            return; // Завершаем выполнение метода
        }

        int currentIndex = 0; // Текущий индекс узла
        Node temp = head; // Временная переменная для перемещения по списку

        while (temp != null) { // Пока не достигнут конец списка
            if (currentIndex == index - 1) { // Если найден индекс предыдущего узла
                temp.setNext(temp.getNext().getNext()); // Удаляем текущий узел, связывая предыдущий с последующим
                size--; // Уменьшаем размер списка на 1
                return; // Завершаем выполнение метода
            } else {
                temp = temp.getNext(); // Перемещаемся на следующий узел
                currentIndex++; // Увеличиваем текущий индекс
            }
        }

    }

    // Метод, возвращающий строковое представление содержимого списка
    public String toString() {
        int[] result = new int[size];
        int idx = 0; // Индекс текущего элемента в массиве
        Node temp = head; // Временная переменная для перемещения по списку

        while (temp != null) { // Пока не достигнут конец списка
            result[idx++] = temp.getValue(); // Добавляем значение текущего узла в массив и увеличиваем индекс
            temp = temp.getNext(); // Перемещаемся на следующий узел
        }
        return Arrays.toString(result); // Возвращаем строковое представление массива
    }

    // Вложенный класс, представляющий узел связного списка
    private static class Node {
        private int value; // Значение узла
        private Node next; // Ссылка на следующий узел

        // Конструктор класса
        public Node(int value) {
            this.value = value; // Присваиваем значение узла
        }

        // Геттер для значения узла
        public int getValue() {
            return value;
        }

        // Сеттер для значения узла
        public void setValue(int value) {
            this.value = value;
        }

        // Геттер для ссылки на следующий узел
        public Node getNext() {
            return next;
        }

        // Сеттер для ссылки на следующий узел
        public void setNext(Node next) {
            this.next = next;
        }
    }
}