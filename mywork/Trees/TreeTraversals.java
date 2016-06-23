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
--------------------------- INORDER TRAVERSAL --------------------------------
 LVR
*/
public List<Integer> inorderTraversalIter(Node root) {
    List<Integer> result = new ArrayList<Integer>();
    if(root==null) return result;
    LinkedList<Node> stack = new LinkedList<Node>();
    stack.push(root);

    while(!stack.isEmpty()){
        Node top = stack.peek();
        if(top.left != null){
            stack.push(top.left);
            //top.left = null;
        }else{
            stack.pop();
            result.add(top.data);
            if(top.right != null){
                stack.push(top.right);
            }
        }
    }
    return result;
}

public void inorderTraversal(Node root, LinkedList<Integer> results) {
    if(results == null) {
        results = new LinkedList<Node>();
    }

    if(root == null) return;

    inorderTraversal(root.left, results);
    results.add(Node.data);
    inorderTraversal(root.right, results);
}
/*
--------------------------- PREORDER TRAVERSAL --------------------------------
VLR
*/
public void preorderTraversal(Node root, LinkedList<Node> results) {
    if(results == null) {
        results = new LinkedList<Node>();
    }

    if(root == null) return;

    results.add(Node);
    preorderTraversal(root.left, results);
    preorderTraversal(root.right, results);
}

public LinkedList<Integer> preorderTraversalIter(Node root) {
    LinkedList<Integer> results = new LinkedList<Integer>();

    if(root == null) return results;

    Node node = root;
    LinkedList<Node> stack = new LinkedList<Node>();
    stack.push(node);

    while(!stack.isEmpty()) {
        node = stack.pop();
        if(node != null) {
            results.add(node.data);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
    }

    return results;
}

/*
--------------------------- POSTORDER TRAVERSAL --------------------------------
 LRV
*/
public void postorderTraversal(Node root, LinkedList<Node> results) {
    if(results == null) {
        results = new LinkedList<Node>();
    }
    if(root == null) return;
    postorderTraversal(root.left, results);
    postorderTraversal(root.right, results);
    results.add(root);
}

public LinkedList<Integer> postorderIter(Node root) {
    LinkedList<Integer> results = LinkedList<Integer>();

    Node node = root;
    LinkedList<Node> stack1 = LinkedList<Node>();
    LinkedList<Node> stack2 = LinkedList<Node>();
    stack1.push(node);
    while(!stack1.isEmpty()) {
        node = stack1.pop();
        stack2.push(node);
        if(node.right != null) stack1.push(node.right);
        if(node.left != null) stack1.push(node.left);
    }

    while(!stack2.isEmpty()) {
        results.add(stack2.pop());
    }

    return results;
}
