#include <iostream>
#include "QueueArr.cpp"
using namespace std;

int main() {
    Queue<int> queue1(500);
    Queue<int> queue2(50);

    queue1.enqueue(1);
    queue1.enqueue(2);
    queue1.enqueue(3);
    queue1.enqueue(4);
    queue1.enqueue(5);
    queue1.enqueue(6);
    cout << "SIZE : " << queue1.getSize() << endl;
}