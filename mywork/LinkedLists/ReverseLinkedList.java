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
    Node next = null;
    Node prev = null;

    while(curr != null) {
        next = curr.next; // store next
        curr.next = prev;
        prev = curr;   // store next
        curr = next;
    }

    head = prev;
    return head;
}

/*
    Solution2: Using Stack
        Time: O(n)
        Space: O(n)
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
    curr.next = null;

    return head;
}

/*
Reverse a list using recursion
Returns new "head"
*/
//Node head;
public void reverseListRecur(Node node, Node newRoot){
    if(node.next == null) { // Exit condition
        newRoot = node;
        return;
    }

    reverseListRecur(node.next, newRoot);
    Node prev = node.next;
    prev.next = node;
    node = prev;
}

/*
    Print elements using recursion in FORWARD direction
*/
public printForward(Node root) {
    if(root == null) {
        System.out.println();
        return;
    }
    System.out.println(root.data + " ");
    printForward(root.next);
}

/*
    Print elements using recursion in REVERSE direction
*/
public printReverse(Node root) {
    if(root == null) {
        System.out.println();
        return;
    }
    printReverse(root.next);
    System.out.println(root.data + " ");
}
