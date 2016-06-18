/*
    Find number of times a given number is repeated in the array
    Ex: 1 2 3 4 5 6 6 6 6 7 7 8 8 8 9
    6 => 4
    10 => 0

*/

// Linear search
// O(n) in worst case
public int findCount(int[] arr, int number){
    int count = 0;

    for(int i = 0; i < arr.length; i++){
        if(arr[i] == number){
            count += 1;
        } else if(arr[i] > number) {
            break;
        }
    }
    return count;
}

// Binary search
// O(n) worst case



// Modified binary search
// FIRST occurance index
// LAST occurance index
// Time: O(logn) + O(logn) => O(logn)
public int findCountBetter(int[] arr, int number){
    int firstIndex = binarySearchFirst(arr, number);
    int lastIndex = binarySearchLast(arr, number);

    int count = 0;
    if(firstIndex >= 0 && lastIndex >= 0) {
        count = lastIndex - firstIndex + 1;
    }
}
