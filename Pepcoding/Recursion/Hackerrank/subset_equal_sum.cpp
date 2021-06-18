// https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-5backtracking-162partitionksubsetsequalsum

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool findSum(vector<int> nums, int idx, int k, vector<int> &sums)
{
    if (idx == nums.size())
    {
        for (int i = 0; i < sums.size(); i++)
        {
            cout << sums[i] << endl;
        }

        for (int i = 1; i < sums.size(); i++)
        {
            if (sums[i] != sums[i - 1])
            {
                return false;
            }
        }

        return true;
    }

    bool res = false;

    for (int i = 0; i < k; i++)
    {
        sums[i] += nums[idx];
        res = res || findSum(nums, idx + 1, k, sums);
        sums[i] -= nums[idx];
    }

    return res;
}

void takeInput()
{
    int size = 0;
    int k = 0;
    cin >> size;

    vector<int> nums;
    int x = 0;
    for (int i = 0; i < size; i++)
    {
        cin >> x;
        nums.push_back(x);
    }

    cin >> k;

    vector<int> sums(k, 0);

    if (findSum(nums, 0, k, sums) == true)
    {
        cout << "Yes";
    }
    else
    {
        cout << "No";
    }
}

int main()
{
    takeInput();
    return 0;
}
