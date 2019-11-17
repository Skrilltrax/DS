// Implement stack using array
#include <iostream>
using namespace std;

class Stack {
    const int MAX_SIZE;
    int arr[100];
    int tos;
    public:
    Stack() : tos(-1), MAX_SIZE(100) {
        cout << "Stack Created" << endl;
    }
    int size() {
        return tos + 1;        
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
        if (size() != MAX_SIZE) {
            arr[++tos] = data;
            cout << "Element Pushed : " << data << endl;
        } else
        {
            cout << "STACK OVERFLOW ERROR" << endl;
        }
    }
    void pop() {
        if (!isEmpty()) {
            cout << "Element Poped : " << arr[tos--] << endl;
        } else
        {
            cout << "STACK UNDERFLOW ERROR" << endl;
        }
    }
};

int main() {
    Stack stack;
    cout << stack.isEmpty() << endl;
    cout << stack.size() << endl;
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    cout << stack.isEmpty() << endl;
    cout << stack.size() << endl;
    cout << stack.top() << endl;
    stack.pop();
    cout << stack.size() << endl;
    cout << stack.top() << endl;
}