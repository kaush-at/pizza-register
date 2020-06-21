package com.mycomp.pizzasystem;

public class NonVeg extends Pizza {

	private String nonVegTopppings;
	// private String[] nonVegTopppings;
	static int counter;

	public NonVeg(int itemId, String category, String type, String size, String nonVegTopppings) {
		super(itemId, category, type, size);
		this.nonVegTopppings = nonVegTopppings;
		//this.counter = getBillId();
		NonVeg.counter = getBillId();
	}

	public String getNonVegTopppings() {
		return nonVegTopppings;
	}

	// for validate non-veg pizza type
	public boolean validateType(String type) {
		if (type.equalsIgnoreCase("NonVegStuffed") || type.equalsIgnoreCase("NonVegNotStuffed")) {
			return true;
		}
		return false;
	}

	// to get the price for the pizza
	@Override
	public float identifyCost(String type, String size) throws ValidationError {
		float price = 0;
		if ((validateType(type) && validateSize(size)) && (type.equalsIgnoreCase("NonVegStuffed"))) {
			if (size.equalsIgnoreCase("S") || size.equalsIgnoreCase("Small")) {
				price = 50.0F;
			} else if (size.equalsIgnoreCase("M") || size.equalsIgnoreCase("Medium")) {
				price = 100.0F;
			} else if (size.equalsIgnoreCase("L") || size.equalsIgnoreCase("Large")) {
				price = 150.0F;
			}
		} else if ((validateType(type) && validateSize(size)) && (type.equalsIgnoreCase("NonVegNotStuffed"))) {
			if (size.equalsIgnoreCase("S") || size.equalsIgnoreCase("Small")) {
				price = 40.0F;
			} else if (size.equalsIgnoreCase("M") || size.equalsIgnoreCase("Medium")) {
				price = 80.0F;
			} else if (size.equalsIgnoreCase("L") || size.equalsIgnoreCase("Large")) {
				price = 120.0F;
			}
		} else {
			throw new ValidationError("Check the pizza type and Size again");
		}
		return price;
	}

	// calculate the bill amount
	@Override
	public float calculateBillAmmount(String type, String size) throws ValidationError {
		float billAmount;

		float price = 0;
		if (!validateType(type)) {
			throw new ValidationError("Invalid Pizza type,therefore cost of pizza cannot be calculated");
		} else {
			float taxPercentage = 10;
			price = identifyCost(type, size);
			billAmount = price + (price * taxPercentage) / 100;

		}
		return billAmount;
	}

	
	@Override // you can remove this if approved
	public boolean validateType() {
		// without param
		return false;
	}
	
	@Override // // you can remove this if approved
	public float identifyCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float calculateBillAmmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
