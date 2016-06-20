/*
   {1, 5, 2, 9, -1, 11, 6, 13, 15};
   Result: {-1,1,2}

   int[] array = {1, 5, 2, 9, -1, 11, 6, 13, 15};
   int[] smallest = smallestK(array, 3);
*/

public class MaxHeapComparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y) {
        return y - x;
    }
}

public int[] smallestK(int[] array, int k) {
    if (k <= 0 || k > array.length) {
        throw new IllegalArgumentException();
    }

    PriorityQueue<Integer> heap = getKMaxHeap(array, k);
    return heapToIntArray(heap);
}

/* Convert heap to int array. */
private int[] heapToIntArray(PriorityQueue<Integer> heap) {
    int[] array = new int[heap.size()];
    while (!heap.isEmpty()) {
        array[heap.size() - 1] = heap.poll();
    }
    return array;
}

/* Create max heap of smallest k elements. */
private PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new MaxHeapComparator());
    for (int a : array) {
        if (heap.size() < k) { // If space remaining
            heap.add(a);
        } else if (a < heap.peek()) { // If full and top is small
            heap.poll(); // remove highest
            heap.add(a); // insert new element
        }
    }
    return heap;
}
