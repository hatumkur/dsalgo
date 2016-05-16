package com.harsha.practice.tree;

// Different solution
// If PRE & IN ORDER traversal strings of T2 are substrings of PRE & IN ORDER traversal of T1

public class SearchSubtree {

	public static boolean isSubtree(Node t1, Node t2) {
		if(t2 == null) return true; // null subtree is found
		
		if(t1 == null) return false;
		
		if(t1.data == t2.data) {
			return matchSubtree(t1,t2);
		}
		
		return (isSubtree(t1.left, t2)  
				|| isSubtree(t2.right, t2));
	}
	
	private static boolean matchSubtree(Node t1, Node t2) {
		if(t1 == null && t2 == null) return true;
		
		if(t1 == null || t2 == null) return false;
		
		return (t1.data == t2.data 
				&& matchSubtree(t1.left, t2.left)  
				&& matchSubtree(t1.right,t2.right) );
	}
	
	// Algorithm 2 PRE & IN ORDER strings
	public static boolean isSubtree2(Node t1, Node t2) {
        StringBuilder str1 = new StringBuilder();
        Node.getInorderTraverseString(t1, str1);
        System.out.println("T1-INORDER: " + str1.toString());
        
        StringBuilder str2 = new StringBuilder();
        Node.getInorderTraverseString(t2, str2);
        System.out.println("T2-INORDER: "+ str2.toString());        
        
        if(str1.toString().contains(str2.toString())) {
        	str1.setLength(0);
        	str2.setLength(0);
            Node.getPreorderTraverseString(t1, str1);
            Node.getPreorderTraverseString(t2, str2);   

            System.out.println("T1-PREORDER: "+ str1.toString());
            System.out.println("T2-PREORDER: "+ str2.toString()); 
            
            if(str1.toString().contains(str2.toString())) {
            	return true;
            }
        }
        
        return false;
	}
	
	
	public static void main(String[] args) {
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
          
        Node tree1 = new Node(26);
        tree1.right = new Node(3);
        tree1.right.right = new Node(3);
        tree1.left = new Node(10);
        tree1.left.left = new Node(4);
        tree1.left.left.right = new Node(30);
        tree1.left.right = new Node(6);
        
        Node.inOrderTraverse(tree1);
        System.out.println();
        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
          
        Node tree2 = new Node(10);
        tree2.right = new Node(6);
        tree2.left = new Node(4);
        tree2.left.right = new Node(30); 
        
        Node.inOrderTraverse(tree2);
        System.out.println();
        
		//System.out.println("METHOD1 ---> Is T2 part of T1 ? : " + isSubtree(tree1, tree2));
		System.out.println("METHOD2 ---> Is T2 part of T1 ? : " + isSubtree2(tree1, tree2));		
	}

}
