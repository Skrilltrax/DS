#include <iostream>
#include "Node.cpp"
using namespace std;

void findMid(SingleLLHelper helper) {
    SingleLLHelper::Node *fast, *slow;
    fast = helper.head;
    slow = helper.head;

    while (fast != NULL && fast -> next != NULL) {
        fast = fast -> next -> next;
        slow = slow -> next;
    }
    cout << "Mid : " << slow -> data << endl;
}

void findEvenMid() {
    SingleLLHelper helperEven;
    helperEven.addNodeEnd(0);
    helperEven.addNodeEnd(10);
    helperEven.addNodeEnd(20);
    helperEven.addNodeEnd(30);
    helperEven.addNodeEnd(40);
    helperEven.addNodeEnd(50);
    findMid(helperEven);
}

void findOddMid() {
    SingleLLHelper helperOdd;
    helperOdd.addNodeEnd(0);
    helperOdd.addNodeEnd(10);
    helperOdd.addNodeEnd(20);
    helperOdd.addNodeEnd(30);
    helperOdd.addNodeEnd(40);
    findMid(helperOdd);
}

int main() {
    findEvenMid();
    findOddMid();
}