/*
    Print all the paths from root to leaf

    Hint: Preorder traversal
*/

/*
    Iterative solution
        Space: O(logn + log(n*k) )   => k number of paths possible
        Time: O(n)
*/
public ArrayList<String> pathsFromRootToLeaf(Node root) {

    ArrayList<String> results = new ArrayList<String>();

    if(root == null) return results;

    LinkedList<Node> stack = new LinkedList<Node>();
    LinkedList<String> pathStack = new LinkedList<String>();
    Node node = null;
    String pathStr = null;

    stack.push(root);
    pathStack.push(root.data + "->");

    while(!stack.isEmpty()) {
        node = stack.pop();
        pathStr = pathStack.pop();

        if(node.left == null && node.right == null) {
            results.add(pathStr);
        }

        if(node.left != null) {
            stack.push(node.left);
            pathStack.push(pathStr + node.left.data + " ");
        }
        if(node.left != null) {
            stack.push(node.right);
            pathStack.push(pathStr + node.right.data + " ");
        }
    }

    return results;
}

/*
    Recursive solution
*/
public ArrayList<String> pathsFromRootToLeafRecur(Node root, String pathStr,
                                    ArrayList<String> results) {
    if(results == null) {
        results = new ArrayList<String>();
    }
    if(pathStr == null) {
        pathStr = new String("");
    }

    if(root == null) return results;
    pathStr = pathStr + root.data + " ";

    if(root.left == null && root.right == null) {
        results.add(pathStr);
    }

    if(root.left != null) {
        pathsFromRootToLeafRecur(root.left, pathStr, results);
    }
    if(root.right != null) {
        pathsFromRootToLeafRecur(root.right, pathStr, results);
    }

    return results;
}