/*
LowestCommonAncesor(LCA)/FirstCommonAnscestor

Time => O(logn)
Space => O(1)
*/

class Node {
  int data;
  Node left, right;

  public Node(int data) {
    this.data = data;
    left = right = null;
  }
}

// Method: isNodePartOfTree
// Returns: true if 'p' node exists in the tree else false
public boolean isNodePartOfTree(Node root, Node p) {
  if(root == null) return false;

  if(root == p) return true;

  return isNodePartOfTree(root.left, p) || isNodePartOfTree(root.right,p);
}

// Root node is LCA/FCA if 'p' & 'q' is not on the same side of the tree(left/right)
//
public Node findLCA(Node root, Node p, Node q) {
    if(root == null || p == null || q == null) return null;

    boolean pfoundLeft = isNodePartOfTree(root.left,p); // p found left ?
    boolean qfoundLeft = isNodePartOfTree(root.left,q); // q found left ?

    // Return 'root' as LCA if 'p' & 'q' are not on the same side
    if(pfoundLeft != qfoundLeft) return root;

    Node next = (pfoundLeft) ? root.left : root.right;

    return findLca(next,p,q);
}

public Node lowestCommonAncesor(Node root, Node p, Node q) {
    // If p or q not present part of the tree
    // Validate input
    if(!isNodePartOfTree(root, p) || !isNodePartOfTree(root, q)){
        return null;
    } else if(isNodePartOfTree(p,q)) {
        return p;
    } else if(isNodePartOfTree(q, p)) {
        return q;
    }

    return findLCA(root, p, q);
}
