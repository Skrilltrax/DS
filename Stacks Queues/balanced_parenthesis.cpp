#include <iostream>
#include <string>
#include "StackLL.cpp"
using namespace std;

bool balanceParenthesis(string str) {
    Stack<char> stack;
    for (auto const &s: str) {
        switch (s) {
        case '(':
            stack.push('(');
            break;
        case ')':
            if (stack.getTop() == '(')
                stack.pop();
            else
                stack.push(')');
            break;
        case '[':
            stack.push('[');
            break;
        case ']':
            if (stack.getTop() == '[')
                stack.pop();
            else
                stack.push(']');
            break;
        case '{':
            stack.push('{');
            break;
        case '}':
            if (stack.getTop() == '{')
                stack.pop();
            else
                stack.push('}');
            break;
        default:
            break;
        }
    }
    return stack.isEmpty();
}

int main() {
    string str = "{[()(]}";
    if (balanceParenthesis(str)) {
        cout << "Balanced" << endl;
    } else {
        cout << "Unbalanced" << endl;
    }
}