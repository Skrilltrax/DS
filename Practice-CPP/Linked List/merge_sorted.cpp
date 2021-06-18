#include <iostream>
#include "Node.cpp"
using namespace std;

SingleLLHelper helper1, helper2, helper3;

void createLists() {
    helper1.addNode(1);
    helper1.addNode(3);
    helper1.addNode(5);
    helper1.addNode(7);
    helper1.addNode(9);

    helper2.addNode(2);
    helper2.addNode(4);
    helper2.addNode(6);
    helper2.addNode(8);
    helper2.addNode(10);
}

// Creates a new linked list. For changing existing linked lists see below
void mergeLists() {
    SingleLLHelper::Node* list1 = helper1.head;
    SingleLLHelper::Node* list2 = helper2.head;
    
    while (list1 != NULL && list2 != NULL) {
        if (list1 -> data <= list2 -> data) {
            helper3.addNode(list1 -> data);
            list1 = list1 -> next; 
        } else {
            helper3.addNode(list2 -> data);
            list2 = list2 -> next; 
        }
    }
    if (list1 != NULL && list2 == NULL) {
        while (list1 != NULL)
        {
            helper3.addNode(list1 -> data);
            list1 = list1 -> next;
        }
    } else {
        while (list2 != NULL)
        {
            helper3.addNode(list2 -> data);
            list2 = list2 -> next;
        }
    }
}

SingleLLHelper::Node* mergeLinkedListsWithoutSpace() {
    SingleLLHelper::Node *head = NULL, *tail = NULL;
    SingleLLHelper::Node* list1 = helper1.head;
    SingleLLHelper::Node* list2 = helper2.head;
    while (list1 != NULL && list2 != NULL) {
        if (list1 -> data <= list2 -> data) {
            if (head == NULL) {
                head = list1;
                tail = list1;
            } else {
                tail -> next = list1;
                tail = tail -> next;
            }
            list1 = list1 -> next;
        } else {
            if (head == NULL) {
                head = list2;
                tail = list2;
            } else {
                tail -> next = list2;
                tail = tail -> next;
            }
            list2 = list2 -> next;
        }
    }
        if (list1 != NULL && list2 == NULL) {
        while (list1 != NULL)
        {
            tail -> next = list1;
            list1 = list1 -> next;
            tail = tail -> next;
        }
    } else {
        while (list2 != NULL)
        {
            tail -> next = list2;
            list2 = list2 -> next;
            tail = tail -> next;
        }
    }
    return head;    
}

int main() {
    createLists();
    // mergeLists();
    SingleLLHelper helper3;
    helper3.head = mergeLinkedListsWithoutSpace();
    helper3.printLL();
}