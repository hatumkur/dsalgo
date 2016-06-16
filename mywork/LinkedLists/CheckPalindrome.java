/*
    Check whether given linked list is a palindrome or not
        Solution1: Move to mid, reverse 2nd half and compare with first half
        Solution2: Push first half into stack and pop, compare with second half

    Hint: Use runner technique to reach mid
*/

class Node {
    int value;
    Node next;
}
//Sulution1: Move to mid, reverse 2nd half and compare with first half
boolean isPalindrome(Node root) {
    if(root == null) return false;

    Node mid = root;
    Node runner = root;
    Node prev = null;

    while(runner != null && runner.next != null){
        //prev = mid; // Do it only if needed
        mid = mid.next;
        runner = runner.next.next;
    }

    //prev.next = null; // Do it only if needed
    Node secondHead = mid.next; // 1->2->1->null

    secondHead = reverse(secondHead);
    if(secondHead == null) return false;

    boolean isPalindrome = true;
    while(secondHead != null) {
        if(root.value != secondHead.value) {
            isPalindrome = false;
            break;
        } else {
            root = root.next;
            secondHead = secondHead.next;
        }
    }

    return isPalindrome;
}

Node reverse(Node root){
    if(root == null) return false;

    Node curr = root;
    Node prev = null;
    Node next = null;
    //Node temp = null;

    while(curr != null) {
        next = curr.next;
        curr.next = prev; // Reverse
        prev = curr;
        curr = next;
    }
}

// Solution2:
boolean isPalindrome2(Node root){
    if(root == null) return false;

    LinkedList<Node> stack = new LinkedList<Node>();

    Node mid = root;
    Node runner = root;
    Node prev = null;
    stack.push(mid);

    while(runner != null && runner.next != null){
        //prev = mid;
        mid = mid.next;
        stack.push(mid);
        runner = runner.next.next;
    }
    Node secondHead = mid.next;
    boolean isPalindrome = true;

    while(!stack.isEmpty() && secondHead != null) {
        Node node = stack.pop();
        if(node.value != secondHead.value) {
            isPalindrome = false;
            break;
        }else {
            secondHead = SecondHead.next;
        }
    }
}
