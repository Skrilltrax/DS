#include <iostream>
#include <queue>
using namespace std;

int main() {
    queue<int> queue;
    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(4);
    queue.push(5);
    queue.push(6);
    queue.push(7);

    cout << queue.front() << queue.back();
}