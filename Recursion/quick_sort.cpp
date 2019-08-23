#include <iostream>
using namespace std;

void swap(int arr[], int i1, int i2) {
    int temp = arr[i1];
    arr[i1] = arr[i2];
    arr[i2] = temp;
}

// int partition(int arr[], int si, int ei) {
//     int size = ei - si + 1;
//     int count = 0;
//     for (int i = si + 1; i < size; i++) {
//         if (arr[i] < arr[si]) {
//             count++;
//         }
//     }
//     swap(arr, si, count);

//     int i = si, j = ei;
//     while (i < count || j > count) {
//         if (arr[i] > arr[count]) {
//             if (arr[j] < arr[count]) {
//                 swap(arr, i, j);
//                 i++;
//                 j--;
//             } else {
//                 j--;
//             }
//         } else {
//             i++;
//         }
//     }
//     return count;
// }

// int partition (int arr[], int low, int high)  
// {  
//     int pivot = arr[high]; // pivot  
//     int i = (low - 1); // Index of smaller element  
  
//     for (int j = low; j <= high - 1; j++)  
//     {  
//         // If current element is smaller than or  
//         // equal to pivot  
//         if (arr[j] <= pivot)  
//         {  
//             i++; // increment index of smaller element  
//             swap(arr, i, j);  
//         }  
//     }  
//     swap(arr, i + 1, high);  
//     return (i + 1);  
// }  

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