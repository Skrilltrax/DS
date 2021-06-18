package app.questions.bst;

import app.AVLNode;
import app.questions.bst.BSTUtils;

public class TreeSums {

    public static AVLNode findVerticalSum(AVLNode node, AVLNode listNode) {
        if (node == null) {
            return null;
        }
        if (listNode == null) {
            listNode = new AVLNode(0);
            listNode.left = node.left;
            listNode.right = node.right;
        }
        listNode.data += node.data;

        listNode.left = findVerticalSum(node.left, listNode.left);
        listNode.right = findVerticalSum(node.left, listNode.right);
        return listNode;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        AVLNode res = AVLUtils.createFromSortedArray(arr, 0, arr.length - 1);
        BSTUtils.printTree(res);
        AVLNode node = new AVLNode(0);
        findVerticalSum(res, node);
        
        System.out.println(node.data);
        
        do {
            System.out.print(node.data + " ");
            node = node.left;
        } while (node.left != null); 
        
        // while (node.right != null) {
        //     System.out.println(node.data);
        //     node = node.right;
        // }
    }
}