#include <iostream>
using namespace std;

class Edge
{
public:
    int v;
    int weight;

    Edge() : v(0), weight(0) {}

    Edge(int v, int weight)
    {
        this->v = v;
        this->weight = weight;
    }
};