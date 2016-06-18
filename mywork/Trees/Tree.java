/* One node of a binary tree. The data element stored is a single
 * character.
 */
public class Node {
	public int data;
	public Node left;
	public Node right;
	//public Node parent;

	public Node(int data) {
		this.data = d;
	}

	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				left = new Node(d);
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				right = new Node(d);
			} else {
				right.insertInOrder(d);
			}
		}
	}

	public boolean isBST() {
		if (left != null) {
			if (data < left.data || !left.isBST()) {
				return false;
			}
		}

		if (right != null) {
			if (data >= right.data || !right.isBST()) {
				return false;
			}
		}

		return true;
	}

	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public Node find(int d) {
		if (d == data) {
			return this;
		} else if (d < data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	private static Node createMinimalBST(int arr[], int start, int end){
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node n = new Node(arr[mid]);
		n.left = createMinimalBST(arr, start, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, end);
		return n;
	}

	public static Node createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}

}
