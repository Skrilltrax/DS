public class PreSuc {

    public static int flag = 0;
    public static int predecessor = 0;
    public static int successor = 0;
    
    public static void find(Node node, int data, Node prev) {



        prev = node;
        for (Node child: node.children) {
            find(child, data, prev);
        }
    }
}