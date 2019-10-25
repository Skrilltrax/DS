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

    void add(int element) {
        if (nextIndex == capacity) {
            int *newData = new int[capacity * 2];
            capacity *= 2;
            for (int i = 0; i < capacity; i++) {
                newData[i] = data[i];
            }
            delete [] data;
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
};

