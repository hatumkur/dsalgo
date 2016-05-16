/*
int[] A = {1, 3, 5, 8, 10};  // Sorted
int[] B = {2, 4, 7, 9, 12, 15}; // Sorted

Merge A & B in place using no extra space (O(1)) so that
    A => { 1, 2, 3, 4, 5}
    B => { 7, 8, 9, 10, 12, 15}
*/

void mergeSortedArrays(int[] A, int[] B) {
  int endA = A.length - 1;
  int endB = B.length - 1;

  for(int i = endA; i >= 0; i--) { // Start from end of A
    for(int j = endB; j >= 0; j--) { // Start from end of B
      if(A[i] < B[j]) { // B[j] is already at right place
        endB--;
        continue;
      } else if(A[i] > B[j]){ // swap the elements of A & B
        swap(A,i,B,j);
      }
    }
  }
  // B is already sorted & A need to be sorted due to swaps
  Arrays.sort(A);
}
