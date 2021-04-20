package practice;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);

        Integer removed = deque.removeLast();
        System.out.println("Removed: " + removed);
        System.out.println(deque);
    }
}
