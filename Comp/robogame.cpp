//https://www.codechef.com/PRIN19/problems/ROBOGAME
#include <iostream>
using namespace std;

void solve(string eq) {
    int size = eq.length();
    int arr[size]; 
    for (int i = 0; i < size; i++) {
        if (eq[i] == '.')  {
            arr[i] = 0;
        } else {
            arr[i] = eq[i] - '0';
        }
    }
    for (int i = 0; i < size; i++) {
        int x = arr[i];
        if (x == -1) {
            continue;
        }
        for (int j = i + 1, k = 0; k < x && j < size; k++, j++) {
            if (arr[j] != 0) {
                cout << "unsafe" << endl;
                return;
            } else {
                arr[j] = -1;
            }
        }

        for (int j = i - 1, k = 0; k < x && j > 0; k++, j--) {
            if (arr[j] != 0) {
                cout << "unsafe" << endl;
                return;
            } else {
                arr[j] = -1;
            }
        }
    }
    cout << "safe" << endl;
}

int main() {
    long l; 
    cin >> l;
    for (long i = 0; i < l; i++) {
        string eq;
        cin >> eq;
        solve(eq); 
    }
}