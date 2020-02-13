import java.util.ArrayList;
import java.util.Stack;

class GT {

    static Node construct(int[] arr) {

        Stack<Node> st = new Stack<>();

        Node root = null;

        for (int i : arr) {

            if (i == -1) {
                st.pop();
            } else {
                Node node = new Node(i);
                if (root == null) {
                    root = node;
                } else {
                    st.peek().children.add(node);

                }
                st.push(node);

            }

        }

        return root;

    }

    static void display(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + "==>");

        for (Node n : root.children) {//
            System.out.print(n.data + ",");
        }
        System.out.println();

        for (Node n : root.children) {// root => children call
            display(n);
        }

    }

    static boolean find(Node root, int val) {

        if (root.data == val) {
            return true;
        }

        boolean res = false;

        for (Node n : root.children) {
            res = res || find(n, val);
        }

        return res;

    }

    static int max(Node root) {

        int resmax = root.data;

        for (Node n : root.children) {
            resmax = Math.max(resmax, max(n));

        }

        return resmax;

    }

    static int min(Node root) {

        int resmin = root.data;

        for (Node n : root.children) {
            resmin = Math.min(resmin, min(n));

        }

        return resmin;

    }

    static int size(Node root) {
        int count = 1;

        for (Node n : root.children) {
            count += size(n);
        }

        return count;
    }

    // ===========================================

    static int height(Node root) {

        int h = 0;

        for (Node n : root.children) {
            h = Math.max(h, height(n));

        }

        return h + 1;

    }

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    static void ceil(Node root, int val) {

        if (root.data > val && root.data < ceil) {
            ceil = root.data;
        }

        for (Node n : root.children) {
            ceil(n, val);
        }
    }

    static void floor(Node root, int val) {

        if (root.data < val && root.data > floor) {
            floor = root.data;
        }

        for (Node n : root.children) {
            floor(n, val);
        }
    }

    static class HM {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean find = false;

        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

    }

    static void multisolver(int data, HM hp, Node root) {

        if (root.data == data) {
            hp.find = true;
        }

        if (root.data > hp.max) {
            hp.max = root.data;
        }

        if (root.data < hp.min) {
            hp.min = root.data;
        }

        if (root.data > hp.floor && root.data < data) {
            hp.floor = root.data;
        }

        if (root.data < hp.ceil && root.data > data) {
            hp.ceil = root.data;
        }

        for (Node n : root.children) {
            multisolver(data, hp, n);
        }
    }

    static int flag = 0;
    static int pre = 0;
    static int succ = 0;

    static void presucc(int data, Node root) {

        if (root.data == data) {
            flag++;
        }

        else if (flag == 0) {
            pre = root.data;
        }

        else if (flag == 1) {
            succ = root.data;
            flag++;
        }

        if (flag == 2) {
            return;
        }

        for (Node n : root.children) {
            presucc(data, n);
        }

    }

    public static Node linearize(Node node) {
        if (node.children.size() == 0) {
            return node;
        }

        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < node.children.size(); i++) {
            list.add(linearize(node.children.get(i)));
        }

        for (int i = list.size() - 1; i >= 0; i++) {
            list.get(i - 1).children.add(node.children.get(i));
            node.children.remove(i);
        }

        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1+};

        Node root = construct(arr);

        // display(root);
        // System.out.println(find(root,10));

        // System.out.println(max(root));
        // System.out.println(min(root));

        // System.out.println(size(root));

        // System.out.println(height(root));
        // ceil(root,10);
        // floor(root,10);
        // System.out.println(ceil);
        // System.out.println(floor);

        // HM hp=new HM();

        // multisolver(700,hp,root);

        // System.out.println(hp.find);
        // System.out.println(hp.max);
        // System.out.println(hp.min);
        // System.out.println(hp.floor);
        // System.out.println(hp.ceil);

        // presucc(70,root);

        // System.out.println(pre+" === "+succ);

        // LevelOrder.traverse(root);
        // RemoveLeaves.remove(root);
        linearize(root);
        display(root);
    }
}