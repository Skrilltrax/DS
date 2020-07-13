/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        
        ListNode* dummy = new ListNode(-1);
        ListNode* itr = dummy;
        ListNode* tmp = head;
                
        while(tmp != nullptr) {
            if(tmp->next && tmp->val == tmp->next->val) {
                int curr = tmp->val;
                while(tmp && tmp->val == curr) {
                    tmp = tmp->next;
                }
            } else {
                itr->next = tmp;
                itr = itr->next;
                tmp = tmp->next;
            }
        }
        
        itr->next = nullptr;
        return dummy->next;
    }
};
