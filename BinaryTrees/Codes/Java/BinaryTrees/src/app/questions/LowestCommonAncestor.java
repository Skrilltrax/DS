package app.questions;

import java.util.ArrayList;
import app.Node;
import app.utils.*;

/**
 * LCA
 * [100 90 70 50 10]
 * [       70 50 10]
 * ans = 70
 */


public class LowestCommonAncestor {

    public static int printLCA(Node node, int data1, int data2) {
        ArrayList<Node> list1 = PathUtils.getPath(node, data1, 4);
        ArrayList<Node> list2 = PathUtils.getPath(node, data2, 4);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        int result = -1;
        for (; i >= 0 && j >= 0; i--, j--) {
            if (list1.get(i).data != list2.get(j).data) {
                break;
            }
            result = list1.get(i).data;
        }
        return result;
    }
}