import LinkedList;
import LinkedList.Node;

public class EvenOdd {

    public static void evenOdd(Node head) {
        Node odd = new Node(-1);
        Node even = new Node(-1);

        Node odditr = odd;
        Node evenitr = even;

        while(head != null) {
            if (head.data % 2 == 0) {
                evenitr.next = head;
                evenitr = evenitr.next;
            } else {
                odditr.next = head;
                odditr = odditr.next;
            }

            head = head.next;
        }
        odditr.next = null;
        evenitr.next = null;

        odditr.next = even.next;
        return odd.next;
    }


    public static void main(String[] args) {

    }
}