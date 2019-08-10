#include <iostream>
using namespace std;

int getAllIndices(int a[], int size, int x, int output[]) {
    if (size == 0) {
        return 0;
    }
    int ans = getAllIndices(a + 1, size - 1, x, output);
    int outputSize = 7;
    if (a[0] == x) {
        for (int i = ans; i > 0; i--) {
            output[i] = output[i-1]+1;
        }
        output[0] = 0;
        return ans + 1;
    } else {
        for (int i = ans - 1; i >= 0; i--) {
            output[i] = output[i]+1;
        }
        return ans;
    }
} 

int main() {
    int arr[] = {1, 2, 3, 5, 5, 5, 5};
    int arr2[] = {1, 2, 2};
    int output[7];
    cout<< getAllIndices(arr, 7, 1, output)<<endl;
}