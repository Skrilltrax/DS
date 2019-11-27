#include <iostream>
using namespace std;

template <typename T>
class Queue {
    int size;
    int capacity;
    int front;
    int rear;
    T* data; 

    public:

    Queue() : front(-1), rear(-1), size(0), capacity(4) {
        data = new T[this -> capacity];
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
            increaseCapacity();
            cout << "CAPACITY INCREASED";
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

    void increaseCapacity() {
        int j = 0;
        T* newData = new T[2 * capacity];
        for (int i = front; i < capacity; i++, j++) {
            newData[j] = data[i];
        }

        for (int i = 0; i < front; i++, j++) {
            newData[j] = data[i];
        }
        delete[] data;
        data = newData;
        front = 0;
        rear = capacity - 1;
        capacity *= 2;
    }
};