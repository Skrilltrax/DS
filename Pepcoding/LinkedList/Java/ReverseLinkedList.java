public class ReverseLinkedList extends LinkedList {

    public static void reverseInterative(LinkedList ll) {
        int size = ll.getSize();
        for (int i = 0; i < size/2; i++) {
            Node node1 = ll.getNodeAt(i);
            Node node2 = ll.getNodeAt(size-(i+1));
            int tmp = node1.data;
            node1.data = node2.data;
            node2.data = tmp;
        }
        System.out.println(ll);
    }

    public static void reverseRecursiveBad(LinkedList ll, int i, int size) {
        if (i >= size/2) {
            return;
        }

        Node node1 = ll.getNodeAt(i);
        Node node2 = ll.getNodeAt(size-(i+1));
        int tmp = node1.data;
        node1.data = node2.data;
        node2.data = tmp;

        reverseRecursiveBad(ll, i+1, size);
    }

    public static Node reverseRecursiveGood(Node node, int i, int size) {
        if (i >= size/2) {
            if (size % 2 == 0)
                return node;
            else
                return node.next;
        }

        Node retNode = reverseRecursiveGood(node.next, i+1, size);
        int tmp = node.data;
        node.data = retNode.data;
        retNode.data = tmp;
        return retNode.next;
    }

    public static Node reverseNodesRecursive(Node node, Node prevNode) {
        if (node.next == null) {
            node.next = prevNode;
            prevNode.next = null;
            return prevNode;
        }

        Node retNode = reverseNodesRecursive(node.next, node);
        retNode.next = node;
        node.next = null;
        return node;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        // reverseInterative(ll);
        // reverseRecursive(ll, 0, ll.size);
        Node node = reverseNodesRecursive(ll.getHead(), null);
        ll.head = ll.tail;
        ll.tail = node;
        // reverseRecursiveGood(ll.getHead(), 0, ll.getSize());
        // while(node != null) {
        //     System.out.print(node.data + " ");
        // }
        System.out.println(ll);
    }
}