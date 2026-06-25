class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> dq;

    public MinStack() {
        st = new Stack<>();
        dq = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(dq.isEmpty() || value <= dq.peek()){
            dq.push(value);
        }
    }
    
    public void pop() {
        int val = st.pop();
        if(dq.peek() == val){
            dq.pop();
        }
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return dq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */