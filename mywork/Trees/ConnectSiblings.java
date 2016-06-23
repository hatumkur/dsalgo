/*
    Connect Siblings nodes of binary tree

    Solution: Breadth First Traversal / Preorder traversal. Add a linkedlist
              to each level to hold siblings (nodes @ each level)

              Time: O(n)
              Space: O(n)

*/
public ArrayList< LinkedList<Node> > connectSiblings(Node root, int level,
                                ArrayList< LinkedList<Node> > results ){
    if(arrlist == null) {
        results = new ArrayList< LinkedList<Node> >();
    }

    if(root == null) return results;

    LinkedList<Node> levelList = null;
    if(level < results.size()) {
        levelList = results.get(level);
    } else {
        levelList = new LinkedList<Node>();
        arrlist.add(levelList);
    }

    levelList.add(root);

    if(root.left != null) connectSiblings(root.left, level+1, results);
    if(root.right != null) connectSiblings(root.right, level+1, results);

    return results;
}
