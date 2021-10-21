package com.greatlearning.ds.solution;

class Node {
	int val;
	Node left, right;

	// Helper function that allocates a new node
	// with the given data and NULL left and right
	// pointers.
	Node(int item) {
		val = item;
		left = right = null;
	}
}

public class SkewedTreeConverter {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;
	static int index = 0;

	// Function to to flatten the binary
	// search tree into a skewed tree in
	// increasing / decreasing order
	static void flattenBST(Node root, int order) {

		// Base Case
		if (root == null) {
			return;
		}

		// Condition to check the order
		// in which the skewed tree to
		// maintained
		if (order > 0) {
			flattenBST(root.right, order);
		} else {
			flattenBST(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		// Condition to check if the root Node
		// of the skewed tree is not defined
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		// Similarly recurse for the left / right
		// subtree on the basis of the order required
		if (order > 0) {
			flattenBST(leftNode, order);
		} else {
			flattenBST(rightNode, order);
		}
	}

	// Function to traverse the right
	// skewed tree using recursion
	static void traverseRightSkewed(Node root, int order) {
		Node tempNode;
		if (root == null) {
			return;
		}
		if (order == 0) {
			if ((root != null && root.right != null) && (root.val > root.right.val)) {
				tempNode = root;
				root = root.right;
				tempNode.right = root.right;
				root.right = tempNode;
			}
			System.out.print(root.val + " ");
			if (root.right != null) {
				if (index == 0) {
					traverseRightSkewed(root.right, order);
				}
				index++;
			}
		}else {
			if ((root != null && root.right != null) && (root.val < root.right.val)) {
				tempNode = root;
				root = root.right;
				tempNode.right = root.right;
				root.right = tempNode;
			}
			System.out.print(root.val + " ");
			if (root.right != null) {
				if (index == 0) {
					traverseRightSkewed(root.right, order);
				}
				index++;
			}
		}
	}

	// Driver Code
	public static void main(String[] args) {

		SkewedTreeConverter tree = new SkewedTreeConverter();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(40);

		// For Increasing order - 0
		// For Decreasing order - 1
		int order = 0;
		flattenBST(node, order);
		traverseRightSkewed(headNode, order);
	}
}
