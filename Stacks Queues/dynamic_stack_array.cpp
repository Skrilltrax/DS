// Implement stack using array
#include <iostream>
using namespace std;

class Stack {
    int *arr;
    int currentSize;
    int tos;
    public:
    Stack() : tos(-1) {
        currentSize = 4;
        arr = new int[4];
        cout << "Stack Created" << endl;
    }
    int memAllocated() {
        return currentSize;
    }
    int size() {
        return tos+1;        
    }
    bool isEmpty() {
        return (tos == -1) ? true : false;
    }
    int top() {
        if (!isEmpty()) {
            return arr[tos];
        }
        return tos;
    }
    void push(int data) {
        if (size() == currentSize) {
            increaseSize();
        }
        arr[++tos] = data;
        cout << "Element Pushed : " << data << endl;
    }
    int pop() {
        if (!isEmpty()) {
            cout << "Element Poped : " << arr[tos] << endl;
            return tos--;
        } else
        {
            cout << "STACK UNDERFLOW ERROR" << endl;
            return -100;
        }
    }
    void increaseSize() {
        cout << "Log : Size Increased" << endl;
        int *newArr = new int[2*currentSize];
        for (int i = 0; i < currentSize; i++) {
            newArr[i] = arr[i]; 
        }
        delete[] arr;
        arr = newArr;
        currentSize *= 2;
    }
};

int main() {
    Stack stack;
    cout << stack.isEmpty() << endl;
    cout << stack.size() << endl;
    stack.pop();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push(8);
    cout << stack.isEmpty() << endl;
    cout << stack.size() << endl;
    cout << stack.top() << endl;
    stack.pop();
    cout << stack.size() << endl;
    cout << stack.top() << endl;
}