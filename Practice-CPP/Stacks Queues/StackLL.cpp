#include <iostream>
using namespace std;

template <typename T>
class Node {
    public:
    T data;
    Node* next;
    Node* prev;
    Node(T data) {
        this -> data = data;
        prev = next = NULL;
    }
};

template <typename T>
class Stack {
    Node<T>* top;
    int size;

    public:

    Stack() {
        this -> size = 0;
        top = NULL;
    }

    int getSize() {
        return size;
    }

    bool isEmpty() {
        return (size == 0) ? true : false;
    }

    T getTop() {
        if (top == NULL) {
            cout << "STACK UNDERFLOW" << endl;
        }
        return top -> data; 
    }

    void push(T data) {
        this -> size++;
        if (top == NULL) {
            top = new Node<T>(data);
        } else {
            try {
                top -> next = new Node<T>(data);
                top -> next -> prev = top;
                top = top -> next;
            } catch(bad_alloc) {
                this -> size--;
                cout << "STACK OVERFLOW" << endl;
            }
        }
    }

    T pop() {
        if (top == NULL) {
            cout << "STACK UNDERFLOW" << endl;
            return NULL;
        } else {
            this -> size--;
            Node<T> *tmp = top;
            T tmpData = top -> data;
            top = top -> prev;
            delete tmp;
            return tmpData;
        }
    }
    
    template <typename U>
    friend ostream &operator<<(ostream& os, Stack<U> const &stack);
};

template <typename T>
ostream &operator<<(ostream& os, Stack<T> const &stack) {
    Node<T> *ptr = stack.top;
    if (ptr == NULL) {
        os <<"STACK EMPTY";
        return os;
    }
    os << "Stack : ";
    while (ptr != NULL) {
        os << endl << ptr -> data;
        ptr = ptr -> prev;
    }
    return os;
}