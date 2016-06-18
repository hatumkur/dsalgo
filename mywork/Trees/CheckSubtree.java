/*
Given two tree T1 & T2, check whether T2 is subtree of other

Solution1: Get inorder string representation of trees T1 & T2, call it ST1 & ST2.
           If ST1 contains string ST1 then we conclude T2 is a subtree of T1
           Time: O(n)
           Space: O(n)

Solution2: Better solution with space optimization without strings

*/

/*
----------------------------- SOLUTION 1 ---------------------------------------
*/
public boolean isSubtree(Node t1, Node t2) {
    StringBuilder sb1 = preorderString(t1, null);
    StringBuilder sb2 = preorderString(t2, null);

    return (sb2.indexOf(sb1.toString()) != -1);
}

public StringBuilder preorderString(Node node, StringBuilder result) {
    if(result == null) {
        result = new StringBuilder();
    }

    if(node == null) {
        result.add('X'); // To mark 'null'
        return result;
    }
    result.add(node.data);
    preorderString(node.left, result);
    preorderString(node.right, result);
}

/*
----------------------------- SOLUTION 2 ---------------------------------------
*/
private boolean matchSubtree(Node t1, Node t2) {
    return (t1.data == t2.data &&
            matchSubtree(t1.left, t2.left) &&
            matchSubtree(t1.right, t2.right));
}

private boolean checkSubtree(Node t1, Node t2) {
    if(t1 == null) {
        return false;
    } else if(t2.data == t1.data && matchSubtree(t1, t2)) {
        return true;
    }
    // check on the left or right side for t2
    return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);
}

public boolean isSubtree2(Node t1, Node t2) {
    if(t2 == null) return true;  // null is subtree of t1

    return checkSubtree(t1, t2);
}
