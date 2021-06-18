#include <iostream>
using namespace std;

void swap(int arr[], int i1, int i2) {
    int temp = arr[i1];
    arr[i1] = arr[i2];
    arr[i2] = temp;
}

int partition (int arr[], int low, int high) {
    int i = 0, j = 0, count = low;
    for (i = low + 1; i < high + 1; i++) {
        if (arr[i] < arr[low]) {
            count++;
        }
    }
    swap(arr, low, count);

    i = low;
    j = high; 
    while (i < count && j > count) {
        if (arr[i] > arr[count]) {
            if (arr[j] < arr[count]) {
                swap(arr, i, j);
                i++;
                j--;
            } else {
                j--;
            }
        } else {
         i++;   
        }
    }
    return count;
}

void quickSort(int arr[], int si, int ei) {
    if (si < ei) {
    int c = partition(arr, si, ei);
    quickSort(arr, si, c - 1);
    quickSort(arr, c + 1, ei);
    }
}

int main() {
    int arr[] = {5, 4, 3, 2, 1};
    quickSort(arr, 0, 4);
    for (int i = 0; i < 5; i++) {
        cout<<arr[i]<<" ";
    }
}
