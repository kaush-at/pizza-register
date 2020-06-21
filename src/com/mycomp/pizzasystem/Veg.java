package com.mycomp.pizzasystem;

public class Veg extends Pizza {

	private String vegToppings;
	// private String[] toppings;
	static int counter;

	public Veg(int itemId, String category, String type, String size, String vegToppings) {
		super(itemId, category, type, size);
		this.vegToppings = vegToppings;
		Veg.counter = getBillId();
	}

	public String getVegToppings() {
		return vegToppings;
	}

	// for validate veg pizza type
	public boolean validateType(String type) {
		if (type.equalsIgnoreCase("VegStuffed") || type.equalsIgnoreCase("VegNotStuffed")) {
			return true;
		}
		return false;
	}

	@Override // tou can remove this if sir approved
	public boolean validateType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float identifyCost(String type, String size) throws ValidationError {
		float price = 0;
		if ( (validateType(type) && validateSize(size)) && (type.equalsIgnoreCase("VegStuffed")) ){
			if(size.equalsIgnoreCase("S") || size.equalsIgnoreCase("Small")) {
				price = 30.0F;
			} else if (size.equalsIgnoreCase("M") || size.equalsIgnoreCase("Medium")) {
				price = 60.0F;
			} else if(size.equalsIgnoreCase("L") || size.equalsIgnoreCase("Large")) {
				price = 90.0F;
			}
		} else if((validateType(type) && validateSize(size)) && (type.equalsIgnoreCase("VegNotStuffed"))) {
			if(size.equalsIgnoreCase("S") || size.equalsIgnoreCase("Small")) {
				price = 20.0F;
			} else if (size.equalsIgnoreCase("M") || size.equalsIgnoreCase("Medium")) {
				price = 40.0F;
			} else if(size.equalsIgnoreCase("L") || size.equalsIgnoreCase("Large")) {
				price = 80.0F;
			}
		}else {
			throw new ValidationError("Check the pizza type and Size again");
		}
		return price;
	}

	@Override // you can remove this if sir approved
	public float identifyCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override // you can remove this
	public float calculateBillAmmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public float calculateBillAmmount(String type, String size) throws ValidationError {
		float billAmount;
		
		float price = 0;
		if(!validateType(type)) {
			throw new ValidationError("Invalid Pizza type,therefore cost of pizza cannot be calculated");
		}else {
			float taxPercentage = 5;
			price = identifyCost(type, size);
			billAmount = price + (price * taxPercentage)/100;
			
		}
		return billAmount;
	}



}
