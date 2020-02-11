#include <climits>
#pragma once

class AVLNode {
    public: 

    int data;
    int height;
    int bal;
    AVLNode *left;
    AVLNode *right;

    AVLNode(int data, AVLNode *left, AVLNode *right) {
        this -> data = data;
        this -> left = left;
        this -> right = right;
    }

    AVLNode() {
        AVLNode(INT_MIN, nullptr, nullptr);
    }   

};