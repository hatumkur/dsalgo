/*
The diameter of a tree T is the largest of the following quantities:

* the diameter of T’s left subtree
* the diameter of T’s right subtree
* the longest path between leaves that goes through the root of T (this can be
*   computed from the heights of the subtrees of T)

    Time complexity: O(n*n)
    Space complexity: O(n)
*/

public int getDiameter(Node root) {
    if(root == null) return 0;

    int lh = getHeight(root.left);
    int rh = getHeight(root.right);

    int ld = getDiameter(root.left);
    int rd = getDiameter(root.right);

    /*
    Return max of following three
              1) Diameter of left subtree
             2) Diameter of right subtree
             3) Height of left subtree + height of right subtree + 1
    */
    return Math.max(lh+rh+1, Math.max(ld, rd));
}

public int getHeight(Node root) {
    if(root == null) return 0;

    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}
