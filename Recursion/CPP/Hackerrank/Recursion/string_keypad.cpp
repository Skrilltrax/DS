#include <iostream>
using namespace std;

int keypadSeqs(int input, string output[], string ref[]) {
    if (input == 0) {
        output[0] = "";
        return 1;
    }
    int x = input % 10;
    int size = keypadSeqs(input/10, output, ref);
    int k = size;
    for (int i = 0; i < ref[x].size(); i++) {
        for (int j = 0; j < size; j++) {
            output[k++] = ref[x][i] + output[j];
        }
    }
    return ref[x].size() * size + size;
}

int main() {
    
    string ref[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    string* output = new string[1000];
    int x = keypadSeqs(22, output, ref);
    for (int i = 0; i < x; i++) {
        cout << output[i] << endl;
    }
}