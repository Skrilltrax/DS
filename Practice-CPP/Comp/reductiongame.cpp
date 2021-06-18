#include <iostream>
using namespace std;

void solve(int *arr, int size, int k) {
    int count = 0;
    for (int i = 0; i < size; i++) {
        if (arr[i] > k) {
            count++;
        }
    }

    int great[count];
    for (int i = 0; i < count; i++) {
        great[i] = arr[i];
    }
}

int main() {
    long t;
    cin >> t;
    for (long i = 0; i < t; i++) {
        int size, k;
        int arr[size];
        cin >> size >> k;
        for (int i = 0; i < size; i++) {
            cin >> arr[k];
        }

        solve(arr, size, k);

    }
}