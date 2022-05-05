#include <iostream>
using namespace std;

class Node {
    public:
    int data;
    Node *npn;

    Node(): data(-1), npn(nullptr) {}
    Node(int value, Node *xorNode): data(value), npn(xorNode) {}
};

Node* xorNodes(Node* previous, Node* next) {
    return reinterpret_cast<Node*>(reinterpret_cast<uintptr_t>(previous) ^ reinterpret_cast<uintptr_t>(next));
}

Node* insert(Node* head, int data) {
    Node *newNode = new Node();

    newNode -> data = data;
    newNode -> npn = xorNodes(nullptr, head);

    if (head != nullptr) {
        // If list is not empty, head -> npn is the address of head -> next
        head -> npn = xorNodes(newNode, head -> npn);
    }

    head = newNode;
    return head;
}

void printList(Node* head) {
    Node* current = head;
    Node* prev = nullptr;
    Node* next = xorNodes(current -> npn, prev);

    while(current != nullptr) {
        cout << current -> data << " ";
        next = xorNodes(current -> npn, prev);
        prev = current;
        current = next;
    }
    cout << endl;
}

void printReverseList(Node* tail) {
    Node* current = tail;
    Node* next = nullptr;
    Node* prev = xorNodes(current -> npn, next);

    while(current != nullptr) {
        prev = xorNodes(current -> npn, next);
        cout << current -> data << " ";
        next = current;
        current = prev;
    }
    cout << endl;
}

int main() {
    Node* head = nullptr;
    Node * tail = nullptr;

    head = insert(head, 1);
    tail = head;
    printList(head);
    head = insert(head, 2);
    printList(head);
    head = insert(head, 3);
    printList(head);
    head = insert(head, 4);
    printList(head);
    head = insert(head, 5);
    printList(head);

    cout << "Printing List in Reverse" << endl;
    printReverseList(tail);


    cout << "Reversing List" << endl;
    Node* temp = head;
    head = tail;
    tail = head;

    cout << "Printing List" << endl;
    printList(head);
}