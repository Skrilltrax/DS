#include <iostream>
using namespace std;

int lastIndex(int arr[], int size, int x) {
    if (size == 0) {
        return -1;
    }
    if (arr[size-1] == x) {
        return size - 1;
    }
    return lastIndex(arr, size - 1, x);
}

int lastIndexFromFirst(int arr[], int size, int x) {
    if (size == 1) {
        if (arr[0] == x) {
            return 0;
        } else {
            return -1;
        }
    }
    int smallerArrayResult = lastIndexFromFirst(++arr, size - 1, x);
    if (arr[0] == x) {
        return smallerArrayResult + 1;
    }
    if (smallerArrayResult == -1) {
        return -1;
    }
    return smallerArrayResult + 1;
}

int lastIndexFromFirstOriginal(int arr[], int size, int x) {
    if (size == 0) {
        return -1;
    }
    int smallerArrayResult = lastIndexFromFirst(arr + 1, size - 1, x);
    if (arr[0] == x) {
        return smallerArrayResult + 1;
    }
    if (smallerArrayResult == -1) {
        return -1;
    }
    return smallerArrayResult + 1;
}

int main(int argc, char const *argv[])
{
    int arr[] = {1, 2, 5, 5, 5};
    cout<<lastIndex(arr, 5, 5)<<endl;
    cout<<lastIndexFromFirst(arr, 5, 5)<<endl;
    cout<<lastIndexFromFirstOriginal(arr, 5, 5)<<endl;
    string s;
    return 0;
}
