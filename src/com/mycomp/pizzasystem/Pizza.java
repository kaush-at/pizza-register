package com.mycomp.pizzasystem;

public abstract class Pizza {

	private int itemId;
	private int billId;
	private String category;
	private String type;
	private String size;
	static int id = 1	;

	public Pizza(int itemId, String category, String type, String size) {
		super();
		this.itemId = itemId;
		this.billId = id++;
		this.category = category;
		this.type = type;
		this.size = size;
	}

	public int getItemId() {
		return itemId;
	}

	public int getBillId() {
		return billId;
	}

	public String getCategory() {
		return category;
	}

	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	// validating the pizza category
	public boolean validateCategory(String category){
		if(category.equalsIgnoreCase("veg") || category.equalsIgnoreCase("non-veg")) {
			return true;
		}
		return false;
	}

	// validating pizza size
	public boolean validateSize(String size) {
		if(size.equalsIgnoreCase("S") || size.equalsIgnoreCase("Small") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("Medium")
				|| size.equalsIgnoreCase("L") || size.equalsIgnoreCase("Large")) {
			return true;
		}
		return false;
	}

	public abstract boolean validateType();

	// extra one added by me
	public abstract boolean validateType(String type);
	
	// extra one added by me
	public abstract float identifyCost(String type, String size) throws ValidationError;
	
	public abstract float identifyCost();

	public abstract float calculateBillAmmount();

	public abstract float calculateBillAmmount(String type, String size) throws ValidationError;

	

}
