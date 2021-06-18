// https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-5backtracking-160shortestsafepathlandmines
// Segfault 1 test case

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int minCount = INT32_MAX;

vector<vector<int>> moves = { {-1,0}, {1,0}, {0,-1}, {0,1}}; // U, D, L, R

bool isSafe(vector<vector<int>> mat, int r, int c)
{
    int rSize = mat.size();    
    int cSize = mat[0].size();

    if (r < 0 || c < 0 || r >= rSize || c >= cSize || mat[r][c] == 2 || mat[r][c] == 0)
    {
        return false;
    } else {
        if (r < rSize - 1 && c < cSize - 1 
            && (mat[r-1][c] == 0 || mat[r+1][c] == 0 || mat[r][c-1] == 0 || mat[r][c+1] == 0))
        {
            return false;
        }
        return true;
    }
}

int solve(vector<vector<int>> &mat, int sr, int sc, int count)
{
    if (sc == mat[0].size() - 1) {
        if (count < minCount) 
        {
            minCount = count;
        }
        return 1;
    }
    
    int numCount = 0;
    mat[sr][sc] = 2;
    
    for (int i = 0; i < moves.size(); i++)
    {
        int nsr = sr + moves[i][0];
        int nsc = sc + moves[i][1];

        if(isSafe(mat, nsr, nsc))
        {
            numCount += solve(mat, nsr, nsc, count + 1);
        }
    }
    
    mat[sr][sc] = 1;
    return numCount;
}

void takeInput()
{
    int r, c;
    // cin >> r >> c;
    // vector<vector<int>> mat(r,vector<int>(c,0));
    // for (int i = 0; i < r; i++)
    //     for (int j = 0; j <c ; j++)
    //         cin >> mat[i][j];
    
    int r = 12, c = 10;
    vector<vector<int>> mat = 
    { 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } 
    }; 

    for (int i = 0; i < r; i++)
        solve(mat, i, 0, 0);
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    takeInput();
    cout << minCount;
    return 0;
}
