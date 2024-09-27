import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    private Node first;
    private Node last;
    //addFirst
    //addLast
    //deleteFirst
    //deleteLast
    //contains
    //indexOf

    public void addFirst(int number) {
        var node = new Node(number);
        if (first == null) first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    public void addLast(int number) {
        var node = new Node(number);
        if (first == null)
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

    }

    public void deleteFirst() {
        if (first == last) {
            first = last = null;
            return;
        }
//        [10->20->30]
        if (first != null) {
            var second = first.next;
            first.next = null;
            first = second;
        }

        throw new NoSuchElementException();
    }

    public void deleteLast() {
        // Check if the list is empty
        if (first == null) {
            System.out.println("List is empty.");
            throw new NoSuchElementException();

        }

        // Case 1: Only one element in the list
        if (first == last) {
            first = last = null;
            return;
        }

        // Case 2: More than one element
        var current = first;
        while (current.next != last) {
            current = current.next;  // Move to the next node
        }

        // Set the second-to-last node as the last node
        last = current;
        last.next = null;
    }


    public boolean contains(int number) {
        var current = first;
        while (current != null) {
            if (current.value == number) return true;
            current = current.next;
        }
        return false;
    }

    public int indexOfNumber(int number) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == number) return index;
            current = current.next;
            index++;
        }

        return -1;
    }


    public void reverse() {
//        [10->20->30]
//        [10<-20<-30]
        //[{10,null},{20,a},{30,c},{40,null}]
//        ----one-----two----three---four

        if (first.next == null) {
            return;
        }
        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public void kthNodeFromEnd(int k) {
        var fast = first;
        var slow = first;

        if (first == null) {
            return;
        }

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                System.out.println("The func can't be done");
                return;
            }
            fast = fast.next;
        }

        while (fast.next == null) {
            fast = fast.next;
            slow = fast.next;
        }

        System.out.println("The kth node from end is " + slow);
    }
}
//[{10,a},{20,b},{30,null}]


