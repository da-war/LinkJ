import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        var list=new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.reverse();


        System.out.println(list.indexOfNumber(30));
        System.out.println(list.contains(330));
        list.deleteLast();
        System.out.println("hell");

    }
}