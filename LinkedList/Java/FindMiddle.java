public class FindMiddle {

    public static void findMidWithSize(LinkedList ll) {
        LinkedList.Node tmp = ll.getHead();
        for(int i = 0; i < ll.getSize()/2; i++) {
            tmp = tmp.next;
        }
        System.out.println(tmp);
    }

    public static void findMidWithPointer(LinkedList ll) {
        LinkedList.Node ptr1 = ll.getHead();
        LinkedList.Node ptr2 = ll.getHead();

        while(ptr1 != null && ptr1.next != null) {
            if (ptr1.next == null) {
                break;
            }
            ptr1 = ptr1.next.next;
            ptr2 = ptr2.next;
        }
        System.out.println(ptr2);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        // ll.addLast(50);
        
        findMidWithPointer(ll);
    }
}