/*
  BubbleSort

  Time => O(n*n) Average
  Spae => O(1)

  Application: Kth smallest or Kth largest => K elements will be sorted O(n*k)
  For small values of k => Time => O(n)
*/

void bubbleSort(int[] a) {
    int n = a.length;

    for(int i = 0; i < n; i++) {
        for(int j = i; j < n-i-1; j++) {
            if(a[j] > a[j+1]) {
                swap(a, j, j+1);
            }
        }
    }
}
