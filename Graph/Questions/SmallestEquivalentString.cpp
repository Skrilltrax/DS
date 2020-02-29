#include <iostream>
#include "../Graph.hpp"
using namespace std;

int findParent(int u, vector<int> parent) {
    if (u == parent[u])
        return u;

    int par = findParent(parent[u], parent);
    parent[u] = par; 
    return par;
}

void unionRank(int u, int v, vector<int> &mat) {
    if (u < v) {
        mat[v] = u;
    } else {
        mat[u] = v;
    }
}

void solve(string str1, string str2, string str3, vector<int> &chars) {
    
    for (int i = 0; i < str1.length(); i++) {
        int p1 = findParent(str1[i] - 'a', chars);
        int p2 = findParent(str2[i] - 'a', chars);
        unionRank(p1, p2, chars);
    }

    for (int i = 0; i < str3.length(); i++) {
        cout << (char) (findParent(str3[i] - 'a', chars) + 'a');
    }

}

int main() {
    string str1, str2, str3;
    cin >> str1 >> str2 >> str3;
    vector<int> chars(26, 1); 
    for (int i = 0; i < 26; i++) {
        chars[i] = i;
    }
    solve(str1, str2, str3, chars);
}
