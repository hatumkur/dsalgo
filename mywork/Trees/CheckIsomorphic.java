/*
We simultaneously traverse both trees. Let the current internal nodes of two
trees being traversed be t1 and t2 respectively. There are following two
conditions for subtrees rooted with t1 and t2 to be isomorphic.
1) Data of t1 and t2 is same.
2) One of the following two is true for children of t1 and t2
    a) Left child of t1 is isomorphic to left child of t2 and right child of t1
    is isomorphic to right child of t2.
    b) Left child of t1 is isomorphic to right child of t2 and right child of t1
     is isomorphic to left child of t2.
*/

/* Given a binary tree, print its nodes in reverse level order */
public boolean isIsomorphic(Node t1, Node t2) {
    // Both roots are NULL, trees isomorphic by definition
    if (t1 == null && t2 == null) {
        return true;
    }

    // Exactly one of the t1 and t2 is NULL, trees not isomorphic
    if (t1 == null || t2 == null) {
        return false;
    }

    if (t1.data != t2.data) {
        return false;
    }

    // There are two possible cases for t1 and t2 to be isomorphic
    // Case 1: The subtrees rooted at these nodes have NOT been "Flipped".
    // Both of these subtrees have to be isomorphic, hence the &&
    // Case 2: The subtrees rooted at these nodes have been "Flipped"
    return (isIsomorphic(t1.left, t2.left) && isIsomorphic(t1.right, t2.right))
            || (isIsomorphic(t1.left, t2.right) && isIsomorphic(t1.right, t2.left));
}
