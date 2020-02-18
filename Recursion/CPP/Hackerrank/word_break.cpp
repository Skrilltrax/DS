// https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-5backtracking-158wordbreakproblem

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;

int wordBreak(string str, unordered_map<string, int> map, string ans)
{

    if (str.length() == 0)
    {
        ans.pop_back();
        cout << "(" << ans << ")";
        return 1;
    }

    int count = 0;

    for (int i = 1; i <= str.length(); i++)
    {
        string nstr = str.substr(0, i);
        if (map[nstr] != 0)
        {
            count += wordBreak(str.substr(i), map, ans + nstr + " ");
        }
    }
    return count;
}

void takeInput()
{
    int size = 0;
    string str = "";
    unordered_map<string, int> map;
    cin >> size;

    for (int i = 0; i < size; i++)
    {
        cin >> str;
        map[str]++;
    }
    cin >> str;
    wordBreak(str, map, "");
}

int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    takeInput();
    return 0;
}
