package com.greatlearning.iitr.fullstacklearning.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionsResolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the size of transaction array");
		Scanner myObj = new Scanner(System.in);
		try {
			System.out.println("Enter the values of array");
			String arrayNumbers = myObj.nextLine();
			String[] arrNumbers = arrayNumbers.split(" ");
			List<Integer> trList = new ArrayList<Integer>();
			for (int i = 0; i < arrNumbers.length; i++) {
				Integer index = Integer.parseInt(arrNumbers[i]);
				trList.add(index);
			}
			// System.out.println("the arrayis ...." + trList);
			System.out.println("Enter the total no of targets that needs to be achieved");
			System.out.println("\n");
			Integer noOfTargets = Integer.parseInt(myObj.nextLine());

			for (int j = 0; j < noOfTargets; j++) {
				System.out.println("\n");
				System.out.println("Enter the value of target");
				Integer targetVal = Integer.parseInt(myObj.nextLine());
				Integer result = determineNoOfTransactions(trList, targetVal);
				if (result != -1) {
					System.out.println("Target achieved after " + result + " transactions");
				} else {
					System.out.println("The given target is not achieved");
				}
			}
		} finally {
			myObj.close();
		}

	}

	/**
	 * This method returns the index of the number or sum of the numbers in the
	 * array till which the target is less
	 * 
	 * @param trList
	 * @param targetVal
	 * @return
	 */
	public static Integer determineNoOfTransactions(List<Integer> trList, Integer targetVal) {
		int index = -1;
		for (int i = 0; i < trList.size(); i++) {
			if (i == 0 && targetVal < trList.get(i)) {
				index = i + 1;
				break;
			} else if (targetVal < sum(trList, i)) {
				index = i + 1;
				break;
			}
		}
		return index;
	}

	/**
	 * This method calculates the sum of the array till a certain number
	 * 
	 * @param trList
	 * @param i
	 * @return
	 */
	public static Integer sum(List<Integer> trList, Integer i) {
		Integer sumresult = 0;
		for (int counter = 0; counter <= i; counter++) {
			sumresult = sumresult + trList.get(counter);
		}
		return sumresult;
	}

}
