/*

8 3 5 9 4 11 1 2 14

Chose a pivot
Rearrange so that elements on the left of the pivot < pivot
Rearrange so that elements on the right side of the pivot > pivot

Time => Average O(nlogn) Worst O(n*n)
Space => O(1) Doesn't uses auxilary array.

*/

public void quickSort(int[] a, int left, int right) {
  int pvindex = partition(a, left, right);
  if(left < pvindex - 1) {
    quickSort(a, left, pvindex - 1);
  }

  if(pvindex < right) {
    quickSort(a, pvindex, right);
  }
}

private int partition(int[] a, int left, int right) {
  int pivot = a[(left + right)/2];
  while(left <= right){
    while(arr[left] < pivot) left++;

    while(arr[right] > pivot) right--;

    // Swap pivot & right
    if(left <= right) {
      swap(a, left, right);
      left++;
      right--;
    }
  }
  return left;
}
