/*
  BubbleSort

  Time => O(n*n) Average
  Spae => O(1)

  Application: Kth smallest or Kth largest => K elements will be sorted O(n*k)
  For small values of k => Time => O(n)
*/

void bubbleSort(int[] a) {
  int n = a.length;
  int m = 0;

    while(m < n) {
        for(int i = m; i < n-m-1; i++) {
            if(a[i] > a[i+1]) {
                swap(a, i, i+1);
            }
        }
        m++;
    }
}
