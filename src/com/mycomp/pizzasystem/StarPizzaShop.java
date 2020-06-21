package com.mycomp.pizzasystem;

import java.util.Scanner;

public class StarPizzaShop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("*****Welcome to the STAR Pizaria ******");

		boolean more = true;
		while (more) {
			System.out.println("What kind of pizza would you like (Veg or Non-veg) : ");
			String category = sc.next();

			String type = "";
			if (category.equalsIgnoreCase("veg")) {
				System.out.println("What type of pizza would you like (VegStuffed or VegNotStufed) :");
				type = sc.next();
			} else {
				System.out.println("What type of pizza would you like (NonVegStuffed or NonVegNotStufed) :");
				type = sc.next();
			}
			
			String size;
			while (true) {
				System.out.println("What size of pizza would you like to order (for Small type(S) | Medium (M) | Large (L)): ");
				size = sc.next();
				if(size.equalsIgnoreCase("S") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L")
						|| size.equalsIgnoreCase("Small") || size.equalsIgnoreCase("Medium") || size.equalsIgnoreCase("Large")) {
					break;
				}
				System.out.println("***Enter a valid Letter like -  S | M | L OR Valid Name like -  Small | Medium | Large ***");
			}
			
			System.out.println("What topping would you like to add : ");
			String topping = sc.next();
			// String [] toppings = sc.nextLine();

			/*
			 *  \d is a digit (a character in the range 0-9), and + means 1 or more times. So, \d+ is 1 or more digits.
			 */
			String regex = "\\d+";
			int itemId = 0;
			while (true) {
				System.out.println("Enter the item Id : ");
				String id = sc.next();
				if (id.matches(regex)) {
					itemId = Integer.parseInt(id);
					break;
				}
				System.out.println("***Enter numbers only***");
			}

			Pizza order;
			if (category.equalsIgnoreCase("veg")) {
				order = new Veg(itemId, category, type, size, topping);
			} else {
				order = new NonVeg(itemId, category, type, size, topping);
			}

			try {
				float total = order.calculateBillAmmount(type, size);
				int billId = order.getBillId();
				System.out.println("Bill Id : " + billId);
				System.out.println("Your Order Total is (RS): " + total);
			} catch (ValidationError e) {
				System.out.println(e.getMessage());
			}

			// if something wrong and customer ask for more orders
			System.out.println("Would you like to place more orders ( Y | N ): ");
			String moreWord = sc.next();

			if (moreWord.equalsIgnoreCase("Y")) {
				more = true;
			} else {
				more = false;
			}
		}
		System.out.println("---------THANK YOU.. & COME AGAIN..-----------");
	}

	
	
	/*	
	 * to format number as a currency
	 * 
	 *	   	NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
     * 		String currency = format.format(number);
     * 		System.out.println("Currency in Canada : " + currency);
     * 
	 */
	
}
