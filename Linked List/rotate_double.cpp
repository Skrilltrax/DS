// rotate a doubly linked list anti-clockwise by some p positions
#include <iostream>
using namespace std;

class Node {
    public:
    int data;
    Node* left;
    Node* right;
} *head;

void insert(int data) {
    Node *ptr = head;
    if (ptr == NULL) {
        ptr = new Node();
        ptr -> data = data;
        ptr -> left = NULL;
        ptr -> right = NULL;
        head = ptr;
    } else {
        while (ptr -> right != NULL) {
            ptr = ptr -> right;
        }
        ptr -> right = new Node();
        ptr -> right -> left = ptr;
        ptr = ptr -> right;
        ptr -> data = data;
        ptr -> right = NULL;
    }
}

void print() {
    Node *ptr = head;
    if (ptr == NULL) {
        cout << "error here";
    }
    while (ptr -> right != NULL) {
        cout << "Node : " << ptr -> data << " Right : " << ptr -> right -> data << endl;
        ptr = ptr -> right;
    }
}

void createList() {
    head = NULL;
    insert(1);
    insert(2);
    insert(3);
    insert(4);
    insert(5);
}

void rotateCounter(int r) {
    Node *first = head;
    Node *last = head;
    while (last -> right != NULL) {
        last = last -> right;
        cout << "1";
    }
    last -> right = first;
    first -> left = last;
    while (r-- > 0) {
        last = last -> right;
        first = first -> right;
    }
    last -> right = NULL;
    first -> left = NULL;
    head = first;
}

void rotate(int r) {
    Node *first = head;
    Node *last = head;
    while (last -> right != NULL) {
        last = last -> right;
    }
    last -> right = first;
    first -> left = last;
    while (r-- > 0) {
        last = last -> left;
        first = first -> left;
    }
    last -> right = NULL;
    first -> left = NULL;
    head = first;
}

int main() {
    createList();
    rotate(2);
    print();
}
