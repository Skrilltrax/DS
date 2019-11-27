#include <iostream>
#include "QueueArr.cpp"
using namespace std;

int main() {
    Queue<int> queue1(5);
    Queue<int> queue2(50);

    queue1.enqueue(1);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.enqueue(2);
    cout << "REAR : " << queue1.getRear() << endl;
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.enqueue(3);
    cout << "REAR : " << queue1.getRear() << endl;
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.enqueue(4);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.enqueue(5);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.enqueue(6);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.enqueue(7);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.enqueue(8);
    cout << "REAR : " << queue1.getRear() << endl;
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.enqueue(9);
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
    queue1.dequeue();
    cout << "REAR : " << queue1.getRear() << endl; 
    cout << "FRONT : " << queue1.getFront() << endl;
}