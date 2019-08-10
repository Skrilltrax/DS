//Reverse a string "bat and ball" -> "ball and bat"

#include <iostream>
using namespace std;

string reverse(string s ) {
    if (s.length() == 0) {
        return "";
    }
    string ans = reverse(s.substr(1, s.length() - 1));
    return ans + s[0];
}

int main() {
    string s = "My new string here";
    cout<<reverse(s)<<endl;
}