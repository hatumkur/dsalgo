/*
    Connect Siblings nodes of binary tree

    Solution: Breadth First Traversal / Preorder traversal. Add a linkedlist
              to each level to hold siblings (nodes @ each level)

              Time: O(n)
              Space: O(n)

*/
public ArrayList< LinkedList<Node> > connectSiblings(Node root, int level,
                                ArrayList< LinkedList<Node> > arrlist ){
    if(arrlist == null) {
        arrlist = new ArrayList< LinkedList<Node> >();
    }

    if(root == null) return arrlist;

    LinkedList<Node> levelList = arrlist.get(level);
    if(levelList == null) {
        levelList = new LinkedList<Node>();
    }
    levelList.add(root);

    if(root.left != null) connectSiblings(root.left, level+1, arrlist);
    if(root.right != null) connectSiblings(root.right, level+1, arrlist);
}
