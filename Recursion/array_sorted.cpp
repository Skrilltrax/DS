#include <iostream>
using namespace std;

bool isSorted(int array[], int size) {
    if (size == 1) {
        return true;
    }

    if (array[0] > array[1]) {
        return false;
    }

    bool isRemainingArraySorted = isSorted(++array, size - 1);
    return isRemainingArraySorted;
}

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int arr2[] = {1, 3, 5, 2, 6};

    cout<<isSorted(arr, 5)<<endl;
    cout<<isSorted(arr2, 5)<<endl;

}