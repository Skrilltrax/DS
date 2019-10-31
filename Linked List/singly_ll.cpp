#include <iostream>
using namespace std;
#include "Node.cpp"

int main() {
    SingleLLHelper helper;
    helper.addNode(10);
    helper.addNode(20);
    helper.addNode(30);
    helper.addNode(40);
    helper.printLL();
    helper.removeNode();
    helper.printLL();

}