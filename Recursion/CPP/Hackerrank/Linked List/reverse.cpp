#include <iostream>
#include "Node.cpp"
using namespace std;
typedef SingleLLHelper::Node Node;

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

int main() {
    SingleLLHelper helper;
    helper.addNode(1);
    helper.addNode(2);
    helper.addNode(3);
    helper.addNode(4);
    helper.addNode(5);
    helper.head = reverseRecursive(helper.head);
    helper.printLL();
}