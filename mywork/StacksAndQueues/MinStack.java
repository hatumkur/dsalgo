/*
    Implement 'min' operation on stack with time complexity of O(1)
*/

class MinStack{
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;

    public MinStack(){
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public void push(Integer val) {
        stack.push(val);
        boolean pushMin = false;
        if(!minStack.isEmpty()){
            if(minStack.peek() > val) minStack.push(val);
        } else {
            minStack.push(val);
        }
    }

    public Integer pop() {
        Integer val = null;
        if(!stack.IsEmpty()) {
            val = stack.pop(val);
            if(minStack.peek() == val) {
                minStack.pop();
            }
        }
        return val;
    }

    public Integer peek() {
        return stack.isEmpty() ? null : stack.peek();
    }

    public Integer min() {
        return stack.isEmpty() ? null : minStack.peek();
    }
}
