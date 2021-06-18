#include <iostream>
using namespace std;

template <typename T>
class Queue {
    int size;
    int capacity;
    int front;
    int rear;
    const int MAX_SIZE;
    T data[]; 

    public:

    Queue(int size) : MAX_SIZE(100), front(-1), rear(-1), size(0) {
        if (size > MAX_SIZE) {
            cout << "QUEUE CANNOT BE GREATER THAN " << MAX_SIZE << endl;
            cout << "QUEUE SIZE IS SET TO " << MAX_SIZE << endl;
            this -> capacity = MAX_SIZE;
        } else {
            this -> capacity = size;
        }
        T data[this -> capacity];
        cout << "QUEUE CREATED" << endl;
    }

    T getFront() {
        if (front != -1)
            return data[front];
        else
            return INT8_MIN;
    }

    T getRear() {
        if (rear != -1)
            return data[rear];
        else
            return INT8_MIN;
    }

    int getSize() {
        return size;
    }

    bool isEmpty() {
        return (size == 0) ? true : false;
    }

    void enqueue(T element) {
        if (((rear + 1) % capacity) == front) {
            cout << "QUEUE FULL";
            return;
        }
        if (front == -1) {
            front++;
        }
        rear = (rear + 1) % capacity;
        data[rear] = element;
        size++;
    }

    void dequeue() {
        if (front == -1) {
            cout << "QUEUE EMPTY";
            return;
        }
        if (front == rear) {
            size--;
            front = rear = -1;
        } else {
            size--;
            front = (front + 1) % capacity;
        }         
    }
};