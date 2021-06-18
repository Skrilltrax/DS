// https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-5backtracking-160shortestsafepathlandmines

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

int minCount = INT_MAX;
vector<vector<int>> moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U, D, L, R

bool isSafe(vector<vector<int>> matrix, int r, int c)
{
    int size = matrix.size();
    if (r < 0 || c < 0 || r >= size || c >= size || matrix[r][c] == 0 || matrix[r][c] == 2)
    {
        return false;
    } 
    else 
    {
        if (r == size - 1 || c == size - 1) {
            return true;
        } 
        if (matrix[r - 1][c] == 0 || matrix[r + 1][c] == 0 || matrix[r][c - 1] == 0 || matrix[r][c + 1] == 0) 
        {
            return false;
        }
    return true;
    }
}

void shortestSafePath(vector<vector<int>> &matrix, int sr, int sc, int count)
{
    if (sc == matrix[0].size() - 1)
    {
        if (count < minCount)
            minCount = count;
    }

    for (int i = sc; i < matrix[0].size(); i++)
    {
        matrix[sr][i] = 2;
        for (int j = 0; j < moves.size(); j++)
        {
            int nsr = sr + moves[j][0];
            int nsc = i + moves[j][1];
            if (isSafe(matrix, nsr, nsc))
            {
                shortestSafePath(matrix, nsr, nsc, count + 1);
            }
        }
        matrix[sr][i] = 1;
    }
}
void takeInput()
{
    int r = 0;
    int c = 0;

    cin >> r >> c;
    vector<vector<int>> matrix(r, vector<int>(c, 0));

    for (int i = 0; i < r; i++)
    {
        for (int j = 0; j < c; j++)
        {
            cin >> matrix[i][j];
        }
    }

    shortestSafePath(matrix, 0, 0, 0);
}

int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    takeInput();
    return 0;
}
