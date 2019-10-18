#include <iostream>
using namespace std;

void performDFS(int** edges, int V, int sv, int* visited) {
    cout << sv << endl;
    visited[sv] = 1;
    for (int i = 0; i < V; i++) {
        if (sv == i) {
            continue;
        }
        if (visited[i] == 1) {
            continue;
        }
        if (edges[sv][i] == 1) {
            if (visited[i] == 1) {
                continue;
            }
            performDFS(edges, V, i, visited);
        }
        // cout << edges[sv][i] << " -> ";
    }
}

int main() {
    int V, E;
    cin >> V;
    cin >> E;
    int **edges = new int*[V];
    for (int i = 0; i < V; i++) {
        edges[i] = new int[V];
        for (int j = 0; j < V; j++) {
            edges[i][j] = 0;
        }
    }
    for (int i = 0; i < E; i++) {
        int v1, v2;
        cin >> v1 >> v2;
        edges[v1][v2] = 1;
        edges[v2][v1] = 1;
    }

    int* visited = new int[V];
    for (int i = 0; i < V; i++) {
        visited[i] = 0;
    }

    performDFS(edges, V, 0, visited);
}