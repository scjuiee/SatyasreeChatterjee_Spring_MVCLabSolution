package com.greatlearning.iitr.fullstacklearning.dsasolution;

import java.util.ArrayList;

public class DetermineLongestTreePath {

	/**
	 * 
	 * @author satyasreechatterjee
	 *
	 */
	static class Node {
		int data;
		Node left;
		Node right;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	static Node createNewNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;

		return node;
	}

	/**
	 * a
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> determineLongestPath(Node root) {

		// If root is null means there
		// is no binary tree so
		// return a empty vector
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		// Recursive call on root.right
		ArrayList<Integer> right = determineLongestPath(root.right);

		// Recursive call on root.left
		ArrayList<Integer> left = determineLongestPath(root.left);

		// Compare the size of the two ArrayList
		// and insert current node accordingly
		if (right.size() < left.size()) {
			left.add(root.data);
		} else {
			right.add(root.data);
		}

		// Return the appropriate ArrayList
		return (left.size() > right.size() ? left : right);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createNewNode(100);
		root.left = createNewNode(20);
		root.right = createNewNode(130);
		root.left.left = createNewNode(10);
		root.left.right = createNewNode(50);
		root.right.left = createNewNode(110);
		root.right.right = createNewNode(140);
		root.left.left.left = createNewNode(5);

		ArrayList<Integer> output = determineLongestPath(root);
		int n = output.size();
		System.out.println(" the longest path size is ..." + n);

		for (int i = output.size() - 1; i >= 0; i--) {
			System.out.print(output.get(i) + "  ");
		}
	}

}
