#include <iostream>
#include "Node.cpp"
using namespace std;
typedef SingleLLHelper::Node Node;

class Pair {
    public:
    Node* head;
    Node* tail;
};

// Complexity O(n^2)
Node* reverseRecursive(Node* head) {
    if (head -> next == NULL) {
        return head;
    }
    Node *smallAns = reverseRecursive(head -> next);
    Node *ptr = smallAns;
    while (ptr -> next != NULL) {
        ptr = ptr -> next;
    }
    head -> next = NULL;
    ptr -> next = head;
    return smallAns;
}

// Complexity O(n)
Pair reverseRecursivePair(Node* head) {
    if (head -> next == NULL) {
        Pair ans;
        ans.head = head;
        ans.tail = head;
        return ans;
    }
    Pair smallAns = reverseRecursivePair(head -> next);
    head -> next = NULL;
    smallAns.tail -> next = head;
    smallAns.tail = smallAns.tail -> next;
    return smallAns;
}

// Complexity O(n)
Node* reverseRecursiveSimple(Node* head) {
    if (head -> next == NULL) {
        return head;
    }
    Node* smallAns = reverseRecursiveSimple(head -> next);
    head -> next -> next = head;
    head -> next = NULL;
    return smallAns;
}

int main() {
    SingleLLHelper helper;
    helper.addNode(1);
    helper.addNode(2);
    helper.addNode(3);
    helper.addNode(4);
    helper.addNode(5);
    // helper.head = reverseRecursive(helper.head);
    helper.head = reverseRecursivePair(helper.head).head;
    // helper.head = reverseRecursiveSimple(helper.head);    
    helper.printLL();
}