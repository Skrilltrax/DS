#include <iostream>
using namespace std;

int length(char str[]) {
    if (str[0] == '\0') {
        return 0;
    }
    // cout<<str[0];
    return 1 + length(str + 1);
}

int main() {
    char str[] = {'1', '2', '3', '4', '\0'};
    char str2[] = "sadsafas";   //IDK why its getting concatenated lol
    cout<<length(str)<<endl;
    // cout<<length(str2)<<endl;

}