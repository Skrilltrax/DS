// Implement stack using array
#include <iostream>
using namespace std;

template <typename T>
class Stack {
    T *arr;
    int currentSize;
    int tos;
    public:
    Stack() : tos(-1) {
        currentSize = 4;
        arr = new T[4];
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
    T top() {
        if (!isEmpty()) {
            return arr[tos];
        }
        else {
            cout << "STACK EMPTY" << endl;
            return NULL;
        };
    }
    void push(T data) {
        if (size() == currentSize) {
            increaseSize();
        }
        arr[++tos] = data;
        cout << "Element Pushed : " << data << endl;
    }
    T pop() {
        if (!isEmpty()) {
            cout << "Element Poped : " << arr[tos] << endl;
            return arr[tos--];
        } else
        {
            cout << "STACK UNDERFLOW ERROR" << endl;
            return NULL;
        }
    }
    void increaseSize() {
        cout << "Log : Size Increased" << endl;
        T *newArr = new T[2*currentSize];
        for (int i = 0; i < currentSize; i++) {
            newArr[i] = arr[i]; 
        }
        delete[] arr;
        arr = newArr;
        currentSize *= 2;
    }
};

int main() {
    Stack<char> stack;
    cout << stack.isEmpty() << endl;
    cout << stack.size() << endl;
    stack.pop();
    stack.push('a');
    stack.push('b');
    stack.push('c');
    stack.push('d');
    stack.push('e');
    stack.push('f');
    stack.push('g');
    stack.push('h');
    cout << stack.isEmpty() << endl;
    cout << stack.size() << endl;
    cout << stack.top() << endl;
    stack.pop();
    cout << stack.size() << endl;
    cout << stack.top() << endl;
    cout << stack.memAllocated() << endl;
    stack.push('i');
    stack.push('j');
    cout << stack.memAllocated() << endl;
}