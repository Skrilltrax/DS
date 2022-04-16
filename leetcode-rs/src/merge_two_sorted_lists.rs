// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode {
            next: None,
            val,
        }
    }
}

pub fn merge_two_lists(list1: Option<Box<ListNode>>, list2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    let dummy_head = Box::new(ListNode::new(i32::MIN));

}

pub fn merge(first: Option<Box<ListNode>>, second: Option<Box<ListNode>>, prev: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    if first.is_none() && second.is_none() {
        prev.unwrap().next = None
    }

    if first.is_none() {

    }

    if second.is_none() {

    }

    if first.is_some() && second.is_some() {

    }
}
