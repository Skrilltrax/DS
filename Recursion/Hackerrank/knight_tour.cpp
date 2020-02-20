//https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-154knightstour

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

vector<vector<int>> moves = {{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
//UR, UL, DR, DL, LU, LD, RU, RD

bool isSafe(vector<vector<bool>> board, int sr, int sc)
{
    int size = board.size();
    if (sr < 0 || sc < 0 || sr >= size || sc >= size || board[sr][sc])
    {
        return false;
    }
    return true;
}

bool knightTour(vector<vector<bool>> &board, int sr, int sc, int count, string ans)
{
    if (count == board.size() * board.size() - 1)
    {
        cout << ans << endl;
        return true;
    }

    board[sr][sc] = true;
    bool res = false;

    for (int i = 0; i < moves.size(); i++)
    {
        int nsr = sr + moves[i][0];
        int nsc = sc + moves[i][1];

        if (isSafe(board, nsr, nsc))
        {
            res = res || knightTour(board, nsr, nsc, count + 1, ans + to_string("(" + sr + " " + sc + ") "));
        }
    }

    board[sr][sc] = false;

    return res;
}

bool takeInput()
{
    int size = 0;
    int x = 0;
    int y = 0;

    cin >> size;
    cin >> x;
    cin >> y;

    vector<vector<bool>> board(size, vector<bool>(size, false));
    return knightTour(board, x, y, 0);
}

int main()
{
    bool ans = takeInput();
    if (ans)
    {
        cout << "true";
    }
    else
    {
        cout << "false";
    }
    return 0;
}
