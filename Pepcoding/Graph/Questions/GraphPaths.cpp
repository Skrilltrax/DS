#include <iostream>
#include "../Graph.hpp"
using namespace std;

bool hasPath(const vector<vector<Edge *>> &graph, int src, int dest, vector<bool> &visited, string ans)
{
    if (src == dest)
    {
        cout << ans + to_string(dest) << endl;
        return true;
    }

    visited[src] = true;
    bool res = false;

    for (int i = 0; i < graph[src].size(); i++)
    {
        if (!visited[graph[src][i]->v])
        {
            res = res || hasPath(graph, graph[src][i]->v, dest, visited, ans + to_string(src) + " -> ");
        }
    }
    return res;
}

void allPaths(const vector<vector<Edge *>> &graph, int src, int dest, vector<bool> &visited, string ans)
{
    if (src == dest)
    {
        cout << ans + to_string(dest) << endl;
        return;
    }

    visited[src] = true;

    for (int i = 0; i < graph[src].size(); i++)
    {
        if (!visited[graph[src][i]->v])
        {
            allPaths(graph, graph[src][i]->v, dest, visited, ans + to_string(src) + " -> ");
        }
    }
    visited[src] = false;
}

void hamiltonianCycle(const vector<vector<Edge *>> &graph, int osrc, int src, int count, vector<bool> &visited, string ans)
{
    if (count == graph.size() - 1)
    {
        ans += to_string(src);
        for (Edge *e : graph[src])
        {
            if (e->v == osrc)
            {
                cout << "Hamiltonian Cycle" << endl;
                cout << ans << endl;
            }
        }
        return;
    }

    visited[src] = true;
    for (int i = 0; i < graph[src].size(); i++)
    {
        if (!visited[graph[src][i]->v])
        {
            hamiltonianCycle(graph, osrc, graph[src][i]->v, count + 1, visited, ans + to_string(src) + " -> ");
        }
    }
    visited[src] = false;
}

int main()
{
    Graph graph;
    graph.initializeInstance(4, true);

    // graph.addEdge(0, 1, 10);
    // graph.addEdge(1, 2, 10);
    // graph.addEdge(2, 3, 40);
    // graph.addEdge(0, 3, 10);
    // graph.addEdge(3, 4, 2);
    // graph.addEdge(4, 5, 2);
    // graph.addEdge(5, 6, 8);
    // graph.addEdge(4, 6, 3);

    // graph_02===================
    // graph.addEdge(0, 1, 10);
    // graph.addEdge(1, 2, 10);
    // graph.addEdge(1, 3, 40);
    // graph.addEdge(1, 4, 10);
    // graph.addEdge(3, 4, 2);
    // graph.addEdge(0, 3, 2);
    // graph.addEdge(2, 4, 2);

    for (int i = 0; i < 3; i++)
    {
        for (int j = i+1; j < 4; j++)
        {
            graph.addEdge(i, j, 1);
        }
    }
    vector<bool> visited(4, false);

    // cout << hasPath(graph.getInstance(), 0, 4, visited, "");
    // allPaths(graph.getInstance(), 0, 3, visited, "");
    graph.display();
    hamiltonianCycle(graph.getInstance(), 0, 0, 0, visited, "");
}