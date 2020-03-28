import java.util.Stack;

class MinStack {
    
    Stack<Integer> eleStack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    
    public MinStack() {
        eleStack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int x) {
        if(minStack.size() == 0 || x <= minStack.peek()) {
            minStack.push(x);
        }
        eleStack.push(x);
    }
    
    public void pop() {
        if(minStack.size() != 0 && this.top() == minStack.peek()) {
            System.out.println("poped");
            minStack.pop();
        }
        
        if (eleStack.size() != 0)
            eleStack.pop();
    }
    
    public int top() {
        return eleStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */