#include <climits>
class Node {
    int data;
    Node *left;
    Node *right;
    public:

    Node() {
        data = INT_MIN;
        left = nullptr;
        right = nullptr;
    }

    Node(int data) {
        Node(data, nullptr, nullptr);
    }

     Node(int data, Node *left, Node *right) {
         this -> data = data;
         this -> left = left;
         this -> right = right;
    }   

    void setData(int data) {
        this -> data = data;
    }

    int getData(int data) {
        this -> data = data;
    }
};