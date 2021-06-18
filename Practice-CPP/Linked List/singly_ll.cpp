#include <iostream>
using namespace std;
#include "Node.cpp"

void testLL() {
    SingleLLHelper helper;
    cout << "Added : " << helper.addNodeAtPosition(0, 10) << endl;
    helper.addNodeEnd(20);
    helper.addNodeEnd(30);
    helper.addNodeEnd(40);
    helper.addNodeEnd(50);
    helper.printLL();
    helper.removeNode();
    helper.printLL();
    cout << "Added : " << helper.addNodeAtPosition(4, 50) << endl;
    cout << "Added : " << helper.addNodeAtPosition(4, 45) << endl;
    helper.printLL();
    cout << "Added :  " << helper.addNodeAtPosition(10, 45) << endl;
    helper.addNodeAtPosition(0, 0);
    helper.printLL();
    cout << "Removed : " << helper.removeNodeAtPosition(1) << endl;
    helper.printLL();
    cout << "Removed : " << helper.removeNodeAtPosition(0) << endl;
    helper.printLL();
    cout << "Removed : " << helper.removeNodeAtPosition(100) << endl;
    helper.printLL();
    // cout << "Added : " << helper.addNodeAtPositionRecusrive(helper.head, 0, 10) << endl;
    // cout << "Added : " << helper.addNodeAtPositionRecusrive(helper.head, 0, 0) << endl;
    // helper.printLL();
}

int main() {
    testLL();
}
