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

int main(int argc, char const *argv[])
{
    int arr[] = {1, 2, 3, 4, 5};
    cout<<lastIndex(arr, 5, 7)<<endl;
    return 0;
}
