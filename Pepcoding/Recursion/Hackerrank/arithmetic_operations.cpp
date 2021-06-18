// https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-5backtracking-171arithmeticexpression/

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

vector<char> operators = {'+', '-', '*'};

bool solveExpression(vector<int> nums, vector<char> ops, int index, string sans)
{
    if (index == nums.size() -1)
    {
        // cout << sans;
        int ans = nums[0];
        for (int i = 0; i < ops.size(); i++) {
            switch(ops[i]) {
                case '+': 
                    ans += nums[i+1];
                    break;
                case '-': 
                    ans -= nums[i+1];
                    break;
                case '*': 
                    ans *= nums[i+1];
                    break;
            }
            
        }
        if (ans % 101 == 0) {
            for (int i = 0; i < nums.size() - 1; i++)
            {
                cout << nums[i] << (char) ops[i];
            }
            cout << nums[index];
            return true;
        }
        return false;
    }
    
    bool res = false;
    
    for (int i = 0; i < operators.size(); i++)
    {
        char op = operators[i];
        ops.push_back(op);
        res = res || solveExpression(nums, ops, index + 1, sans + to_string(nums[index]) + to_string((char)op));
        ops.pop_back();

    }
    return res;
}

void takeInput()
{
    int size = 0;
    cin >> size;
    vector<int> nums(size, 0);
    for (int i = 0; i < size; i++)
        cin >> nums[i];
    
    solveExpression(nums, vector<char>(), 0, "");
}
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    takeInput();
    return 0;
}
