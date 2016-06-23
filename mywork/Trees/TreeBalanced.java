/*
   Check whether a binary tree is balanced or not

   Time Complexity:
      Bruteforce recursive solution => O(n*n)

*/
class Node {
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}
/////////////////////////////SOLUTIION 1 - O(n*n)///////////////////////////////
public boolean isTreeBalanced(Node root) {
    if(root == null) return true;

    int lh = getHeight(root.left);
    int rh = getHeight(root.right);
    // Tree is balanced if height of left & right not more than 1
    if(Math.abs(lh - rh) > 1) {
        return false;
    }

    // Tree is balanced only if it's lef & right sub trees are balanced
    return isTreeBalanced(root.left) && isTreeBalanced(root.right);
}

public int getHeight(Node root) {
    if(root == null) return 0;

    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}
////////////////////////////////////////////////////////////////////////////////
////////////////////////// SOLUTION 2 - O(n)////////////////////////////////////
public boolean isTreeBalanced2(Node root) {
    return getHeight2(root) != Integer.MIN_VALUE;
}

public int getHeight2(Node root){
    if(root == null) return 0;

    int lh = getHeight2(root.left);
    if(lh == Integer.MIN_VALUE) return lh;

    int rh = getHeight2(root.right);
    if(rh == Integer.MIN_VALUE) return rh;

    if(Math.abs(lh - rh) <= 1) {
        return Math.max(lh, rh) + 1;
    }
    return Integer.MIN_VALUE;
}
////////////////////////////////////////////////////////////////////////////////
