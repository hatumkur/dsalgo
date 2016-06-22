/*
    AVL tree
    Rule:
        (1) Tree need to be BST (i.e left.data =< root.data > right.data )
        (2) It is BALANCED i.e hieght(node.left) - hieght(node.right) <= 1
            This should be recursively true

    AVL tree insertion
        left    left
        left    right
        right   right
        right   left

*/

class Node {
    int data;
    int height;
    int size;

    Node left;
    Node right;
}
private int setHeight(Node root){
    if(root == null){
        return 0;
    }
    return 1 + Math.max((root.left != null ? root.left.height : 0),
                        (root.right != null ? root.right.height : 0));
}

private int height(Node root){
    if(root == null){
        return 0;
    }else {
        return root.height;
    }
}

private int setSize(Node root){
    if(root == null){
        return 0;
    }
    return 1 + Math.max((root.left != null ? root.left.size : 0),
                        (root.right != null ? root.right.size : 0));
}

private Node leftRotate(Node root){
    Node newRoot = root.right;
    root.right = root.right.left;
    newRoot.left = root;
    root.height = setHeight(root);
    root.size = setSize(root);
    newRoot.height = setHeight(newRoot);
    newRoot.size = setSize(newRoot);
    return newRoot;
}

private Node rightRotate(Node root){
    Node newRoot = root.left;
    root.left = root.left.right;
    newRoot.right = root;
    root.height = setHeight(root);
    root.size = setSize(root);
    newRoot.height = setHeight(newRoot);
    newRoot.size = setSize(newRoot);
    return newRoot;
}

private int balance(Node rootLeft, Node rootRight){
    return height(rootLeft) - height(rootRight);
}

public Node insert(Node root, int data){
        if(root == null){
            return Node.newNode(data);
        }
        if(root.data <= data){
            root.right = insert(root.right,data);
        }
        else{
            root.left = insert(root.left,data);
        }

        int balance = balance(root.left, root.right);
        if(balance > 1){ // Left tree not balanced
            if(height(root.left.left) >= height(root.left.right)){ // left L L
                root = rightRotate(root);
            }else{ // right  L R
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }else if(balance < -1){ // Right tree not balanced
            if(height(root.right.right) >= height(root.right.left)){ // Right R R
                root = leftRotate(root);
            }else{ // left R L
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }
        else{
            root.height = setHeight(root);
            root.size = setSize(root);
        }
        return root;
}
