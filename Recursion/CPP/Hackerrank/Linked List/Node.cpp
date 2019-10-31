#include <iostream>
using namespace std;
class SingleLLHelper {
    class Node {
        public:
        int data;
        Node* next;
        Node(int data) {
            this -> data = data;
            next = NULL;
        }
    } *head;

    public:
    SingleLLHelper() {
        head = NULL;
    }
    void printLL() {
        Node *ptr = head;
        while (ptr != NULL)
        {
            if (ptr -> next == NULL) {
                cout << ptr -> data << endl;
            } else {
                cout << ptr -> data <<" -> ";
            }
            ptr = ptr -> next;
        }
    }

    void addNode(int data) {
        if (head == NULL) {
            head = new Node(data);
            return;
        }
        Node *ptr = head;
        while (ptr->next != NULL) {
            ptr = ptr -> next;
        }
        ptr -> next = new Node(data);
    }

    int removeNode() {
        if (head == NULL) {
            return -1;
        } else {
            Node *ptr = head;
            while (ptr -> next -> next != NULL) {
                ptr = ptr -> next;
            }
            int temp = ptr -> next -> data;
            delete ptr -> next;
            ptr -> next = NULL;
            return temp;
        }
    }
};