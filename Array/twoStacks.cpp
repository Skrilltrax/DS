#include <iostream>
using namespace std;

class TwoStack {
    int *arr;
    int sp1;
    int sp2;
    int arraySize;

    public:
    TwoStack(int size) {
        arraySize = size;
        arr = new int[size];
        sp1 = -1;
        sp2 = size;
        cout << "Stack Formed" << endl;
    }
    
    int pushOne(int item) {
        if (sp1 == sp2 - 1) {
            cout << "Stack 1 : Overflow" << endl;
            return -1;
        }
        arr[++sp1] = item;
        return item;
    }

    int pushTwo(int item) {
        if (sp1 == sp2 - 1) {
            cout << "Stack 2 : Overflow" << endl;
            return -1;
        }
        arr[--sp2] = item;
        return item;
    }

    int popOne() {
        if (sp1 == -1) {
            cout << "Stack 1 : Underflow" << endl;
            return -1;
        }
        int temp = arr[sp1];
        arr[sp1--] = 0;
        return temp;
    }

    int popTwo() {
        if (sp2 == arraySize) {
            cout << "Stack 2 : Underflow" << endl;
            return -1;
        }
        int temp = arr[sp2];
        arr[sp2++] = 0;
        return temp;
    } 
};

int main() {
    TwoStack obj = TwoStack(10);
    obj.popOne();
    obj.popTwo();
    for (int i = 0; i < 7; i++) {
        cout << "i : "<< i << endl;
        obj.pushOne(i);
        obj.pushTwo(i);
    }
    return 0;
}
