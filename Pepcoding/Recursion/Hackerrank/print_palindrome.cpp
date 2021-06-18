//https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-5backtracking-159printallpalindromicpartitions/problem

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool checkPalindrome(string str)
{
    int length = str.length();
    for (int i = 0, j = length - 1; i < length / 2; i++, j--)
    {
        if (str[i] != str[j])
            return false;
    }
    return true;
}

int palindromePrints(string str, string ans)
{
    if (str.length() == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;

    for (int i = 1; i <= str.length(); i++)
    {
        string nstr = str.substr(0, i);
        if (checkPalindrome(nstr))
        {
            count += palindromePrints(str.substr(i), ans + nstr + " ");
        }
    }
    return count;
}
void takeInput()
{
    string str;
    cin >> str;

    palindromePrints(str, "");
}

int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    takeInput();
    return 0;
}
