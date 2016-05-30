/*

Replace every element with the greatest element on right side

Given an array of integers, replace every element with the next greatest element
 (greatest element on the right side) in the array. Since there is no element
 next to the last element, replace it with -1. For example, if the array is
 {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}.

 A naive method is to run two loops. The outer loop will one by one pick array
 elements from left to right. The inner loop will find the greatest element
 present after the picked element. Finally the outer loop will replace the picked
 element with the greatest element found by inner loop. The time complexity of
 this method will be O(n*n).
 A tricky method is to replace all elements using one traversal of the array.
 The idea is to start from the rightmost element, move to the left side one by
 one, and keep track of the maximum element. Replace every element with the
 maximum element.
*/

/* Function to replace every element with the
   next greatest element */
static void nextGreatest(int arr[])
{
    int size = arr.length;

    // Initialize the next greatest element
    int max_from_right =  arr[size-1];

    // The next greatest element for the rightmost
    // element is always -1
    arr[size-1] = -1;

    // Replace all other elements with the next greatest
    for (int i = size-2; i >= 0; i--)
    {
        // Store the current element (needed later for
        // updating the next greatest element)
        int temp = arr[i];

        // Replace current element with the next greatest
        arr[i] = max_from_right;

        // Update the greatest element, if needed
        if(max_from_right < temp)
        max_from_right = temp;
    }
}
