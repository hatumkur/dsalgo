/*
    In a given of positive and negative number find the maximum possible
    sub array sum
    Ex: 1,-3,2,-5,7,6,-1,-4,11,-23
        Result: 19

    Solution1: Brute force  Time: O(n^3)  Space: O(1)
    Solution2: Store intermediate results + Divide & conquer Time: O(nlogn) Space: O(n)
    Solution3: "Kadane's" algorithm
            Rules: (1) Use empty sub array
                   (2) Sum of the sub array is calculated
                   (3) When Sum => negative reset the sub array
                   (4) Every time store the max sum into RESULT
*/
int maxSumSubArray(int[] arr) {
    int result = 0;
    int sum = 0;
    for(int i = 0; i < arr.legth; i++){
        if(sum + arr[i] > 0) {
            sum += arr[i];
        } else {
            sum = 0;
        }
        result = (result > sum) ? result : sum;
    }
    return result;
}

/*
    In case you want to return the sub list corresponding to max sum
*/
int maxSumSubArray(int[] arr, ArrayList<Integer> resultSublist){
    Hashmap<Integer, ArrayList<Integer>>subListMap = new Hashmap<Integer, ArrayList<Integer>>()

    int result = 0;
    int sum = 0;
    ArrayList<Integer> tempList = new ArrayList<Integer>();
    for(int i = 0; i < arr.legth; i++){
        if(sum + arr[i] > 0) {
            sum += arr[i];
            tempList.add(arr[i]);
        } else {
            ArrayList<Integer> subList = new ArrayList<Integer>(tempList);
            if(sum > result) {
                if(!subListMap.containsKey(sum)){
                    subListMap.put(sum,subList);
                }
            }
            tempList.clear();
            sum = 0;
        }

        result = (result > sum) ? result : sum;
    }

    // Return the sublist corresponding to max sum
    resultSublist = subListMap.get(result);

    // return max sum
    return result;
}
