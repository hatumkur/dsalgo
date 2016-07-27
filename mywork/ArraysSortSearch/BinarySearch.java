/*
   Searches an elements assuming array is sorted

   10 20 30 40 50 60

   Time => O(logn)
   Space => O(1)
*/

int binarySearch(int[] a, int elem) {
  int low = 0;
  int high = a.length - 1;

  int mid = (low + high) / 2;

  while(low <= high) {
    if(elem > a[mid]) {
      low = mid+1;
    } else if(elem < a[mid]){
      high = mid - 1;
    } else {
      return mid;
    }
    mid = (low + high)/2;
  }

  return -1; // not found
}

// Recursive
int binarySearchRecur(int[] a, int elem, int low, int high) {
  int mid = (low + high)/2;

  if(elem < a[mid]) {
    return binarySearchRecur(a, elem, low, mid -1);
  } else if(elem > a[mid]) {
    return binarySearchRecur(a, elem, mid+1, high);
  } else {
    return mid;
  }
  
  return -1;
}

// Binary Search index corresponding to FIRST occurance of the number
int binarySearchFirst(int[] a, int elem) {
  int low = 0;
  int high = a.length - 1;
  int result = -1;

  int mid;

  while(low <= high) {
    mid = (low + high)/2;

    if(elem > a[mid]) {
      low = mid + 1;
    } else if(elem < a[mid]){
      high = mid - 1;
    } else {
      //return mid; // modify to get first occurance
      result = mid;
      high = mid - 1;
    }
  }
  return result; // not found
}

// Binary Search index corresponding to LAST occurance of the number
int binarySearchLast(int[] a, int elem) {
  int low = 0;
  int high = a.length - 1;
  int result = -1;

  int mid;

  while(low <= high) {
    mid = (low + high)/2;

    if(elem > a[mid]) {
      low = mid + 1;
    } else if(elem < a[mid]){
      high = mid - 1;
    } else {
      //return mid; // modify to get LAST occurance
      result = mid;
      low = mid + 1;
    }
  }
  return result; // not found
}
