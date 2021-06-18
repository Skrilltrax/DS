#include <iostream>
using namespace std;

int firstIndex(int arr[], int size, int x) {
    if (size == 0) {
        return -1;
    }
    if (arr[0] == x) {
        return 0;
    }
    int smallerArrayResult = firstIndex(++arr, size - 1, x);
    if (smallerArrayResult == -1) {
        return -1;
    } else {
        return smallerArrayResult + 1;
    }
}

int main() {
    int arr[] = {1, 5, 3, 4, 5};
    cout<<firstIndex(arr, 5, 5)<<endl; 
}