#include <iostream>
using namespace std;

int* countNum(int arr[], int num, int count, int size) {

    if (size == 0) {
        int reArr[count];
        return reArr; 
    }

    if (arr[size-1] == num) {
        count++;
    }

    int *nArr = countNum(arr+1, num, count, size--);
    nArr[count - 1] = num;
    return nArr;
}

int fac(int n) {
    if (n <= 1)
        return 1;
    return n * fac(n - 1);
}

int powI(int a, int b) {
    if (b == 0)
        return 1;
    if (a <= 1)
        return a;
    return powI(a, b-1) * a;
}

int powII(int a, int b) {
    if (b == 0)
        return 1;
    if (a <= 1)
        return a;
    int smallAns = powII(a, b/2);
    return smallAns * smallAns * a;
}

void powSolve() {
    int a = 0, b = 0;
    cin >> a >> b;
    cout << powI(a, b);
    cout << powII(a, b);
}

void solve() {

    // powSolve();
    int arr[] = {1, 2, 3, 2, 4, 2, 5};
    int *reArr = countNum(arr, 2, 0, sizeof(arr)/sizeof(int) - 1);
}


int main() {
    solve();
    return 0;
}