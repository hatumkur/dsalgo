// Merge Sort

/*       8 3 5 9 4 11 1 2 14
    8 3 5 9 4     11 1 2 14
    8 3 5    9 4
    8 3    5
    8   3

    use a auxilary space equal to the length of the array
    Time = O(nlogn)
    Space = O(n)
*/

public void mergeSort(int[] a) {
    int[] temp = new int[a.length];
    mergeSort(a, temp, 0, a.length-1);
}

private void mergeSort(int[] a, int[] temp, int low, int high) {
    if(low < high) {
        int mid = (low + high) / 2;
        mergeSort(a, temp, low, mid);
        mergeSort(a, temp, mid+1, high);
        merge(a, temp, low, mid, high);
    }
}

private void merge(int[] a, int[] temp, int low, int mid, int high) {
    // copy input to temporary array
    for(int i = low; i <= high; i++) {
        temp[i] = a[i];
    }

    int tlow = low;
    int thigh = mid + 1;
    int curr = low;

    while(tlow <= mid && thigh <= high) {
      if(temp[tlow] <= temp[thigh]) { // compare low & high values
        a[curr] = temp[tlow];  // copy the low value to original array
        tlow++;  // move the low cursor
      } else {
        a[curr] = temp[thigh]; // copy high value to original array
        thigh++; // move the high cursor
      }
      curr++; // Move the current cursor
    }

    // copy remaining lowside of the array & high side will be already in place
    int remaining = mid - tlow;
    for(int i = 0; i < remaining; i++) {
      a[curr + i] = temp[tlow + 1];
    }
}
