#include <iostream>
#include "../Graph.hpp"
using namespace std;

void dfs(int src, vector<vector<Edge *>> graph, vector<bool> &visited) {
    for (int i = 0; i < graph[src].size(); i++) {
        visited[graph[src][i]->v] = true;
        dfs(graph[src][i]->v, graph, visited);
    }
}

bool isConnected(vector<vector<Edge *>> graph) {
    vector<bool> visited(graph.size(), false);
    dfs(1, graph, visited);
    
    for (int i = 0; i < visited.size(); i++) {
        if (visited[i] == false) {
            return false;
        }
    }

    return true;
}

vector<vector<Edge *>> takeInput() {
    int n = 0, m = 0, k = 0;
    cin >> n >> m >> k;
    vector<vector<Edge *>> graph(k, vector<Edge *>(m, new Edge())); 

    int a = 0, b = 0, c = 0;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> c;
        graph[a][b]->v = b;
        graph[a][b]->weight = c;
    }

    return graph;
}


void solve() {

    vector<vector<Edge *>> graph = takeInput();
    if(!isConnected(graph)) {
        cout << 1;
    } else {
        cout << 0;
    }
}

int main() {
    solve();
    return 0;
} 