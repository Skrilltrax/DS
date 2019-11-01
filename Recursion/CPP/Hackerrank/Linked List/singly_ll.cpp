#include <iostream>
using namespace std;
#include "Node.cpp"

int main() {
    SingleLLHelper helper;
    helper.addNodeAtPosition(0, 0);
    helper.addNodeEnd(10);
    helper.addNodeEnd(20);
    helper.addNodeEnd(30);
    helper.addNodeEnd(40);
    helper.printLL();
    helper.removeNode();
    helper.printLL();
    helper.addNodeAtPosition(4, 40);
    helper.addNodeAtPosition(4, 35);
    helper.printLL();
    cout << helper.addNodeAtPosition(10, 35) << endl;
    helper.addNodeAtPosition(0, -1);
    helper.printLL();

}
