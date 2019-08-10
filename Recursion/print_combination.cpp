/*
 *Print all possible combinations of r elements in a given array of size 
 */

#include <iostream>
using namespace std;

void printPair(int arr[], int size, int pairSize) {
    if (size == 0) {
        return;
    }
    for (int i = 0; i < pairSize; i++) {
        cout<<arr[0]<<" ";
        if (pairSize != 0) {
            printPair(arr + 1, size - 1, (pairSize - i));
        } else {
            printPair(arr + 1, size - 1, (pairSize));
        }
    }
}

int main() {
    int arr[] = {1, 2, 3};
    printPair(arr, 3, 2);
}