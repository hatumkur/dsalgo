/*
    Given BST

Solution1: The idea was to first in-place convert BST to Doubly Linked List (DLL),
then find pair in sorted DLL in O(n) time. This solution takes O(n) time and O(Logn)
extra space, but it modifies the given BST.

Solution2: create an auxiliary array and store Inorder traversal of BST in the
array. The array will be sorted as Inorder traversal of BST always produces
sorted data. Once we have the Inorder traversal, we can pair in O(n) time
. This solution works in O(n) time, but requires O(n)
auxiliary space.

Hint: Sorted array: Pair to a given sum can be found by matching
      A[i] + A[end - i] == SUM ?
*/
