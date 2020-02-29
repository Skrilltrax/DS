// https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-5backtracking-170findpathsfromcornertomiddlecell

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

vector<vector<int>> moves = { {1, 0}, {0, 1}, {0, -1}, {-1, 0}};

bool isSafe(vector<vector<int>> board, int r, int c)
{
    if (r < 0 || c < 0 || r >= board.size() || c >= board[0].size() || board[r][c] == -1)
    {
        return false;
    }
    return true;
}

int reachMid(vector<vector<int>> &board, int sr, int sc, string ans) {
    if (sr == board.size()/2 && sc == board[0].size()/2)
    {
        cout << ans << "MID" << endl;
        return 1;
    }
    
    int count = 0;
    
    int num = board[sr][sc];
    board[sr][sc] = -1;

    for (int i = 0; i < moves.size(); i++)
    {
        int nsr = sr + moves[i][0]*num;
        int nsc = sc + moves[i][1]*num;
        
        if (isSafe(board, nsr, nsc))
            count += reachMid(board, nsr, nsc, ans + to_string(sr) + to_string(sc) + " " );
    }
    
    board[sr][sc] = num;
    return count;
}

void takeInput() 
{
    int n, m;
    cin >> n >> m;
    vector<vector<int>> board(n, vector<int>(m,0));
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> board[i][j];
    for (int i = 0 ; i < n; i++)
        reachMid(board, i, 0, "");
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    takeInput();
    return 0;
}
