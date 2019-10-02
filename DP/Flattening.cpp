#include <bits/stdc++.h>
using namespace std;

int minReq = 0;
void calculateChange(int a[], int n) {
    for (int i = 0; i < n; i++) {
        if (a[i] != 0) {
            if (a[i-1] != a[i]) {
                minReq++;
            }
            while
        }
    }
}

int main() {
    int t, a[1000], k, n;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> n >> k;
        int changeCount = 0;
        for (int j = 0; j < n; j++) {
            cin >> a[j];
            if (j != 0) {
                if (a[j] != a[j-1]) {
                    changeCount++;
                }
            }
        }

        int myChange = 0;

        for (int k = 0; k < n - 1; k++) {
            if (changeCount <= k) {
                break;
            }
            if (a[k] != a[k+1]) {
                if (a[k - 1] == a[k + 1]) {
                    myChange++;
                    changeCount--;
                    a[k] = a[k -1];
                } else {
                    if (a[k])
                    a[k] = a[k+1];
                    k++;
                    myChange++;
                }
            }
        }

        // if (changeCount <= k) {
        //     if (i == t -1) {
        //         cout << "Case #" << i + 1 << ": 0"; 
        //     } else {
        //         cout << "Case #" << i + 1 << ": 0" << endl;                 
        //     }
        // } else {
        //         if (i == t -1) {
        //             cout << "Case #" << i + 1 << ": " << (changeCount/k); 
        //         } else {
        //             cout << "Case #" << i + 1 << ": " << (changeCount/k) << endl;                 
        //         }
        // }
    }
}