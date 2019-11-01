#include <iostream>
using namespace std;
class SingleLLHelper {
    class Node {
        public:
        int data;
        Node* next;
        Node(int data) {
            this -> data = data;
            this -> next = NULL;
        }
    } *head, *tail;

    public:
    SingleLLHelper() {
        head = NULL;
        tail = NULL;
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

    /*
    * Add node in n^2 time (takes n time to input a single node)
    */
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

    void addNodeEnd(int data) {
        if (head == NULL) {
            head = new Node(data);
            tail = head;
            return;
        }
        tail -> next = new Node(data);
        tail = tail -> next;
    }


    int addNodeAtPosition(int pos, int data) {
        int currentPos = 0;
        if (head == NULL) {
            head = new Node(data);
            tail = head;
            return data;
        }
        Node *ptr = head;
        while (currentPos < pos - 1) {
            if (ptr == NULL) {
                return -1;
            }
            ptr = ptr -> next;
            currentPos++;
        }
        Node *temp = new Node(data);
        if (pos == 0) {
            temp -> next = head;
            head = temp;
        } else {
            temp -> next = ptr -> next;
            ptr -> next = temp;
        }
        temp = NULL;
        delete temp; 
        return data;
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