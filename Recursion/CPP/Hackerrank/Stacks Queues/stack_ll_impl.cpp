#include <iostream>
#include "StackLL.cpp"
using namespace std;

int main() {
    Stack<int> stack;
    cout << stack << endl;
    cout << "isEmpty : " << stack.isEmpty() << endl;
    stack.push(1);
    cout << "Pushed : " << stack.getTop() << endl;
    stack.push(2);
    cout << "Pushed : " << stack.getTop() << endl;
    stack.push(3);
    cout << stack << endl;
    cout << "Pushed : " << stack.getTop() << endl;
    cout << "Poped : " << stack.pop() << endl;
    cout << "Size : " << stack.getSize() << endl;
    cout << "Poped : " << stack.pop() << endl;
    cout << "Size : " << stack.getSize() << endl;
    cout << "Poped : " << stack.pop() << endl;
    cout << "Size : " << stack.getSize() << endl;
    cout << "Poped : " << stack.pop() << endl;
    cout << "Size : " << stack.getSize() << endl;
    cout << "Poped : " << stack.pop() << endl;
    cout << "Size : " << stack.getSize() << endl;

}