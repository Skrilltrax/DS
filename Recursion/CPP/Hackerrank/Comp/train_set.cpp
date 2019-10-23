#include <bits/stdc++.h>
using namespace std;

void printFrequencies(const string &str) 
{ 
    unordered_map<string, int> wordFreq; 
  
    stringstream ss(str);   
    string word;  
    while (ss >> word) 
        wordFreq[word]++; 
  
    unordered_map<string, int>:: iterator p; 
    for (p = wordFreq.begin(); p != wordFreq.end(); p++) 
        cout << "(" << p->first << ", " << p->second << ")\n"; 
} 

void calcAns(unordered_map<string, int> words) {
    for (auto i = words.begin(); i!= words.end(); i++) {
        string k = i -> first;
        int val = i -> second;
    }
}

void calculate() {
    int c = 0;
    cin >> c;
    unordered_map<string, int> wordFreq;
    for (int i = 0; i < c; i++) {
        string skey;
        int sval;
        cin >> skey;
        cin >> sval;
        string skey2 = skey + to_string(sval);
        if (wordFreq.find(skey) == wordFreq.end()) {
            wordFreq[skey2] = 1;
        } else {
            wordFreq[skey2]++;
        }
    }
    calcAns(wordFreq);
}

int main() {
    long long t = 0;
    for (long long i = 0; i < t; i++) {
        calculate()
    }
    return 0;
}