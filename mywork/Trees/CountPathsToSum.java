/*
   Return number of paths in a Binary tree which add up to a given SUM
*/

public int countPathWithSum(Node root, int sum) {
    if(root == null) return 0;

    int totalRootCount = countPathWithSum(root, sum, 0);

    int totalLeftCount = countPathWithSum(root.left, sum);
    int totalRightCount = countPathWithSum(root.right, sum);

    return totalCount + totalLeftCount + totalRightCount;
}

private int countPathWithSum(Node root, int sum, int currSum) {
    if(root == null) return 0;

    int totalCount = 0;
    currSum += root.data;
    if(currSum == sum){
        totalCount++;
    } else if(currSum > sum) {
        return totalCount;
    }

    totalCount += countPathWithSum(root.left, sum, currSum);
    totalCount += countPathWithSum(root.right, sum, currSum);

    return totalCount;
}
