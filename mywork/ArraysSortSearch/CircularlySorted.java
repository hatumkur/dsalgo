/*
    How many times is a sorted array rotated?

    Solution: No of rotations = index of MIN element
*/

// Leanear scan for minimum
// Time: O(n)
public int rotationCount(int[] arr) {
    int min = Integer.MAX_VALUE;
    int minIndex = -1;
    for(int i = 0; i < arr.length(); i++){
        if(min > arr[i]){
            min = arr[i];
            minIndex = i;
        }
    }
    return minIndex;
}

/*
Using Binary Search
Time: Best O(logn)  Worst O(n)
    Case1: Array is normally sorted
        arr[low] <= arr[high]
        return low
    case2: Pivot property i.e    arr[prev] > arr[pivot] < arr[next]
        next = (mid + 1) % N
        prev = (mid + N - 1) % N
        return mid
    case3: Left half is normally sorted
        low = mid + 1
    case4: Right half is normally sorted
        high = mid - 1
*/
public int rotationCountBetter(int[] arr) {
    int mid, next, prev;
    int low = 0;
    int high = arr.length();
    int N = arr.length();
    int count = 0;

    while(low < high){
        mid = (low + high) / 2;
        if(arr[low] <= arr[high]){
            count = low;
            break;
        }
        next = (mid + 1) % N;
        prev = (mid + N - 1) % N;
        if(arr[mid] <= arr[next] && arr[mid] <= arr[prev] ) { // pivot property
            count = mid;
            break;
        }
        if(arr[low] <= arr[mid]) { // left is normally sorted
            low = mid + 1;
        }

        if(arr[mid] <= arr[high]) { // Right is normally sorted
            high = mid - 1;
        }
    }
    return count;
}
