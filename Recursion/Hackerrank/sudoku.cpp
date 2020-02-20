//https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-5backtracking-156sudoku

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

vector<int> rowBit(9, 0);
vector<int> colBit(9, 0);
vector<vector<int>> matBit(3, vector<int>(3, 0));

int sudoku(vector<vector<int>> &board, int boxNo)
{
    if (boxNo == 81)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                cout << board[i][j] << " ";
            }
            cout << endl;
        }
        return 1;
    }

    int count = 0;

    int nsr = boxNo / 9;
    int nsc = boxNo % 9;

    if (board[nsr][nsc] == 0)
    {
        for (int i = 1; i <= 9; i++)
        {
            int mask = (1 << i);

            if (((rowBit[nsr] & mask) == 0) && ((colBit[nsc] & mask) == 0) && ((matBit[nsr / 3][nsc / 3] & mask) == 0))
            {
                board[nsr][nsc] = i;

                rowBit[nsr] |= mask;
                colBit[nsc] |= mask;
                matBit[nsr / 3][nsc / 3] |= mask;

                count += sudoku(board, boxNo + 1);

                rowBit[nsr] &= (~mask);
                colBit[nsc] &= (~mask);
                matBit[nsr / 3][nsc / 3] &= (~mask);

                board[nsr][nsc] = 0;
            }
        }
    }
    else
    {
        count += sudoku(board, boxNo + 1);
    }
    return count;
}

void takeInput()
{
    vector<vector<int>> board(9, vector<int>(9, 0));

    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cin >> board[i][j];
        }
    }

    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            if (board[i][j] != 0)
            {
                int mask = (1 << board[i][j]);
                rowBit[i] |= mask;
                colBit[j] |= mask;
                matBit[i / 3][j / 3] |= mask;
            }
        }
    }

    sudoku(board, 0);
}

int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    takeInput();
    return 0;
}
