package com.greatlearning.iitr.fullstacklearning.algo.assignment.console;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.greatlearning.iitr.fullstacklearning.algo.assignment.driver.StockChecker;
import com.greatlearning.iitr.fullstacklearning.algo.assignment.driver.StockComparator;

public class StockConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the no of companies");
		Scanner myObj = new Scanner(System.in);
		try {
			Integer optNo = 8;
			Integer noOfCompanies = Integer.parseInt(myObj.nextLine());
			List<Double> stockPriceList = new LinkedList<Double>();
			List<Boolean> stockPriceChangedList = new LinkedList<Boolean>();
			for (int index = 1; index <= noOfCompanies; index++) {
				System.out.println("Enter current stock price of the company " + index);
				Double stockPrice = Double.parseDouble(myObj.nextLine());
				stockPriceList.add(stockPrice);
				System.out.println("Whether company's stock price rose today compare to yesterday?");
				Boolean priceChangedFlag = new Boolean(myObj.nextLine());
				stockPriceChangedList.add(priceChangedFlag);
			}
			// System.out.println(stockPriceChangedList);
			// System.out.println(stockPriceList);
			displayOperations();
			while (optNo != 0) {
				optNo = Integer.parseInt(myObj.nextLine());
				performOperations(optNo,stockPriceList,stockPriceChangedList,myObj);
				displayOperations();
			}

		} finally {
			myObj.close();
		}

	}

	/**
	 * This method is used to display multiple 
	 * operations options which user want to 
	 * perform
	 */
	static void displayOperations() {
		System.out.println(" ");
		System.out.println("================================");
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. press 0 to exit");
		System.out.println("================================");
	}

	/**
	 * This method is used to capture user operation
	 * and invoke the correct method
	 * @param optNo
	 * @param stockPriceList
	 * @param stockPriceChangedList
	 */
	static void performOperations(Integer optNo,List<Double> stockPriceList,List<Boolean> stockPriceChangedList,Scanner myObj) {
		switch (optNo) {
		// Case statements
		case 1:
			//System.out.println("you selected option 1");
			new StockComparator().displayStockPricesASCOrder(stockPriceList);
			break;
		case 2:
			//System.out.println("you selected option 2");
			new StockComparator().displayStockPricesDESCOrder(stockPriceList);
			break;
		case 3:
			//System.out.println("you selected option 3");
			new StockComparator().calculateNoOfCompStockRise(stockPriceChangedList);
			break;
		case 4:
			//System.out.println("you selected option 4");
			new StockComparator().calculateNoOfCompStockDecline(stockPriceChangedList);
			break;
		case 5:
			//System.out.println("you selected option 5");
			System.out.println("Enter the key value");
			new StockChecker().checkStockValue(myObj,stockPriceList);
			break;
		case 0:
			System.out.println("you selected option 0.you will be exited from the app");
			System.exit(1);

		default:
			System.out.println("Please select a valid option");
			
		}

	}
}
