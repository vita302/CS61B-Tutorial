

package deque;

import java.awt.event.ItemEvent;

public class LinkedListDeque<Item> {
    public class Node<Item> {
        Item value;
        Node<Item> next;
        Node<Item> prev;

    }

    public Node<Item> sentinal , endSentinal;
    public int list_size = 0;

    public LinkedListDeque() {
        sentinal = new Node<>();
        endSentinal = new Node<>();
        sentinal.next = endSentinal;
        endSentinal.prev = sentinal;
        sentinal.value = endSentinal.value = null;
    }

    public Item getRecursive(int index) {
        Node<Item> curr = sentinal.next;
        if (curr == endSentinal) return null;
        return getByR(curr , index);
    }

    private Item getByR(Node<Item> curr , int index)
    {
        if (index == 0) return curr.value;
        else {
            curr = curr.next;
            if (curr == endSentinal) return null;
            return getByR(curr , index - 1);
        }
    }



    public void addFirst(Item x) {
        Node<Item> fr = new Node<>();
        fr.value = x;
        fr.next = sentinal.next;
        sentinal.next = fr;
        fr.prev = sentinal;
        list_size += 1;
        if (endSentinal.prev == sentinal) endSentinal.prev = fr;
    }

    public void addLast(Item x) {

        Node<Item> curr = endSentinal.prev;
        Node<Item> fr = new Node<>();
        fr.value = x;
        fr.next = endSentinal;
        curr.next = fr;
        fr.prev = curr;
        endSentinal.prev = fr;
        if (sentinal.next == endSentinal) sentinal.next = fr;
        list_size += 1;
    }

    public boolean isEmpty() {
        if (list_size != 0) return false;
        return true;
    }

    public int size() {
        return list_size;
    }

    public void printDeque() {
        Node<Item> pointer;
        pointer = sentinal.next;
        while (pointer != endSentinal) {
            System.out.print(pointer.value);
            System.out.print(' ');
            pointer = pointer.next;
        }

        System.out.println();
    }

    public Item removeFirst() {
        Node<Item> curr = sentinal.next;
        if (curr == endSentinal) return null;
        Item x = sentinal.next.value;
        curr.prev = sentinal;
        sentinal.next = curr.next;
        list_size -= 1;
        return x;
    }

    public Item removeLast() {
        Node<Item> curr = endSentinal.prev;
        if (curr == sentinal) return null;
        Item x = curr.value;
        curr.prev.next = endSentinal;
        endSentinal.prev = curr.prev;
        list_size -= 1;
        return x;
    }

    public Item get(int index) {
        int count = 0;
        Node<Item> curr = sentinal.next;

        while (count != index) {
            curr = curr.next;
            count += 1;
            if (curr == endSentinal) return null;
        }

        return curr.value;
    }

}