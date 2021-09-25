package com.greatlearning.iitr.fullstacklearning.algo.assignment.driver;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StockChecker {

	/**
	 * This method does not use the conventional 
	 * contains method of Java and it first sorts 
	 * the elements in ascending order and checks in case 
	 * the element is less than the first element or greater than the
	 * last element  i.e. the element is not present in list.
	 * Then it checks the difference of the entered element with
	 * first element and last element . If the first difference is smaller
	 * than the second difference, then it starts liner search from the sorted list 
	 * in ascending order. But in case the difference is found to be larger, then 
	 * it sorts the list again in descending order and performs the linear search
	 * @param myObj
	 * @param stockPriceList
	 */
	public void checkStockValue(Scanner myObj,List<Double> stockPriceList) {
		Double stockVal = Double.parseDouble(myObj.nextLine());
		//System.out.println("The entered value is stockVal "+stockVal);
		Collections.sort(stockPriceList);
		int listLength = stockPriceList.size();
		Double firstElement = stockPriceList.get(0);
		Double lastElement = stockPriceList.get(listLength-1);
		String msg = "";
		
		if((stockVal < firstElement) || (stockVal > lastElement) ) {
			//System.out.println("Out of range");
			msg = "Value not found";
		}
		else {
			if((stockVal - firstElement) < (lastElement - stockVal)) {
				for(int i = 0; i<stockPriceList.size();i++) {
					if(stockVal.equals(stockPriceList.get(i))) {
						//System.out.println("found in list");
						//System.out.println("Stock of Value "+stockVal+ " is present");
						msg = "Stock of Value "+stockVal+ " is present";
						break;
					}else {
						//System.out.println("not found inside range");
						//System.out.println("Value not found");
						msg = "Value not found";
					}
				}
			}else {
				Collections.sort(stockPriceList,Collections.reverseOrder());
				for(int i = 0; i<stockPriceList.size();i++) {
					if(stockVal.equals(stockPriceList.get(i))) {
						//System.out.println("found in reverse list");
						//System.out.println("Stock of Value "+stockVal+ " is present");
						msg = "Stock of Value "+stockVal+ " is present";
						break;
					}else {
						//System.out.println("Not found in reverse order range");
						//System.out.println("Value not found");
						msg = "Value not found";
					}
				}
			}
		}
		System.out.println(msg);
	}
}
