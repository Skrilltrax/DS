#include <iostream>
using namespace std;

void printKeypad(int input, string output, string ref[]) {
    if (input == 0) {
        cout << output << endl;
        return;
    }
    int x = input % 10;
    for (int i = 0; i < ref[x].size(); i++) {
        printKeypad(input/10, output + ref[x][i], ref);
    }
}

int main() {

    string ref[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    string s = "";
    printKeypad(23, s, ref);
}