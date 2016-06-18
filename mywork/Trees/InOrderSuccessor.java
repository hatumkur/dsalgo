/*
Search/Find Inorder successor of a given Node
    Solution1: If root node is given do a inorder traversal & stop when successor
               found
               Time: O(n) => worst case
               Space: O(n)
    Solutio2: If root node is not given
            Assumption: Solution exists only if node has 'parent' reference
               Time: O(n) => worst case
               Space: O(n)

*/

class Node {
    int data;
    Node left, right, parent;
    public Node(int data) {
        this.data = data;
        left = right = parent = null;
    }
    public Node(int data, Node parent) {
        Node(data);
        this.parent = parent;
    }

    public createLeftChild(int data) {
        Node node = new Node(data, this);
        this.left = node;
    }

    public createRightChild(int data) {
        Node node = new Node(data, this);
        this.right = node;
    }
}
/*
------------------------------ Solution 1 -------------------------------------

           6
        3       9
    1     2   7    10
*/
public Node inorderSuccessor(Node root, Node p) {
    if(root == null) return result;
    LinkedList<Node> stack = new LinkedList<Node>();
    stack.push(root);
    boolean foundNode = false;

    while(!stack.isEmpty()){
        Node top = stack.peek();

        if(top.left != null){
            stack.push(top.left);
            //top.left = null;
        } else {
            stack.pop();
            if(top == p ) { // if node under search is found
                foundNode = true;
            } else if(foundNode) {
                return top;
            }

            if(top.right != null){
                stack.push(top.right);
            }
        }
    }

    return null;
}
/*
------------------------------ Solution 2 -------------------------------------
*/
// Root node is not given
// Each node contains a reference to its parent
public Node inorderSuccessor2(Node p) {
    // If invalid input
    if(p == null) return null;

    if(p.parent == null ||  // p is the root node or
       p.right != null) { // node's right child is not empty then return left most child
           return leftMostChild(p.right);
       } else {
           Node parent = p.parent;
           // Move up till root
           while(parent != null) {
               if(parent.left == p) break;
               parent = parent.parent;
           }
           return parent;
       }
    return null;
}
/*
------------------------------ Solution 3 -------------------------------------
*/
// Root node not given
// Assumption: Each node has reference to parent node
// Step(1): Find root node
// Step(2): call 'inorderSuccessor(root,p)'
public Node findRoot(Node p) {
    if(p == null) return null;

    Node parent = p.parent;
    while(parent != null && parent.parent != null) {
        parent = parent.parent;
    }
    return p;
}

Node successor = inorderSuccessor(findRoot(p),p);
