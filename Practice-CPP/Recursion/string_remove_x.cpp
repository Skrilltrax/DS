#include <iostream>
using namespace std;

void removeX(char str[]) {
    if (str[0] == '\0') {
        return;
    }
    if (str[0] != 'x') {
        return removeX(str + 1);
    } else {
        int i = 1;
        for (; str[i] != '\0'; i++) {
            str[i - 1] = str[i];
        }
        str[i - 1] = str[i];
        removeX(str);
    }
}

int main() {
    char str[] = "xxaaxaaxx";
    removeX(str);
    cout<<str<<endl;
}