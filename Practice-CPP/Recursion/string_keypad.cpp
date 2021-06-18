#include <iostream>
using namespace std;

int keypadSeqs(int input, string output[], string ref[]) {
    if (input <= 9) {
        for (int i = 0; i < ref[input].size(); i++) {
            output[i] = ref[input][i];
        }
        return ref[input].size();
    }
    int x = input % 10;
    int size = keypadSeqs(input/10, output, ref);
    int k = 0;
    string copyarray[size];

    for (int i = 0; i < size; i++) {
        copyarray[i] = output[i];
    }
    for (int i = 0; i < ref[x].size(); i++) {
        for (int j = 0; j < size; j++) {
            output[k++] = copyarray[j] + ref[x][i];
        }
    }
    return k;
}

int main() {
    
    string ref[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    string* output = new string[1000];
    int x = keypadSeqs(234, output, ref);
    for (int i = 0; i < x; i++) {
        cout << output[i] << endl;
    }
}