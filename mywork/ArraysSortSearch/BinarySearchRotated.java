/*
   Take a case where sorted array is rotated few times
   Sorted Array: 10 20 30 40 50 60
   Sorted Array with Rotation: 50 60 10 20 30 40   or
   Sorted Array with Rotation: 30 40 50 60 10 20
   Also note array can have repeats

   Hint: use recursive otherwise solution will be complex

   Time => O(logn)
   Space => O(1)
*/

int binarySearch(int[] a, int low, int high, int elem) {

  int mid = (low + high) / 2;

  if(a[mid] == elem) return mid;

  if(low > high) return -1;

  // Either left side or right is normally ordered. Find which side is normally
  // ordered
  // assume that left side is normally ordered
  if(a[left] < a[mid]) {
    // Left side is normally ordered so find on the left side
    if(elem >= a[low] && elem <= a[mid]) {
      return binarySearch(a, low, mid-1, elem);
    } else {
      return binarySearch(a, mid+1, high, elem);
    }
  } else if(a[mid] < a[high] ) { //  Right side normally ordered
    // Right side is normally ordered so find on the right side
    if(elem >= a[mid] && elem <= a[high]) {
      return binarySearch(a, mid+1, high, elem);
    } else {
      return binarySearch(a, low, mid-1, elem);
    }
  } else if(a[low] == a[mid]) { // Left half are repeats
    if(a[low] != a[high]) { // Right side is different
      return binarySearch(a, mid+1, high, elem);
    } else { // search in both half
      int index = binarySearch(a, low, mid-1, elem);

      if(index == -1) {
        binarySearch(a, mid+1, high, elem);
      } else {
        return index;
      }
    }
  }

  return -1;
}
