#include <iostream>
#include "Node.cpp"
using namespace std;

void printReverse(SingleLLHelper::Node* node) {
    if (node == NULL) {
        return;
    }
    printReverse(node -> next);

    cout << "Node : " << node -> data << endl;
}

int main() {
    SingleLLHelper helper;
    helper.addNode(0);
    helper.addNode(10);
    helper.addNode(20);
    helper.addNode(30);
    helper.addNode(40);
    printReverse(helper.head);

}