package com.greatlearning.iitr.fullstacklearning.algo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CurrencyResolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the size of currency denominations");
		Scanner myObj = new Scanner(System.in);
		try {
			//Fetch the no of denominations user has
			Integer noOfCurrencyDenominations = Integer.parseInt(myObj.nextLine());
			
			//Fetch the currency values and put in a list
			System.out.println("Enter the currency denominations value");
			List<Integer> currencyList = new LinkedList<Integer>();
			for (int index = 1; index <= noOfCurrencyDenominations; index++) {
				Integer currencyVal = Integer.parseInt(myObj.nextLine());
				currencyList.add(currencyVal);
			}
			
			//Sort in the list in descending order
			Collections.sort(currencyList, Collections.reverseOrder());
			
			System.out.println("\n");
			System.out.println("Enter the amount you want to pay");
			
			//Fetch the amount to pay
			Integer amtToPay = Integer.parseInt(myObj.nextLine());

			Map<Integer, Integer> currencyMap = new HashMap<Integer, Integer>();

			//Run the greedy algorithm
			for (int k = 0; k < currencyList.size(); k++) {
				if (amtToPay >= currencyList.get(k)) {
					Integer result = amtToPay / currencyList.get(k);
					amtToPay = amtToPay % currencyList.get(k);
					//Create a map and put the currency as key and their nos as value of the currency
					currencyMap.put(currencyList.get(k), result);
				}

			}

			System.out.println("Your payment approach in order to give min no of notes will be");
			Iterator<Integer> itr = currencyMap.keySet().iterator();
			while (itr.hasNext()) {
				int key = (int) itr.next();
				System.out.println(key + " : " + currencyMap.get(key));
			}
		} finally {
			myObj.close();
		}
	}

}
