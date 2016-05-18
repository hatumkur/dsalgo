/*
    Reverse linked List
    (1) Runner technique
    (2) Using stack
*/
class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}

/*
    Solution1: Runner technique
        Time: O(n)
        Spae: O(1)
*/
public Node reverseList(Node head) {
    if(head == null) return null;

    Node curr = head;
    Node next = head.next;
    Node prev = null;

    while(curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    head = prev;
    return head;
}

/*
    Solution2: Using Stack
        Time: O(n)
        Spae: O(n)
*/
public Node reverseList(Node head) {
    if(head == null) return null;

    LinkedList<Node> stack = LinkedList<Node> ();
    Node curr = head;

    while(curr != null) {
        stack.push(curr);
        curr = curr.next;
    }

    while(!stack.isEmpty()) {
        if(curr != null) {
            curr.next = stack.pop();
        } else {
            curr = stack.pop();
            head = curr;
        }
    }

    return head;
}
