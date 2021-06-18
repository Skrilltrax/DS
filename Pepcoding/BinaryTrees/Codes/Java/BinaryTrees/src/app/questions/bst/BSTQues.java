package app.questions.bst;

import app.Node;

public class BSTQues {

    public static boolean findBST(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data)
            return true;

        if (node.data < data)
            return findBST(node.right, data);
        else
            return findBST(node.left, data);
    }

    //* 2 nodes of BST are swapped recover it

    static Node firstNode; 
    static Node secondNode; 

    // public static boolean recoverBST(Node node) {
    //     if (node == null)
    //         return false;
        
    //     boolean res = false;
        

    //     res = res || recoverBST(node.left);
    // }
}