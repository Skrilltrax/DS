#include <iostream>
using namespace std;

template <typename T>
class QueueLL {
    int size;
    class Node {
        public:
        Node(T data) {
            this -> data = data;
            this -> next = NULL;
        }
        T data;
        Node *next;
    } *head, *tail;

    public:

    QueueLL() : size(0) {
        head = NULL;
        tail = NULL;
    }

    bool isEmpty() {
        return (size == 0) ? true : false;
    }

    int getSize() {
        return size;
    }

    T getFront() {
        if (head != NULL)
            return head -> data;
        else 
            return NULL;
    }

    T getRear() {
        if (tail != NULL)
            return tail -> data;
        else 
            return NULL;
    }

    void enqueue(T data) {
        if (tail == NULL) {
            head = new Node(data);
            tail = head;
            return;
        }
        cout << "Debug : " <<tail -> data;
        tail -> next = new Node(data); // createNode(data);
        tail = tail -> next;
        size += 1;
    }

    T dequeue() {
        if (head == NULL) {
            cout << "STACK UNDERFLOW!!" << endl;
            return NULL;
        }
        Node *ptr = head;
        head = head -> next;
        delete ptr;
        size -= 1;
    }

    Node* createNode(T data) {
        Node *ptr = NULL;
        try {
            ptr = new Node(data);
        } catch (std::bad_alloc) {
            cout << "Error Allocating Memory" << endl;
            cout << "Exiting!!";
            exit(-1);
        }
        return ptr;
    }
};
