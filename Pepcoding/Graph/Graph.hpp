#include "Edge.hpp"
#include <vector>

class Graph
{
    int size;
    bool bidirectional;
    vector<vector<Edge *>> graph;

public:
    void initializeInstance(int size, bool bidirectional)
    {
        this->size = size;
        this->bidirectional = bidirectional;
        graph.resize(size);
    }

    vector<vector<Edge *>> getInstance() {
        return graph;
    }

    void createGraph(int size, bool bidirectional)
    {
        this->size = size;
        this->bidirectional = bidirectional;

        int u, v, weight, edges;
        graph.resize(size);

        cout << "No. of edges : " << endl;
        cin >> edges;
        for (int i = 0; i < edges; i++)
        {
            cout << "Enter u: ";
            cin >> u;
            cout << "Enter v: ";
            cin >> v;
            cout << "Enter weight: ";
            cin >> weight;
            addEdge(u, v, weight);
        }
    }

    void addEdge(int u, int v, int weight)
    {
        if (bidirectional)
        {
            graph[u].push_back(new Edge(v, weight));
            graph[v].push_back(new Edge(u, weight));
        }
        else
        {
            graph[u].push_back(new Edge(v, weight));
        }
    }

    void removeVertex1(int u)
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < graph[i].size(); j++)
            {
                if (graph[i][j]->v == u)
                {
                    graph[i].erase(graph[i].begin() + j);
                }
            }
        }
        graph[u].clear();
    }

    void removeEdge1(int u, int v)
    {
        for (int i = 0; i < graph[u].size(); i++)
        {
            if (graph[u][i]->v == v)
            {
                graph[u].erase(graph[u].begin() + i);
            }
        }

        if (bidirectional)
        {

            for (int i = 0; i < graph[v].size(); i++)
            {
                if (graph[v][i]->v == u)
                {
                    graph[v].erase(graph[v].begin() + i);
                }
            }
        }
    }

    void display()
    {
        for (int i = 0; i < size; i++)
        {
            cout << i << " : ";
            for (int j = 0; j < graph[i].size(); j++)
            {

                cout << "(" << graph[i][j]->v << " / " << graph[i][j]->weight << ") ";
            }
            cout << endl;
        }
    }

    ~Graph()
    {
        for (vector<Edge *> v : graph)
        {
            for (Edge *e : v)
            {
                delete e;
            }
            v.clear();
        }
    }
};