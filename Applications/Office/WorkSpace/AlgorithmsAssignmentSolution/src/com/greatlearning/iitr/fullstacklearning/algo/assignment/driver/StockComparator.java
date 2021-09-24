package com.greatlearning.iitr.fullstacklearning.algo.assignment.driver;

import java.util.Collections;
import java.util.List;

public class StockComparator {

	/**
	 * This method displays the stock prices 
	 * in ascending order
	 * @param stockPriceList
	 */
	public void displayStockPricesASCOrder(List<Double> stockPriceList) {
		 Collections.sort(stockPriceList);
		 System.out.println("Stock prices in ascending order are :");
		 System.out.println(" ");
		 for(int i =0;i<stockPriceList.size();i++) {
			 System.out.print(stockPriceList.get(i)+" ");
		 }
	}

	/**
	 * This method displays the stock prices
	 * in descending order
	 * @param stockPriceList
	 */
	public void displayStockPricesDESCOrder(List<Double> stockPriceList) {
		Collections.sort(stockPriceList,Collections.reverseOrder());
		 System.out.println("Stock prices in descending order are :");
		 System.out.println(" ");
		 for(int i =0;i<stockPriceList.size();i++) {
			 System.out.print(stockPriceList.get(i)+" ");
		 }
	}
	
	/**
	 * This method returns the number of companies for which
	 * the stockPrices have raised
	 * @param stockPriceChangedList
	 */
	public void calculateNoOfCompStockRise(List<Boolean> stockPriceChangedList) {
		Integer sum =0;
		for(int i = 0;i<stockPriceChangedList.size();i++) {
			//System.out.println(stockPriceChangedList.get(i));
			if(stockPriceChangedList.get(i)) {
				//System.out.println("inside loop "+ i);
				sum += 1;
			}
		}
		System.out.println("Total no of companies whose stock price rose today : "+sum);
		
	}
	
	/**
	 * This method returns the no of companies for which
	 * stock prices have been declined
	 * @param stockPriceChangedList
	 */
	public void calculateNoOfCompStockDecline(List<Boolean> stockPriceChangedList) {
		Integer sum =0;
		//System.out.println("stock price declined size ..."+stockPriceChangedList.size());		
		for(int i = 0;i<stockPriceChangedList.size();i++) {
			//System.out.println(stockPriceChangedList.get(i));
			if(!stockPriceChangedList.get(i)) {
				//System.out.println("inside false loop "+ i);
				sum += 1;
			}
		}
		System.out.println("Total no of companies whose stock price declined today : "+sum);
		
	}

}
