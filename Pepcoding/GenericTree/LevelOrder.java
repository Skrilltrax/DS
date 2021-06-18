import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    static int flag = 0;

    // public static void traverse(GT.Node node) {
        
    //     if (flag == 0) {
    //         System.out.print(node.data);
    //         System.out.println();
    //         flag++;
    //     }

    //     for (GT.Node child: node.children) {
    //         System.out.print(child.data);
    //     }
    //     System.out.println();
    //     for (GT.Node child: node.children) {
    //         traverse(child);
    //     }
    // }


    public static boolean isLeft = false;

    public static void LevelOrderZigZag(Node node) {
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(node);
        queue.add(null);

        while (queue.size() > 1) {
            Node n = queue.remove();
            if (n != null)
                System.out.print(node.data + ", ");
            else 
                isLeft = !isLeft;
            
            for (Node node1 : n.children) {
                queue.add(node1);
            }

            if (isLeft == false) {
            }
        }
    }
}