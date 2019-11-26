#include <iostream>
using namespace std;

template <typename T>
class Queue {
    int size;
    int front;
    int rear;
    const int MAX_SIZE;
    T data[]; 

    public:

    Queue(int size) : MAX_SIZE(100), front(-1), rear(-1) {
        if (size > MAX_SIZE) {
            cout << "QUEUE CANNOT BE GREATER THAN " << MAX_SIZE << endl;
            cout << "QUEUE SIZE IS SET TO " << MAX_SIZE << endl;
            this -> size = MAX_SIZE;
        } else {
            this -> size = size;
        }
        T data[this -> size];
        cout << "QUEUE CREATED" << endl;
    }

    int getSize() {
        return rear + 1;
    }

    bool isEmpty() {
        return (size == 0) ? true : false;
    }

    void enqueue(T element) {
        if (rear == size - 1) {
            cout << "QUEUE FULL";
            return;
        }
        if (front == -1) {
            front++;
        }
        data[++rear] = element;
    }

    void dequeue() {
        if (rear == -1) {
            cout << "QUEUE EMPTY";
            return;
        }
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }         
    }
};