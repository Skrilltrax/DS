#include <iostream>
#include <list>
using namespace std;

class Graph {
    int V;
    bool directed;
    list<int> *adjList;
    
    void performDFS(int v, bool* visited);
    
    public:
    Graph(int v, bool directed);
    
    void dfs(int v);
    void addEdge(int v1, int v2);
};

Graph::Graph(int v, bool directed) {
    V = v;
    adjList = new list<int>[V];
    this -> directed = directed;
}

void Graph::addEdge(int v1, int v2) {
    if (directed) {
        adjList[v1].push_back(v2);        
    } else {
        adjList[v1].push_back(v2);        
        adjList[v2].push_back(v1);        
    }
}

void Graph::dfs(int v) {
    bool* visited = new bool[this -> V];
    for (int i = 0; i < V; i++) {
        visited[i] = false;
    }
    performDFS(v, visited);
}

void Graph::performDFS(int v, bool* visited) {
    visited[v] = true;
    cout << v << endl;
    list<int>::iterator i;
    for (i = adjList[v].begin(); i != adjList[v].end(); i++) {
        if (!visited[*i]) {
            performDFS(*i, visited);
        }
    }
}

int main() {
    Graph graph = Graph(4, true);
    graph.addEdge(0,2);
    graph.addEdge(2,0);
    graph.addEdge(2,1); 
    graph.addEdge(1,3); 
    graph.dfs(0);
}