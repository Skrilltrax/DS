#include<iostream>
using namespace std;

class DynamicArray {
    int *data;
    int nextIndex;
    int capacity;

    public:

    DynamicArray() {
        capacity = 16;
        nextIndex = 0;
        data = new int[capacity];
    }
    
    DynamicArray(int initialSize) {
        capacity = initialSize;
        nextIndex = 0;
        data = new int[capacity];
    }

    DynamicArray(DynamicArray const &d) {
        // data = d.data;       Shallow Copy

        // Deep Copy
        data = new int[d.capacity];
        for (int i = 0; i < d.nextIndex; i++) {
            data[i] = d.data[i];
        }
        capacity = d.capacity;
        nextIndex = d.nextIndex;
    }

    void operator=(DynamicArray const &d) {
        // data = d.data;       Shallow Copy
        
        // Deep Copy
        data = new int[d.capacity];
        for (int i = 0; i < d.nextIndex; i++) {
            data[i] = d.data[i];
        }
        capacity = d.capacity;
        nextIndex = d.nextIndex;
    }

    void add(int element) {
        if (nextIndex == capacity) {
            int *newData = new int[capacity * 2];
            capacity *= 2;
            for (int i = 0; i < capacity; i++) {
                newData[i] = data[i];
            }
            delete[] data;
            data = newData;
            data[nextIndex] = element;
            nextIndex++;
        }
        data[nextIndex] = element;
        nextIndex++;
    }

    int get(int i) {
        if (i < nextIndex) {
            return data[i];
        }
        return -1;
    }

    void add(int i, int element) {
        if (i < nextIndex) {
            data[i] = element;
        } else if (i == nextIndex) {
            add(element);
        } else {
            return;
        }
    }

    void print() {
        for (int i = 0; i < nextIndex; i++) {
            cout << data[i] << " ";
        }
        cout << endl;
    }
};

