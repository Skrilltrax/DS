/**
 * Find if rat can reach the end of maze withing given number of moves
 * */
#include <cmath>
#include <climits>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int mazeSize = 0;
int maxAllowedMoves = 0;
int minMoves = INT_MAX;
vector<vector<int>> moves = vector<vector<int>> {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // U, R, D, L

bool isSafe(vector<vector<int>> maze, int r, int c) {
    if (r < 0 || c < 0 || c >=maze.size() || r >= maze[0].size() || maze[r][c] == 0) {
        return false;
    }
    return true;
}

int findSol(vector<vector<int>> maze, int sr, int sc, int moves) {
    if (sr == maze[0].size() - 1 && sc == maze.size() - 1) {
        if (moves < minMoves)
            minMoves = moves;
        return 1;
    }
    
    maze[sr][sc] = 0;
    int count = 0;
    for (int i = 0; i < ::moves.size(); i++) {
        int nsr = sr + ::moves[i][0];
        int nsc = sc + ::moves[i][1];
        if (isSafe(maze, nsr, nsc)) {
            count += findSol(maze, nsr, nsc, moves + 1);
        }
    }
    
    maze[sr][sc] = 1;
    return count;
}

void takeInput() {
    cin >> mazeSize;
    vector<vector<int>> maze = vector<vector<int>>(mazeSize, vector<int>(mazeSize, 0));
    for (int i = 0; i < mazeSize; i++) {
        for (int j = 0; j < mazeSize; j++) {
            cin >> maze[i][j];
        }
    }
    cin >> maxAllowedMoves;
    findSol(maze, 0, 0, 0);
    bool ans = minMoves < maxAllowedMoves;
    cout << ans;
}

int main() {
    takeInput();
    return 0;
}