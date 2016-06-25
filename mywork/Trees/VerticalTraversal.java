/*
   Print the tree in vertical order
   Approach:

       Its a tricky solution.
       Do the inorder traversal.
       Take a vari­able called level, when ever you go left, do level-- AND
            when ever you go right do level++.
       With step above we have sep­a­rated out the lev­els vertically.
       Now you need to store the ele­ments of each level, so cre­ate a TreeMap and
            the (key,value) pair will be (level,elements at that level).
       At the end iter­ate through the TreeMap and print the results.

*/
public TreeMap<Integer, ArrayList<Integer>> verticalTraversal(Node root, int level,
                                            TreeMap<Integer, ArrayList<Integer>> treemap){

    if(treemap == null) {
        treemap = new TreeMap<Integer, ArrayList>();
    }

    if(root == null) return treemap;

    ArrayList<Integer> arr;
    if(!treemap.containsKey(level)) {
        arr = new ArrayList<Integer>();
        treemap.put(level,arr);
    } else {
        arr = treemap.get(level);
    }
    arr.add(root.data);

    if(root.left != null) verticalTraversal(root.left, --level, treemap);
    if(root.right != null) verticalTraversal(root.right, ++level, treemap);

    return treemap;
}

// usage :
// TreeMap<Integer, ArrayList<Integer>> treemap = verticalTraversal(root, 0, null);
public void printInVerticalOrder(Node root) {
    if(root == null) {
        System.out.println("Invalid data");
    }

    TreeMap<Integer, ArrayList<Integer>> treemap = verticalTraversal(root, 0, null);

    for(int key : treemap.keySet()) {
        ArrayList<Integer> array = treemap.get(key);
        for(int i = 0; i < array.length(); i++ ) {
            System.out.println(array.get(i) + "  ");
        }
        System.out.println();
    }
}
