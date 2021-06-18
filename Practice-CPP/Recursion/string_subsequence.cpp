#include <iostream>
using namespace std;

int subs(string input, string output[]) {
    if (input.empty()) {
        output[0] == "";
        return 1;
    }

    int size = subs(input.substr(1), output);
    for (int i = 0; i < size; i++) {
        output[size + i] = input[0] + output[i];
    }
    return 2*size;
}

int main() {
    string* output = new string[1000];
    int x = subs("abc", output);
    for (int i = 0; i < x; i++) {
        cout << output[i] << endl;
    }
}