/*
    ZigZag or Spiral Traversal of binary tree
    Example:            10
                   20       30
                40    50  60  70
        Resultant traversal: 10 20 30 70 60 50 40

    Solution: Modified Breadth First Traversal = BFT / Modified Preorder Traversal
              Time: O(n)
              Spae: O(n)
*/

public LinkedList<Node> spiralTraversal(Node root) {
    LinkedList<Node> result = new LinkedList<Node>();

    Node node = root;
    LinkedList<Node> s1 = new LinkedList<Node>();
    LinkedList<Node> s2 = new LinkedList<Node>();
    s1.push(node);
    boolean spiralToggle = false;

    while(!s1.isEmpty() || !s2.isEmpty()) {

        while(!s1.isEmpty()) {
            node = s1.pop();
            if(node != null) {
                result.add(node);
                if(node.right != null) s2.push(node.right); // reverse order
                if(node.left != null) s2.push(node.left); // reverse order
            }
        }

        while(!s2.isEmpty()) {
            node = s2.pop();
            if(node != null) {
                result.add(node);
                if(node.left != null) s1.push(node.left);
                if(node.right != null) s1.push(node.right);
            }
        }

    }
}
