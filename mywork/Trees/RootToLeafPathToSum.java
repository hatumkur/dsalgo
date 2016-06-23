/*
    RootToLeafPathToSum

    Definition: The sum of the data from 'root' to 'leaf' equals to SUM

    For example, in the above tree root to leaf paths exist with following sums.

    21 –> 10 – 8 – 3
    23 –> 10 – 8 – 5
    14 –> 10 – 2 – 2

    So the returned value should be true only for numbers 21, 23 and 14. For any
     other number, returned value should be false.

    Algorithm:
    Recursively check if left or right child has path sum equal to ( number –
        value at current node)

    Hint: Preorder traversal

*/

public boolean hasRootToLeafPathToSum(Node root, int sum) {
    if(root == null) {
        return (sum == 0);
    }

    int subsum = sum - root.data;
    if(subsum == 0 && root.left == null && root.right == null) {
        return true;
    }

    return (hasRootToLeafPathToSum(root.left, subsum) ||
            hasRootToLeafPathToSum(root.right, subsum));

}
