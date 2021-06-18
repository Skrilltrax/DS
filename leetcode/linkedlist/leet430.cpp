/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/

class Solution {
public:
    
    Node* solveRec(Node* head) {
        if(head->next == nullptr && head->child == nullptr) {
            return head;
        }
        
        if(head->child != nullptr) {
            // Save next of head
            Node* tmp = head->next;
            // Get tail of child list
            Node* ch = solveRec(head->child);
            
            
            head->next = head->child;
            head->child = nullptr;
            head->next->prev = head;
            
            ch->next = tmp;
            if(ch->prev == nullptr) ch->prev = head;
            if(tmp != nullptr) tmp->prev = ch;
        }
        
        head = head->next;
        return solveRec(head);
    }
    
    Node* flatten(Node* head) {
        if(head == nullptr) return nullptr;
        Node* tmp = head;
        solveRec(tmp);
        return head;
    }
};
