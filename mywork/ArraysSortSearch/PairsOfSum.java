/*
    Print all pairs of numbers in an array which equal to a given SUM
    Solution1: Brute force solution Time: O(n^2) Space: O(n)
    Solution2: Traverse array only once, assuming array is sorted
               Time: O(n)
               Space: O(n)
*/

public class Pair{
    int number1;
    int number2;
    public Pair(int n1, int n2) {
        number1 = n1;
        number2 = n2;
    }
}

public ArrayList<Pair> pairOfSums(int[] array, int sum) {
    ArrayList<Pair> result = new ArrayList<Pair>();
    //Arrays.sort(array);
    int first = 0;
    int last = array.length - 1;
    while (first < last) {
        int s = array[first] + array[last];
        if (s == sum) {
            result.add(new Pair(array[first], array[last]));
            ++first;
            --last;
        } else {
            if (s < sum) {
                ++first;
            } else {
                --last;
            }
        }
    }
    return result;
}
