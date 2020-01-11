# Binary Trees

Constructor chaining -> Having more than 1 constructor  

## Tree Creation

### Java  

```Java
public static class Node {
    int data;  
    Node left = null;
    Node right = null;

    Node() {
        data = -1;
        left = null;
        right = null;
    }

    Node(int data, Node left, Node right) {  
        this.data = data;
        this.left = left;
        this.right = right;
    }
}  
```

### CPP

-> = (.)*

this -> data = (this.data)*

```CPP
class Node {
    int data;  
    Node left;
    Node right;

    public:

    Node() {
        this -> data = INT_MIN;
        this -> left = NULL;
        this -> right = NULL; // this -> right = nullptr;
    }

    Node(int data, Node *left, Node *right) {  
        this -> data = data;
        this -> left = left;
        this -> right = right;
    }
}  
```

### Tree Traversal

![Inorder](./res/inorder.png)

![Preorder](./res/preorder.png)

![Postorder](./res/postorder.png)
