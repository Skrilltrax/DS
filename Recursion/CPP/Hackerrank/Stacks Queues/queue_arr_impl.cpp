#include <iostream>
#include "QueueLL.cpp"
using namespace std;

int main() {
    QueueLL<int> queue1;

    queue1.enqueue(1);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(2);
    cout << "REAR : " << queue1.getRear() << endl;
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(3);
    cout << "REAR : " << queue1.getRear() << endl;
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(4);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(5);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(6);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(7);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(8);
    cout << "REAR : " << queue1.getRear() << endl;
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(9);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(10);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(11);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.enqueue(12);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    cout << "SIZE : " << queue1.getSize() << endl;
}