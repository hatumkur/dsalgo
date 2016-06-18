/*
    Find out merge point of two given linked lists
        Solution1: Brute force O(mn), m & n are the sizes of two lists, space O(1)
        Solution2: Use set, Time: O(nlogn) + O(mlogm)  Space: O(m)
        Solution3: Reference progressing, advance longer list by number of nodes
                   so that compare the references Time: O(n) Space: O(1)

*/

// Solution1
// Time: O(mn)
// Space: O(1)
Node findMergeNode(Node list1, Node list2){
    if(list1 == null || list2 == null ) return null;

    Node result = null;
    for(Node n1 = list1; n1 != null; n1 = n1.next) {
        for(Node n2 = list2; n2 != null; n2 = n2.next) {
            if(n1 == n2) {
                result = n1;
                break;
            }
        }
    }

    return result;
}

// Solution2: Using HashSet
// Time: O(nlogn) + O(mlogm) => O(nlogn)
// Space: O(n)
Node findMergeNode(Node list1, Node list2){
    if(list1 == null || list2 == null ) return null;

    Node node = list1;
    HashSet<Node> set = new HashSet<Node>();
    while(node != null) {
        set.add(node);
        node = node.next;
    }
    Node result = null;
    for(Node n2 = list2; n2 != null; n2 = n2.next) {
        if(set.isEmpty()) break;
        if(set.contains(n2)) {
            result = n2;
            break;
        }
    }

    return result;
}

/*
Solution3: Reference progressing, advance longer list by number of nodes
           so that compare the references Time: O(n) Space: O(1)
*/
Node findMergeNode(Node list1, Node list2){
    if(list1 == null || list2 == null ) return null;

    int len1 = list1.size();
    int len2 = list2.size();
    if(len1 == 0 || len2 == 0) return null;

    Node n1 = list1;
    if(len1 > len2) {
        int diff = len1 - len2;
        while(diff) {
            n1 = n1.next;
            diff--;
        }
    }

    Node n2 = list2;
    if(len2 > len1) {
        int diff = len2 - len1;
        while(diff) {
            n2 = n2.next;
            diff--;
        }
    }

    Node result = null;
    while(n1 != null){
        if(n1 == n2) {
            result = n1;
            break;
        }
        n1 = n1.next;
        n2 = n2.next;
    }

    return result;
}
