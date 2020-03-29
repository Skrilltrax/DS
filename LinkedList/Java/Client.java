public class Client {
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);

        // for(int i = 0; i < 4; i++) {
        //     System.out.println(ll.getFirst());
        //     System.out.println("Head : " + ll.getFirst());
        //     System.out.println("Tail : " + ll.getLast());
        //     System.out.println("size : " + ll.getSize());
        //     ll.removeFirst();
        // }
     
        System.out.println(ll.getAt(0));
        System.out.println(ll.getAt(1));
        System.out.println(ll.getAt(2));
        System.out.println(ll.getAt(3));
        // System.out.println(ll.getAt(4));
        System.out.println("Size : " + ll.getSize());
        System.out.println("LL : " + ll);
        // System.out.println(ll.getAt(-1));
        // System.out.println(ll.getAt(-5));


    }
}