/*
 * Deep copy a linked list. with random pointer.
 * https://leetcode.com/problems/copy-list-with-random-pointer/ 
 */

// Definition for a Node.

#include<bits/stdc++.h>
using namespace std;

class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
class Solution {
public:
    Node* copyRandomList(Node* head) {
        Node* tmp1 = head;
        Node* tmp2 = NULL;

        if (head == NULL)
            return NULL;
        
        
        while (tmp1 != NULL) {
            tmp2 = new Node(tmp1 -> val);
            tmp2 -> next = tmp1 -> next;
            tmp1 -> next = tmp2;
            tmp1 = tmp2 -> next;
        }
        
        tmp1 = head;
        tmp2 = head -> next;
        
        while (tmp1!= NULL && tmp2!= NULL) {
            if (tmp1 -> random == NULL)
                tmp2 -> random = NULL;
            else 
                tmp2 -> random = tmp1 -> random -> next;            
            tmp1 = tmp2 -> next;
            if (tmp1 != NULL)
                tmp2 = tmp1 -> next;
        }
        tmp1 = head;
        Node* newHead = tmp2 = head -> next;
        while (tmp2 != NULL) {
            tmp1 -> next = tmp2 -> next;
            if (tmp2 -> next != NULL)
                tmp2 -> next = tmp1 -> next;
            else
                tmp2 -> next = NULL;
            tmp1 = tmp1 -> next;
            tmp2 = tmp2 -> next;
        }
        while (tmp1 != NULL) {
            cout<<"t1: " << tmp1 -> val<<"  ";
            tmp1 = tmp1 -> next;
        }
    return newHead;
    }
};
