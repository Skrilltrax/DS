#include <iostream>
#include "Graph.hpp"
using namespace std;

int count = 0;
int srcCalls = 0;
int arcount = 0;
vector<bool> arp(13, false);

void dfs(int src, int par, vector<vector<Edge *>> graph, vector<bool> &vis, vector<int> &dis, vector<int> &lowest)
{
    vis[src] = true;
    lowest[src] = dis[src] = count++;

    for (Edge *e : graph[src])
    {
        int v = e->v;
        
        if (!vis[v]) {
            if (src == 0) {
                srcCalls++;
            }

            dfs(v, src, graph, vis, dis, lowest);

            if (dis[src] <= lowest[v]) {
                if (arp[src] != true) {
                    arp[src] = true;
                    cout << src << " " <<  (boolalpha) << arp[src] << endl;
                    arcount++;
                }
            }

            lowest[src] = min(lowest[src], lowest[v]);
        }
        else if (par != -1 && v != par){
            lowest[src] = min(lowest[src], dis[v]);
        }
    }
}

void solve(vector<vector<Edge *>> graph) {

    vector<int> lowest(13, 0);
    vector<int> dis(13, 0);
    vector<bool> vis(13, false);

    dfs(0, -1, graph, vis, dis, lowest);
    cout << srcCalls << endl;
    if (srcCalls == 1) {
        arcount--;
    }

    cout << arcount << endl;
}

int main()
{

    Graph graphHelper;

    graphHelper.initializeInstance(13, true);

    // graphHelper.addEdge(0,1,0);
    // graphHelper.addEdge(0,3,0);
    // graphHelper.addEdge(1,2,0);
    // graphHelper.addEdge(2,3,0);
    // graphHelper.addEdge(2,4,0);
    // graphHelper.addEdge(4,5,0);
    // graphHelper.addEdge(5,6,0);
    // graphHelper.addEdge(6,7,0);
    // graphHelper.addEdge(6,8,0);
    // graphHelper.addEdge(6,9,0);
    // graphHelper.addEdge(8,10,0);
    // graphHelper.addEdge(8,11,0);
    // graphHelper.addEdge(10,11,0);
    // graphHelper.addEdge(11,12,0);
    // graphHelper.addEdge(9,13,0);

    graphHelper.addEdge(0, 1, 0);
    graphHelper.addEdge(0, 3, 0);
    graphHelper.addEdge(1, 2, 0);
    graphHelper.addEdge(2, 3, 0);
    graphHelper.addEdge(2, 4, 0);
    graphHelper.addEdge(4, 5, 0);
    graphHelper.addEdge(5, 6, 0);
    graphHelper.addEdge(6, 7, 0);
    graphHelper.addEdge(7, 8, 0);
    graphHelper.addEdge(7, 9, 0);
    graphHelper.addEdge(9, 10, 0);
    graphHelper.addEdge(10, 11, 0);
    graphHelper.addEdge(11, 12, 0);
    graphHelper.addEdge(10, 12, 0);
    graphHelper.addEdge(12, 6, 0);

    vector<vector<Edge *>> graph = graphHelper.getInstance();
    solve(graph);
}