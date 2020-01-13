# Basic Tree Ques

## Height

```Java
public static int height(Node node) {
    if (node == null) {
        return 0;
    }
    return Math.max(height(node.left), height(node.right)) + 1;
}
```

## Size

```Java
public static int size(Node node) {
    if (node == null) {
        return 0;
    }
    return size(node.left) + size(node.right) + 1;
}
```

## Find Node

Use Preorder. If using Postorder all functions will be called.

```Java
public static boolean find(Node node, int data) {
    if (node == null) {
        return false;
    }
    if (node.data == data) {
        return true;
    }
    /*
        boolean res = false;
        res = res || find(node.left, data);
        res = res || find(node.right, data);
        return res;
    */
    return find(node.left) || find(node.right);
}
```

## Find all nodes to result

### Java

```Java
public static ArrayList<Node> rootToNodePath(Node node, int data) {
    ArrayList<Node> ans = new ArrayList<>();
    if (node == null) {
        return ans;
    }
    if (node.data == data) {
        ans.add(data);
        return ans;
    }

    ArrayList<Node> left = rootToNodePath(node.left, data);
    if (left.size() != 0) {
        left.add(data);
        return left;
    }

    ArrayList<Node> right = rootToNodePath(node.right, data);
    if (right.size() != 0) {
        right.add(data);
        return right;
    }
    return ans;
}
```

```Java
public static ArrayList<Node> rootToNodePath(Node node, int data) {

    if (node == null) {
        return null;
    }
    if (node.data == data) {
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(data);
        return ans;
    }

    ArrayList<Node> left = rootToNodePath(node.left, data);
    if (left!= null) {
        left.add(data);
        return left;
    }

    ArrayList<Node> right = rootToNodePath(node.right, data);
    if (right != null) {
        right.add(data);
        return right;
    }
    return null;
}
```

### C++

```CPP
bool rootToNodePath(Node *node, int data, vector<Node*> &path) {
    if (node == null) {
        return false;
    }
    if (node -> data == data) {
        path.push_back(data);
        return true;
    }

    bool res = false;
    res = res || rootToNodePath(node -> left, data, path)
    res = res || rootToNodePath(node -> right, data, path)
    if (res)
        path.push_back(node -> data);
    return res
}
```

## LCA: Lowest Common Ancestor

[30 20 10]  
[&nbsp; &nbsp; &nbsp;20 10]

If mismatch occurs or one arraylist finishes, LCA will be the last matching node.

```Java
void getLCA() {
    ArrayList<Node*> list1 = rootToNodePath(node, 10);

    ArrayList<Node*> list2 = rootToNodePath(node, 30);

    int result = -1;

    for (int i = list1.size() - 1, int j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
        if (list1.get(i).data != list2.get(i).data) {
            break;
        }
        result = list1.get(i).data;
    }
    System.out.println(result);
}

```

## Diameter of a tree

[Diameter](Codes/Java/BinaryTrees/src/app/questions/Diameter.java)

## Check BST

Check if Inorder Traversal is in increasing order.
