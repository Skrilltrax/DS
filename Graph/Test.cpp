#include "Graph.hpp"
using namespace std;

int main()
{
    Graph graph;
    graph.createGraph(3, false);
    graph.display();
    graph.removeVertex1(0);
    cout << endl;
    graph.display();
}